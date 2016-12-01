package com.servlet.health;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.po.Health;
import com.service.CalendarService;
import com.service.HealthService;



/**
 * 添加健康状况记录
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年10月7日
 */
@WebServlet(name="AddHealth", urlPatterns={"/AddHealth"})
public class AddHealth extends HttpServlet {

	private static final long serialVersionUID = 6203011589079491306L;

	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		
		String createDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		Integer userId = Integer.parseInt(request.getParameter("userId"));
		
		
		Health health = new Health();
		health.setCreateDate(createDate);
		health.setTag(request.getParameter("tag"));
		health.setContent(request.getParameter("content"));
		health.setUserId(userId);
		
		
		HealthService healthService = new HealthService();
		
		try {
			
			Integer healthId = healthService.queryHealthByDateAndUserId(createDate, userId);//根据日期和用户id查询记录
			
			
			if(0 == healthId){//不存在
				
				int msg = healthService.insertHealth(health);//添加记录
				
				if(1 == msg){
					
					response.getWriter().print(0);//success
					
					
					Integer DBhealthId = healthService.queryHealthByDateAndUserId(createDate, userId);
					
					
					CalendarService calendarService = new CalendarService();
					Integer calendarId = calendarService.queryCalendarIdByDateAndUserId(createDate, userId);
					
					
					if(0 == calendarId){//没有记录
						
						calendarService.insertHealthId(createDate, DBhealthId, userId);//添加记录
						
					}else{//有记录
						
						calendarService.updateHealthId(createDate, DBhealthId, userId);//更新记录
					}
				}else{
					response.getWriter().print(2);//error 添加数据失败
				}
			}else{//存在
				response.getWriter().print(1);//记录已存在
			}
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().print(2);//SQL error
		}
	}
	
	
	
}
