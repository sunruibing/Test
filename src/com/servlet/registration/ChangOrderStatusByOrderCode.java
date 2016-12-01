package com.servlet.registration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.po.Registration;
import com.service.CalendarService;
import com.service.RegistrationService;



/**
 * 根据订单号修改订单状态
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年9月27日
 */
@WebServlet(name="ChangOrderStatusByOrderCode", urlPatterns={"/ChangOrderStatusByOrderCode"})
public class ChangOrderStatusByOrderCode extends HttpServlet {

	private static final long serialVersionUID = 714542655633932716L;

	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		
		String orderCode = request.getParameter("orderCode");
		String status = request.getParameter("status");
		
		
		RegistrationService registrationService = new RegistrationService();
		
		
		if(status != null && "已取消".equals(status)){
			
			Registration registration = registrationService.queryRegistrationIdByOrderCode(orderCode);
			
			
			int msg = new CalendarService().updateRegistrationId(registration.getUserId(), registration.getId());
			
			if(1 == msg){
				registrationService.updataOrderStatusByOrderCode(orderCode, status);
				
				response.getWriter().print(0);//success
			}else{
				response.getWriter().print(2);//error
			}
		}else{
			int msg = registrationService.updataOrderStatusByOrderCode(orderCode, status);
			
			if(1 == msg){
				response.getWriter().print(0);//success
			}else{
				response.getWriter().print(2);//error
			}
		}
	}
	
	
	
}
