package com.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.po.User;
import com.service.UserService;

import redis.clients.jedis.Jedis;



/**
 * 绑定手机
 *@author sun
 *
 */
@WebServlet(name = "BindingPhone", urlPatterns = { "/BindingPhone" })
public class BindingPhone extends HttpServlet {

	private static final long serialVersionUID = -2024535499763819269L;

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request, response);
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		@SuppressWarnings("resource")
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		
		
		request.setCharacterEncoding("utf-8");// 设置请求编码格式

		
		String code = request.getParameter("code");// 获取验证码
		//System.out.println(code);
		String phone = request.getParameter("phone");// 获取手机号
		//System.out.println(phone);
		

		
		// 设置响应格式及编码
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");

		
		if (code != null && jedis.get(phone).equals(code)){// 判断验证码是否正确
			
			Integer id = Integer.parseInt(request.getParameter("id"));// 获取用户id并转成Integer类型
			
			
			try {
				UserService userService = new UserService();
				User user = userService.queryUserById(id);
				
				String mobileNumber = user.getPhone();
				if (mobileNumber != null || "".equals(mobileNumber)) {// 判断用户是否绑定
					
					int msg = userService.insertBinding(id, phone);
					
					if (msg == 1) {
						response.getWriter().print(0);// 绑定成功
					} else {
						response.getWriter().print(2);// 绑定失败
					}
				}
				response.getWriter().print(1);// 已绑定手机
			} catch (Exception e) {
				response.getWriter().print(2);// 添加数据库失败
			}
		} else {
			response.getWriter().print(1);// 验证码不能为空并且要跟接收的验证码一致
		}
	}
	

}