package com.servlet.cyclopedia;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.service.DiseaseService;



/**
 * 根据疾病名查询疾病详情介绍
 *@author FFFF
 *
 */
@WebServlet(name="FindDiseaseByName",urlPatterns={"/FindDiseaseByName"})
public class FindDiseaseByName extends HttpServlet {

	private static final long serialVersionUID = 4499499373998524521L;
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		
		try {
			
			List<Object> disease = new DiseaseService().queryDisease(request.getParameter("diseaseName"));
			
			response.getWriter().print(new Gson().toJson(disease));//success

		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().print(2);//error
		}
	}

	
	
}
