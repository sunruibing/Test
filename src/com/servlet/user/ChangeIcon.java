package com.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.UserService;



/**
 * 修改头像
 *@author FFFF
 *
 */
@WebServlet(name="ChangeIcon", urlPatterns={ "/changeIcon" })
public class ChangeIcon extends HttpServlet {

	private static final long serialVersionUID = -4484680637966173903L;

	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		
		Integer id = Integer.parseInt(request.getParameter("userId"));
		String fileName = request.getParameter("fileName");
		
		
		UserService userService = new UserService();

		int msg = userService.updataIcon(id,"http://ogtsfrmaa.bkt.clouddn.com/"+fileName+"");
		
		
		if (1 == msg ){
			response.getWriter().print(0);//success
		}else{
			response.getWriter().print(2);//error
		}
	}
	
	
	
}
