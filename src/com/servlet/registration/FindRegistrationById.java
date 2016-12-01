package com.servlet.registration;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.po.Registration;
import com.service.RegistrationService;



/**
 * 我的预约模块：
 * 根据订单id来查询订单具体内容
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年9月21日
 */
@WebServlet(name="FindRegistrationById", urlPatterns={"/FindRegistrationById"})
public class FindRegistrationById extends HttpServlet {

	private static final long serialVersionUID = 4457075030293070550L;

	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		
		try {
			
			Registration registration = new RegistrationService().queryRegistrationById(Integer.parseInt(request.getParameter("id")));
			
			response.getWriter().print(new Gson().toJson(registration));//success
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.getWriter().print(2);//error 类型转换报错
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().print(2);//error SQL执行报错
		}
		
		
		
	}
	
	
	
}
