package com.servlet.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.po.Registration;
import com.service.RegistrationService;



/**
 * 根据用户id和日期查询当天的异常状况
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年9月30日
 */
@WebServlet(name="FindUserIntradayByUserIdAndDate", urlPatterns={"/FindUserIntradayByUserIdAndDate"})
public class FindUserIntradayByUserIdAndDate extends HttpServlet {

	private static final long serialVersionUID = -3289018303629521382L;

	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		
		Integer userId = Integer.parseInt(request.getParameter("userId"));
		
		String date = request.getParameter("date");
		
		try {
			Registration registration = new RegistrationService().queryUserIntradayByUserIdAndDate(userId, date);
			
			response.getWriter().print(registration);
			
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().print(2);//error
		}
		
	}
	
	
	
}
