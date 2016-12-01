package com.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.UserService;



/**
 * 修改性别
 *@author sun
 *
 */
@WebServlet(name="ChangeGender", urlPatterns={ "/ChangeGender" })
public class ChangeGender extends HttpServlet {
	
	private static final long serialVersionUID = -4816487222243979170L;
	
	
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request, response);
    }
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	request.setCharacterEncoding("utf-8");

    	
		Integer id = Integer.parseInt(request.getParameter("id"));// 获取id
		
		String gender = request.getParameter("gender");// 获取用户性别
		

		int msg = new UserService().updataUserGender(id, gender);
		
		if (1 == msg) {
			response.getWriter().print(0);// 成功
		} else {
			response.getWriter().print(2);// 失败
		}
	}
    
    
    
}
