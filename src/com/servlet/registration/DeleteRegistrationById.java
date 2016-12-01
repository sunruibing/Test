package com.servlet.registration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.RegistrationService;

/**
 * 根据订单id删除订单
 * 
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年10月25日
 */
@WebServlet(name="DeleteRegistrationById", urlPatterns={"/DeleteRegistrationById"})
public class DeleteRegistrationById extends HttpServlet {

	private static final long serialVersionUID = -1588577943892708587L;

	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int msg = new RegistrationService().deleteRegistrationByOrderCode(request.getParameter("orderCode"));
		
		if(1 == msg){
			response.getWriter().print(0);//success
		}else{
			response.getWriter().print(2);//success
		}
	}
	
	
}
