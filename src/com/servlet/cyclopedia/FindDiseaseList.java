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
 * 根据科室id查询所有疾病
 *@author FFFF
 *
 */
@WebServlet(name="FindDiseaseList",urlPatterns={"/findDiseaseList"})
public class FindDiseaseList extends HttpServlet {
    
	private static final long serialVersionUID = 2098544415467479921L;
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	       
		Integer id =Integer.parseInt(request.getParameter("sectionId"));//获取科室id 
		Integer sectionId = ++id;
		
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		
		try {
			List<String> diseaseList = new DiseaseService().queryDiseaseList(sectionId);
			
			
			response.getWriter().print(new Gson().toJson(diseaseList));//success
			
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().print(2);//SQL error SQL执行报错
		}
	}
	
	
	
}
