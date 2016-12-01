package com.servlet.hot;

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
import com.service.HotService;

/**
 * 查询所有热点推荐
 * 
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年11月3日
 */
@WebServlet(name="FindAllHot", urlPatterns={"/FindAllHot"})
public class FindAllHot extends HttpServlet {

	private static final long serialVersionUID = 1244020544023743335L;
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		
		try {
			
			List<Map<String, Object>> list = new HotService().queryAllHot();
			
			response.getWriter().print(new Gson().toJson(list));//success
			
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().print(2);//error
		}
	}
	
	
	
}
