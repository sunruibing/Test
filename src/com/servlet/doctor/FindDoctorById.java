package com.servlet.doctor;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.po.Doctor;
import com.service.DoctorService;




/**
 * 根据医生id来查询此医生详细信息
 *@author FFFF
 * Put 
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年9月20日
 */
@WebServlet(name="FindDoctorById", urlPatterns={"/FindDoctorById"})
public class FindDoctorById extends HttpServlet {

	private static final long serialVersionUID = 938516935876439255L;

	
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");

		
		Integer doctorId = Integer.parseInt(request.getParameter("doctorId"));//获取医生id
		
		
		try {
			
			Doctor doctor = new DoctorService().queryDoctorById(doctorId);
			
			response.getWriter().print(new Gson().toJson(doctor));//success
			
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().print(2);//error
		}
    }
	
    
    
}
