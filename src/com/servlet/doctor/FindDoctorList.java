package com.servlet.doctor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.service.DoctorService;


/**
 * 查询所有医生
 *@author FFFF
 * Put 
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年9月20日
 */
@WebServlet(name="FindDoctorList", urlPatterns={"/FindDoctorList"})
public class FindDoctorList extends HttpServlet {

	private static final long serialVersionUID = -5130136019625537224L;
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		
		try {
			
			DoctorService doctorSercie = new DoctorService();
			List<Map<String, Object>> doctorList = doctorSercie.queryDoctorList();
			
			
			response.getWriter().print(new Gson().toJson(doctorList));//success
			
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().print(2);//error
		}
	}
	
	

}
