package com.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.po.User;
import com.google.gson.Gson;
import com.service.UserService;
import com.util.StringUtil;



/**
 * 用户登录
 *@author FFFF
 *
 */
@WebServlet(name="Login", urlPatterns={"/login"})
public class Login extends HttpServlet {

	private static final long serialVersionUID = -8081147951073848386L;
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		
		String phone = request.getParameter("phone");//获取手机号
		String password = StringUtil.MD5Encode(request.getParameter("password"));//获取密码
		
		
		try {
			if ((phone != null && password != null) && (!phone.isEmpty() && !password.isEmpty())) {//都不为空验证
				
				UserService userService = new UserService();
				User DBuser = userService.queryUserByPhone(phone);// 根据手机号查询用户
				
				
				if (password.equals(DBuser.getPassword())) {//判断密码是否正确
					
					DBuser.setPassword("");//清空密码
					
					
					String gson = new Gson().toJson(DBuser);
					
					response.getWriter().print(gson);//success;
					
				} else {
					response.getWriter().print(1);// 密码错误;
				}
			} else {
				response.getWriter().print(1);// 手机号或密码不能为空;
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().print(2);// 异常报错;
		}
	}
	
	
	
}
