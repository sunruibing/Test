package com.servlet.calendar;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.CalendarService;



/**
 * 查询日历
 * 
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年10月11日
 */
@WebServlet(name="FindCalendarList", urlPatterns={"/FindCalendarList"})
public class FindCalendarList extends HttpServlet {

	private static final long serialVersionUID = 2870997889555022399L;

	
	
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
			List<Map<String, Object>> calendarList = new CalendarService().queryCalendarListByDateAndUserId(date, userId);
			
			response.getWriter().print(calendarList);//success
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.getWriter().print(2);//NumberFormat error
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().print(2);//SQL error
		}
	}
	
	
	
}
