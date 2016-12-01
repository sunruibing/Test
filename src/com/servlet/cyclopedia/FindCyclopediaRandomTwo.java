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
import com.po.Cyclopedia;
import com.service.CyclopediaService;


/**
 * 随机查询两条记录
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
@WebServlet(name="FindCyclopediaRandomTwo", urlPatterns={"/FindCyclopediaRandomTwo"})
public class FindCyclopediaRandomTwo extends HttpServlet {

	private static final long serialVersionUID = -2797308579045677L;

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");
		
		
		try {
			
			List<Cyclopedia> cyclopediaList = new CyclopediaService().queryCyclopediaRandomTwo();
			
			resp.getWriter().print(new Gson().toJson(cyclopediaList));//success
			
		} catch (SQLException e) {
			e.printStackTrace();
			resp.getWriter().print(2);//error
		}
	}
	
	
	
}
