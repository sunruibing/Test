package com.servlet.banner;

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
import com.service.BannerService;



/**
 * 疾病库
 * 
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年10月29日
 */
@WebServlet(name="FindBannerListByCategoryCode2", urlPatterns={"/FindBannerListByCategoryCode2"})
public class FindBannerListByCategoryCode2 extends HttpServlet {

	private static final long serialVersionUID = -6073319232883538060L;
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		
		try {
			
			List<Map<String, Object>> banner = new BannerService().queryBannerListByCategory1();
			
			response.getWriter().print(new Gson().toJson(banner));//success
			
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().print(2);//error
		}
	}
	
	
	
	@Override
	public void destroy() {
		super.destroy();
	}
}
