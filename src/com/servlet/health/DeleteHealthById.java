package com.servlet.health;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.HealthService;


/**
 * 根据id删除一条健康记录
 * 
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年10月25日
 */
@WebServlet(name="DeleteHealthById", urlPatterns={"/DeleteHealthById"})
public class DeleteHealthById extends HttpServlet {

	private static final long serialVersionUID = 9071360080623484179L;

	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer healthId = Integer.parseInt(request.getParameter("healthId"));

		
		int msg = new HealthService().deleteHealthById(healthId);
		
		if(1 == msg){
			response.getWriter().print(0);//success
		}else{
			response.getWriter().print(2);//success
		}
	}
	
	
	
}
