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
 * 根据医生id来查询此医生的所有评论
 *@author FFFF
 * Put 
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年9月20日
 */
@WebServlet(name="FindDoctorCommentByDoctorId", urlPatterns={"/FindDoctorCommentByDoctorId"})
public class FindDoctorCommentByDoctorId extends HttpServlet {

	private static final long serialVersionUID = 7562044857590915910L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		
		Integer doctorId = Integer.parseInt(request.getParameter("doctorId"));//客户端请求过来的医生id
		
		
		try {
			List<Map<String, Object>> doctorCommentList = new DoctorService().queryThisDoctorAllCommentByDoctorId(doctorId);
			
			
			response.getWriter().print(new Gson().toJson(doctorCommentList));//success
			
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().print(2);//error
		}
	}
	
	
	
}
