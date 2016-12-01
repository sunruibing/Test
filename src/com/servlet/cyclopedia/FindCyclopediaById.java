package com.servlet.cyclopedia;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.po.Cyclopedia;
import com.service.CyclopediaService;



/**
 * 百科文章
 * 根据文章id查询文章具体内容
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年9月22日
 */
@WebServlet(name="FindCyclopediaById",urlPatterns={"/FindCyclopediaById"})
public class FindCyclopediaById extends HttpServlet {

	private static final long serialVersionUID = 1569836164050539599L;

	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		
		try {
			
			CyclopediaService cycloperdiaService = new CyclopediaService();
			Cyclopedia cycloperdia = cycloperdiaService.queryCyclopediaById(Integer.parseInt(request.getParameter("cyclopediaId")));
			
			
			response.getWriter().print(new Gson().toJson(cycloperdia));//success
			
		}catch (NumberFormatException e) {
			e.printStackTrace();
			response.getWriter().println(2);//NumberFormat error 类型转换报错
		}catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().print(2);//SQL error SQL执行报错
		}
	}
	
	
	
}
