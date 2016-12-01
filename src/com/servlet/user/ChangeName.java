package com.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.UserService;



/**
 * 修改昵称
 *@author sun
 *
 */
@WebServlet(name = "ChangeName", urlPatterns = { "/ChangeName" })
public class ChangeName extends HttpServlet {

	private static final long serialVersionUID = -1576081294072467603L;

	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request, response);
	}

	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		
		Integer id = Integer.parseInt(request.getParameter("id"));//获取id
		String name = request.getParameter("name");//获取用户名
		
		
		int msg = new UserService().updataUserName(id,name);

		if (1 == msg) {
			response.getWriter().print(0);//success
		} else {
			response.getWriter().print(2);//error
		}
	}
	
	
	
}