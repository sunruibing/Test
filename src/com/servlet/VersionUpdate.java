package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.service.VersionUpdateService;



/**
 * 版本更新
 * 
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年10月10日
 */
@WebServlet(name="VersionUpdate", urlPatterns={"/VersionUpdate"})
public class VersionUpdate extends HttpServlet {

	private static final long serialVersionUID = 5743981480515771548L;
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application.json");
		response.setCharacterEncoding("utf-8");
		
		
		String versionCode = request.getParameter("versionCode");
		
		
		VersionUpdateService versionUpdateService = new VersionUpdateService();
		
		try {
			String DBVersionCode = versionUpdateService.queryVersion();
			
			if(versionCode != null && versionCode.equals(DBVersionCode)){
				
				response.getWriter().print(0);//没有更新
				
			}else{
				
				Map<String, String> version = versionUpdateService.getVersion();
				
				response.getWriter().print(new Gson().toJson(version));//success
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().print(2);//error
		}
	}

	
	
}
