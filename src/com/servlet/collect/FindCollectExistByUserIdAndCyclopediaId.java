package com.servlet.collect;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.CollectService;



/**
 * 根据用户id和文章id来查询此文章是否已被当前用户收藏
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年9月22日
 */
@WebServlet(name="FindCollectExistByUserIdAndCyclopediaId", urlPatterns={"/FindCollectExistByUserIdAndCyclopediaId"})
public class FindCollectExistByUserIdAndCyclopediaId extends HttpServlet {

	private static final long serialVersionUID = -6574948651282553539L;
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			int msg = new CollectService().queryCollectByUserIdAndCyclopediaId(Integer.parseInt(request.getParameter("userId")), Integer.parseInt(request.getParameter("cyclopediaId")));
			
			if(msg == 0){
				response.getWriter().print(0);//未收藏
			}else{
				response.getWriter().print(1);//已收藏
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.getWriter().print(2);//NumberFormat error 类型转换报错
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().print(2);//SQL error SQL执行报错
		}
		
		
	}
	
	
	
}
