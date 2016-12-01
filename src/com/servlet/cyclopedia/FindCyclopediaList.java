package com.servlet.cyclopedia;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
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
 * 分页查询所有文章
 * 
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年9月22日
 */
@WebServlet(name="FindCyclopediaList", urlPatterns={"/FindCyclopediaList"})
public class FindCyclopediaList extends HttpServlet {

	private static final long serialVersionUID = -9179710498367782407L;

	
	
	@Override
	public void init() throws ServletException {
		super.init();
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		
		try {
			
			Integer pageCount = Integer.parseInt(request.getParameter("pageCount"));
			
			
			List<Cyclopedia> cycloperdiaList = new CyclopediaService().queryCylopediaList(pageCount);
			
			PrintWriter wr = response.getWriter();
			
			wr.print(new Gson().toJson(cycloperdiaList));//success
			wr.flush();
			
		}catch (NumberFormatException e) {
			e.printStackTrace();
			response.getWriter().println(2);//NumberFormat error 类型转换报错
		}catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().print(2);//SQL error SQL执行报错
		}
	}
	
	
	
	@Override
	public void destroy() {
		super.destroy();
		
		try{
	        DriverManager.deregisterDriver(DriverManager.getDrivers().nextElement());
	    }catch(Exception e){
	        e.printStackTrace();
	    }
	}
	
	
	
}
