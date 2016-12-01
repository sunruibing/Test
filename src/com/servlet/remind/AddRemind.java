package com.servlet.remind;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.po.Remind;
import com.service.CalendarService;
import com.service.RemindService;
import com.util.DateUtil;



/**
 * 添加用药提醒
 * 
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年10月12日
 */
@WebServlet(name="AddRemind", urlPatterns={"/AddRemind"})
public class AddRemind extends HttpServlet {

	private static final long serialVersionUID = -748573528225131756L;

	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		
		String startDay = request.getParameter("startDay");//开始日期
		String endDay = request.getParameter("endDay");//结束日期
		String time1 = request.getParameter("time1");
		String time2 = request.getParameter("time2");
		String time3 =  request.getParameter("time3");
		String content1 = request.getParameter("content1");
		String content2 = request.getParameter("content2");
		String content3 = request.getParameter("content3");
		Integer userId = Integer.parseInt(request.getParameter("userId"));
		String timestamp = String.valueOf(new Date().getTime());//时间戳
		
		
		RemindService remindService = new RemindService();
		
		
		try {
			
			Integer remindId = remindService.queryRemindIdByDateAndUserId(startDay, userId);//查询是否存在当前日期的记录
			
			
			if(0 == remindId){//不存在
				
				Remind remind = new Remind();
				remind.setTime1(time1);
				remind.setTime2(time2);
				remind.setTime3(time3);
				remind.setContent1(content1);
				remind.setContent2(content2);
				remind.setContent3(content3);
				remind.setUserId(userId);
				remind.setTimestamp(timestamp);
				
				
				int msg = 0;
				
				
				List<String> dateList = DateUtil.getTimeSlot(startDay, endDay);//获取时间段
				
				//遍历时间段并依次添加到数据库
				for(Iterator<String> i = dateList.iterator();i.hasNext();){
					
					String remindDate = i.next();
					
					remind.setRemindDate(remindDate);
					
					msg = remindService.insertRemindByUserId(remind);
				}
				
				
				if(1 == msg){//添加成功
					
					response.getWriter().print(0);//success
					
					
					CalendarService calendarService = new CalendarService();
					
					
					for(Iterator<String> i = dateList.iterator();i.hasNext();){//循环操作
						
						String remindDate = i.next();
						
						
						Integer DBremindId = remindService.queryRemindIdByDateAndUserId(remindDate, userId);//查询用药记录的id
						
						
						Integer calendarId = calendarService.queryCalendarIdByDateAndUserId(remindDate, userId);//在日历表中查询用药记录
						
						
						if(0 == calendarId){//没有用药记录
							
							calendarService.insertRemindId(remindDate, DBremindId, userId);//添加记录
							
						}else{//有用药记录
							
							calendarService.updateRemindId(remindDate, DBremindId, userId);//更新记录
							
						}
					}
					
				}else{
					response.getWriter().print(2);//error
				}
				
			}else{//存在
				response.getWriter().print(1);//记录已存在
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			response.getWriter().print(2);//SQL error
		} catch (ParseException e) {
			e.printStackTrace();
			response.getWriter().print(1);//Parse error
		}
	}
	
	
	
}
