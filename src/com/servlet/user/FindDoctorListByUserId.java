package com.servlet.user;

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
import com.service.DoctorService;



/**
 * 我的-->我的医生
 * 根据用户id来查询此用户的所有医生
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年9月22日
 */
@WebServlet(name="FindDoctorListByUserId", urlPatterns={"/FindDoctorListByUserId"})
public class FindDoctorListByUserId extends HttpServlet {

	private static final long serialVersionUID = -5603994507668391556L;

	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		
		try {
			List<Map<String, Object>> DoctorList = new DoctorService().queryDoctorListByUserId(Integer.parseInt(request.getParameter("userId")));
			
			
			response.getWriter().print(new Gson().toJson(DoctorList));//success
			
		}catch (NumberFormatException e) {
			e.printStackTrace();
			response.getWriter().print(2);//NumberFormat error
		}catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().print(2);//SQL error
		}
	}
	
	
	
}
