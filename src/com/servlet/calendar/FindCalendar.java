package com.servlet.calendar;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.service.CalendarService;



/**
 * 根据日期和用户id查询当天状态
 * 
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年10月13日
 */
@WebServlet(name="FindCalendar", urlPatterns={"/FindCalendar"})
public class FindCalendar extends HttpServlet {

	private static final long serialVersionUID = 6604040328113365630L;

	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		
		String date = request.getParameter("date");
		Integer userId = Integer.parseInt(request.getParameter("userId"));
		
		
		try {
			
			Map<String, Object> calendarMap = new CalendarService().queryCalendarByDateAndUserId(date, userId);
			
			response.getWriter().print(new Gson().toJson(calendarMap));//success
			
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().print(2);//error
		}
	}
	
	
	
}
