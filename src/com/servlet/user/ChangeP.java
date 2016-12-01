package com.servlet.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.po.User;
import com.service.UserService;
import com.util.StringUtil;

import redis.clients.jedis.Jedis;



/**
 * pass
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
@WebServlet(name = "ChangeP", urlPatterns = { "/ChangeP" })
public class ChangeP extends HttpServlet {

	private static final long serialVersionUID = -7788979084844936792L;

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request, response);
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		@SuppressWarnings("resource")
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");

		
		UserService userservice = new UserService();
		
		
		String code = request.getParameter("code");
		String phone = request.getParameter("phone");
		
		
		if (code == null || "".equals(code)) {// 修改密码

			int id = Integer.parseInt(request.getParameter("id"));

			String oldPassword = StringUtil.MD5Encode(request.getParameter("oldPassword"));

			String newPassword = StringUtil.MD5Encode(request.getParameter("newPassword"));
			
			String pass = StringUtil.MD5Encode(request.getParameter("pass"));

			
			try {
				User user = userservice.queryUserById(id);

				if (oldPassword != null && user.getPassword().equals(oldPassword)) {//判断旧密码是否正确

					userservice.updataPassword(id, newPassword);
					
					response.getWriter().print(0);// success
					
				} else if(pass != null && !"".equals(pass)){//setting pass
					
					userservice.updataPassword(id, pass);
					
					response.getWriter().print(0);// success
					
				}else{
					response.getWriter().print(1);// error
				}
			} catch (SQLException e) {
				e.printStackTrace();
				response.getWriter().print(2);// error
			}
		} else if (code != null && jedis.get(phone).equals(code)) {// 忘记密码
			
			String password = StringUtil.MD5Encode(request.getParameter("password"));
			
			int msg = userservice.updataPassword(password, phone);
			
			if(1 == msg){
				response.getWriter().print(0);
			}else{
				response.getWriter().print(2);
			}
		} else {
			response.getWriter().print(1);//验证码不正确
		}
	}
	
	
	
}
