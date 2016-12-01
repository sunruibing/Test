package com.servlet.collect;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.CollectService;



/**
 * 查询文章被收藏数
 * 
 * @author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年11月21日
 */
@WebServlet(name="FindCollectCount", urlPatterns={"/FindCollectCount"})
public class FindCollectCount extends HttpServlet {

	private static final long serialVersionUID = 6593948767080831212L;
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");
		
		
		try {
			
			Integer cyclopediaId = Integer.parseInt(req.getParameter("cyclopediaId"));
			
			resp.getWriter().print(new CollectService().queryCollectCount(cyclopediaId));
			 
		} catch (NumberFormatException e) {
			e.printStackTrace();
			// TODO: handle exception
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		} 
	}
	
	
	
}
