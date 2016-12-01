package com.servlet.registration;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.service.RegistrationService;



/**
 * 根据用户id查询用户的订单列表
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年9月21日
 */
@WebServlet(name="FindOrderListByUserId", urlPatterns={"/FindOrderListByUserId"})
public class FindOrderListByUserId extends HttpServlet {

	private static final long serialVersionUID = -5264789469381289039L;

	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		
		try {
			List<Map<String, Object>> registrationList = new RegistrationService().queryRegistrationListByUserId(Integer.parseInt(request.getParameter("userId")));
			
			
			response.getWriter().print(new Gson().toJson(registrationList));//success
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.getWriter().print(2);//error 类型转换报错
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().print(2);//error SQL执行报错
		}
	}
	
	
	
}
