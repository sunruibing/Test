package com.servlet.user;

import java.io.IOException;
import java.sql.SQLException;

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
 * 一键登录
 * 
 * @author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年11月19日
 */
@WebServlet(name="OneLogin", urlPatterns={"/OneLogin"})
public class OneLogin extends HttpServlet {

	private static final long serialVersionUID = 7035452423507192672L;
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");
		
		
		String phone = req.getParameter("phone");
		String code = req.getParameter("code");
		
		
		@SuppressWarnings("resource")
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		
		
		if(code != null && code.equals(jedis.get(phone))){//The code if right.
			
			try {
				
				UserService userService = new UserService();
				
				User DBuser = userService.queryUserByPhone(phone);
				
				Gson gson = new Gson();
				
				
				if(DBuser.getPhone() == null || "".equals(DBuser.getPhone())){//nothing
					
					User user = new User();
					user.setPhone(phone);
					
					
					int msg = userService.addUser(user);
					
					if(1 == msg){
						User newUser = userService.queryUserByPhone(phone);
						newUser.setPassword("");
						
						resp.getWriter().print(gson.toJson(newUser));//success
					}else{
						resp.getWriter().print(2);//error
					}
				}else{
					DBuser.setPassword("");//clear pass
					
					resp.getWriter().print(gson.toJson(DBuser));//success
				}
			} catch (SQLException e) {
				e.printStackTrace();
				resp.getWriter().print(2);//SQLException
			}
		}else{
			resp.getWriter().print(1);//code error in app client
		}
	}
	
	
	
}
