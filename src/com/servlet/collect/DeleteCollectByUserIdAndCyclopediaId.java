package com.servlet.collect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.CollectService;

/**
 * 根据用户id和文章id删除我的收藏
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
@WebServlet(name="DeleteCollectByUserIdAndCyclopediaId", urlPatterns={"/DeleteCollectByUserIdAndCyclopediaId"})
public class DeleteCollectByUserIdAndCyclopediaId extends HttpServlet {

	private static final long serialVersionUID = 8603526831531756192L;

	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer userId = Integer.parseInt(request.getParameter("userId"));
		
		Integer cyclopediaId = Integer.parseInt(request.getParameter("cyclopediaId"));
		
		
		int msg = new CollectService().deleteCollectByUserIdAndCyclopediaId(userId, cyclopediaId);
		
		if(1 == msg){
			response.getWriter().print(0);//success
		}else{
			response.getWriter().print(2);//error
		}
	}
	
	
	
}
