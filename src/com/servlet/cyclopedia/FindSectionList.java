package com.servlet.cyclopedia;


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
import com.service.CyclopediaService;



/**
 * 查询所有科室
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年9月22日
 */
@WebServlet(name="FindSectionList",urlPatterns={"/FindSectionList"})
public class FindSectionList extends HttpServlet {

	private static final long serialVersionUID = -2550422734532722318L;

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		
		try {
			List<Map<String, String>> sectionList = new CyclopediaService().querySectionList();
			
			
			response.getWriter().print(new Gson().toJson(sectionList));//success
			
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().print(2);//SQL error SQL执行报错
		}
	}
	
	
}
