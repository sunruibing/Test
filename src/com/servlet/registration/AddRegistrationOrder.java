package com.servlet.registration;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.po.Registration;
import com.service.CalendarService;
import com.service.RegistrationService;



/**
 * 添加挂号订单
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年9月21日
 */
@WebServlet(name="AddRegistrationOrder", urlPatterns={"/AddRegistrationOrder"})
public class AddRegistrationOrder extends HttpServlet {

	private static final long serialVersionUID = 8285734190247620532L;

	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		
		//生成的订单号
		String orderCode = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String createTime = request.getParameter("createTime");//订单创建时间
		String reservationDate = request.getParameter("time");//预约时间
		int userId = Integer.parseInt(request.getParameter("userId"));//用户id
		
		Registration registration = new Registration();
		registration.setCity(request.getParameter("city"));
		registration.setSection(request.getParameter("section"));
		registration.setTitle(request.getParameter("title"));
		registration.setReservationDate(reservationDate);//预约时间
		registration.setName(request.getParameter("name"));
		registration.setGender(request.getParameter("gender"));
		registration.setAge(request.getParameter("age"));
		registration.setPhone(request.getParameter("phone"));
		registration.setContent(request.getParameter("content"));
		registration.setMoney("25");
		registration.setOrderCode(orderCode);//订单号
		registration.setOrderStatus("待支付");
		registration.setUserId(userId);
		registration.setCreateTime(createTime);//订单创建时间
		
		
		RegistrationService registrationService = new RegistrationService();
		
			
		//添加订单成功后自动向日历表添加一条记录
		try {
			
			Integer registrationId = registrationService.queryRegistrationByDateAndUserId(reservationDate, userId);//根据日期和用户id来查询当天是否已有订单
			
			
			if(0 == registrationId){//订单不存在
				
				int msg = registrationService.insertRegistration(registration);//添加订单
				
				if(1 == msg){//添加成功
					
					response.getWriter().print(orderCode);//success
					
					
					Integer DBregistrationId = registrationService.queryRegistrationByDateAndUserId(reservationDate, userId);
					
					
					CalendarService calendarService = new CalendarService();
					Integer calendarId = calendarService.queryCalendarIdByDateAndUserId(reservationDate, userId);//查看此用户当天是否有日历记录
					
					
					if(0 == calendarId){//没有记录
						
						calendarService.insertRegistrationId(reservationDate, DBregistrationId, userId);//添加记录
						
					}else{//有记录
						
						calendarService.updateRegistrationId(reservationDate, DBregistrationId, userId);//更新记录
						
					}
				}else{
					response.getWriter().print(2);//error
				}
				
			}else{//订单存在
				response.getWriter().print(1);//订单已存在
			}
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().print(2);//SQL error
		}
	}
	
	
	
}
