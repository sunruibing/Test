package com.servlet.remind;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.RemindService;




/**
 * 删除一段用药提醒
 * 
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年10月14日
 */
@WebServlet(name="DeleteRemindListByTimeStamp", urlPatterns={"/DeleteRemindListByTimeStamp"})
public class DeleteRemindListByTimeStamp extends HttpServlet {

	private static final long serialVersionUID = -6978555362445441521L;
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String timeStamp = request.getParameter("timeStamp");
		
		int msg = new RemindService().deleteRemindListByTimeStamp(timeStamp);
	
		if(1 == msg){
			response.getWriter().print(0);//success
		}else{
			response.getWriter().print(2);//error
		}
	}
	
	
	
}
