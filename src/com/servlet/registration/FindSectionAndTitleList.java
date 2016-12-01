package com.servlet.registration;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.service.RegistrationService;



/**
 * 一键挂号模块:
 * 查询科室和医生职称
 *@author FFFF
 * Put 
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年9月21日
 */
@WebServlet(name="FindSectionAndTitleList", urlPatterns={"/FindSectionAndTitleList"})
public class FindSectionAndTitleList extends HttpServlet {

	private static final long serialVersionUID = -7676825319065202952L;
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		
		RegistrationService registrationService = new RegistrationService();
		try {
			List<String> sectionList = registrationService.querySectionList();
			
			List<String> titleList = registrationService.queryTitleList();
			
			List<List<String>> list = new ArrayList<List<String>>();
			list.add(sectionList);
			list.add(titleList);
			
			
			response.getWriter().print(new Gson().toJson(list));//success 科室and职称
			
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().print(2);//error
		}
	}
	
	
	
}
