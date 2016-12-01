package com.servlet.user;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.po.User;
import com.service.UserService;



/**
 * 在注册时填写昵称性别
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年9月22日
 */
@WebServlet(name="AddNameAndGender",urlPatterns={"/AddNameAndGender"})
public class AddNameAndGender extends HttpServlet {

	private static final long serialVersionUID = -1033181072171086306L;
	
	
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doPost(request, response);
    }
	
	
	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	request.setCharacterEncoding("UTF-8");
  
    	
    	response.setContentType("application/json");
    	response.setCharacterEncoding("utf-8");
    	
    	
		try {
			
			User user = new User();
			user.setId(Integer.parseInt(request.getParameter("id")));
			user.setName(request.getParameter("name"));
			user.setGender(request.getParameter("gender"));
			
			
			int msg = new UserService().insertGenderAndName(user);
			
			if(1 == msg){
				response.getWriter().print(0);//success
			}else{
				response.getWriter().print(2);//SQL error
			}
			
		}catch (NumberFormatException e) {
			e.printStackTrace();
			response.getWriter().println(2);//NumberFormat error 类型转换报错
		}
		
    }
    
    
}
