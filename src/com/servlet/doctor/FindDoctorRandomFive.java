package com.servlet.doctor;

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
 * 随机查询5个医生
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年11月3日
 */
@WebServlet(name="FindDoctorRandomFive", urlPatterns={"/FindDoctorRandomFive"})
public class FindDoctorRandomFive extends HttpServlet {

	private static final long serialVersionUID = 658618495536544285L;

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");
		
		
		try {
			
			List<Map<String, Object>> list = new DoctorService().queryDoctorRandomFive();
			
			resp.getWriter().print(new Gson().toJson(list));//success
			
		} catch (SQLException e) {
			e.printStackTrace();
			resp.getWriter().print(2);//error
		}
	}
	
	
	
}
