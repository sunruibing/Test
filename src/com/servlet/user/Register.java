 package com.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.po.User;
import com.service.UserService;

import redis.clients.jedis.Jedis;



/**
 * 用户注册
 *@author FFFF
 *
 */
@WebServlet(name="Register",urlPatterns={"/register"})
public class Register extends HttpServlet {

	private static final long serialVersionUID = -2024535499763819269L;
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		@SuppressWarnings("resource")
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		
		
		request.setCharacterEncoding("utf-8");
		
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		
		String userJson = request.getParameter("user");
		String code = request.getParameter("code");//获取验证码
		
		
		User user = new Gson().fromJson(userJson, User.class);
		String phone = user.getPhone();
		
		
		if(code != null && jedis.get(phone).equals(code)){//判断验证码相关
			try {
				
				
				UserService userService = new UserService();
				User DBuser = userService.queryUserByPhone(user.getPhone());//查询用户是否注册过
				
				
				if(DBuser.getPhone() == null || "".equals(DBuser.getPhone())){//没有注册过
					
					int msg = userService.addUser(user);//添加用户
					
					if(1 == msg){
						response.getWriter().print(0);//成功
					}else{
						response.getWriter().print(2);//失败
					}
				}else{
					response.getWriter().print(1);//用户已注册
				}
			} catch (Exception e) {
				response.getWriter().print(2);//添加数据库失败
			}
		}else{
			response.getWriter().print(1);//验证码不能为空并且要跟接收的验证码一致
		}
	}
	
	
	
}
	
