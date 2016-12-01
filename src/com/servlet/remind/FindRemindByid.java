package com.servlet.remind;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.po.Remind;
import com.service.RemindService;

/**
 * 查询一条用药提醒
 * 
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年10月14日
 */
@WebServlet(name="FindRemindByid", urlPatterns={"/FindRemindByid"})
public class FindRemindByid extends HttpServlet {

	private static final long serialVersionUID = -8283111635491167945L;

	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		
		Integer remindId = Integer.parseInt(request.getParameter("remindId"));
		
		try {
			
			Remind remind = new RemindService().queryRemindById(remindId);
			
			response.getWriter().print(new Gson().toJson(remind));//success
			
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().print(2);//error
		}
		
	}
	
	
	
}
