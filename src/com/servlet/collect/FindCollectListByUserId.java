package com.servlet.collect;

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
import com.service.CollectService;



/**
 * 根据用户id查询当前用户的所有收藏
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年9月21日
 */
@WebServlet(name = "FindCollectList", urlPatterns = { "/findCollectList" })
public class FindCollectListByUserId extends HttpServlet {
	
	private static final long serialVersionUID = -8048008609769835159L;

	
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		     doPost(request,response);
	}

	
	
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application.json");
		response.setCharacterEncoding("utf-8");
		
		
		try {
			
			List<Map<String, Object>> collectList = new CollectService().queryCollectListByUserId(Integer.parseInt(request.getParameter("userId")));
			
			
			response.getWriter().print(new Gson().toJson(collectList));//success
			
		}catch (NumberFormatException e) {
			e.printStackTrace();
			response.getWriter().println(2);//NumberFormat error 类型转换报错
		}catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().print(2);//SQL error SQL执行报错
		}
	}
	
	
}
