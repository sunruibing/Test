package com.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.DoctorService;

/**
 * 添加我的医生
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
@WebServlet(name="AddMyDoctor", urlPatterns={"/AddMyDoctor"})
public class AddMyDoctor extends HttpServlet {

	private static final long serialVersionUID = 4361444693214760583L;

	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer userId = Integer.parseInt(request.getParameter("userId"));
		Integer doctorId = Integer.parseInt(request.getParameter("doctorId"));
		
		
		DoctorService doctorService = new DoctorService();
		
		
		Integer id = doctorService.queryMyDoctorByUserIdAndDoctorId(userId, doctorId);
		
		if(id != null && 0 == id){
			
			int msg = doctorService.insertMyDoctor(userId, doctorId);
			
			if(1 == msg){
				response.getWriter().print(0);//success
			}else{
				response.getWriter().print(2);//error
			}
		}else{
			response.getWriter().print(1);//数据已存在
		}
	}
	
	
	
}
