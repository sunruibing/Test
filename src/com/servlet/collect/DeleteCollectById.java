package com.servlet.collect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.CollectService;



/**
 * 根据id来删除我的收藏
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年9月30日
 */
@WebServlet(name="DeleteCollectById", urlPatterns={"/DeleteCollectById"})
public class DeleteCollectById extends HttpServlet {

	private static final long serialVersionUID = 8470091307690542263L;

	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int msg = new CollectService().deleteCollectById(Integer.parseInt(request.getParameter("id")));
		
		if(1 == msg){
			response.getWriter().print(0);//success
		}else{
			response.getWriter().print(2);//error
		}
	}
	
	
	
}
