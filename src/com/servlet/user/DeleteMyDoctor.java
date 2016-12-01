package com.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.DoctorService;

/**
 * 删除我的医生
 * 
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年10月27日
 */
@WebServlet(name="DeleteMyDoctor", urlPatterns={"/DeleteMyDoctor"})
public class DeleteMyDoctor extends HttpServlet {

	private static final long serialVersionUID = -1054464875692608456L;

	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer userId = Integer.parseInt(request.getParameter("userId"));
		Integer doctorId = Integer.parseInt(request.getParameter("doctorId"));
		
		
		int msg = new DoctorService().deleteMyDoctor(userId, doctorId);
		
		if(1 == msg){
			response.getWriter().print(0);//success
		}else{
			response.getWriter().print(2);//error
		}
	}
	
	
	
}
