package com.servlet.collect;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.po.Collect;
import com.service.CollectService;
import com.service.CyclopediaService;
import com.util.DateUtil;



/**
 * 根据用户id和文章id来添加收藏
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年9月21日
 */
@WebServlet(name="AddCollectByUserIdAndCyclopediaId", urlPatterns={"/AddCollectByUserIdAndCyclopediaId"})
public class AddCollectByUserIdAndCyclopediaId extends HttpServlet {

	private static final long serialVersionUID = 6229812275952466609L;

	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			
			Integer userId = Integer.parseInt(request.getParameter("userId"));
			Integer cyclopediaId = Integer.parseInt(request.getParameter("cyclopediaId"));
			
			
			Collect collect = new Collect();
			collect.setUserId(userId);
			collect.setCyclopediaId(cyclopediaId);
			collect.setTime(DateUtil.DateToString(new Date()));
			
			
			CollectService collectService = new CollectService();
			int msg = collectService.insertCollectByUserIdAndCyclopediaId(collect);
			
			
			if(1 == msg){
				response.getWriter().print(0);//success
				
				int count =+ collectService.queryCollectCount(cyclopediaId);
				
				new CyclopediaService().insertCollectCount(count, cyclopediaId);;
				
			}else{
				response.getWriter().print(2);//SQL error SQL执行报错
			}
		}catch (NumberFormatException e) {
			e.printStackTrace();
			response.getWriter().println(2);//NumberFormat error 类型转换报错
		}catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().print(2);//SQL error SQL执行报错
		}
	}
	
	
	
}
