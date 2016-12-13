package com.servlet.role;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.po.User;
import com.service.RoleService;
import com.util.StringUtil;


@WebServlet(name="AdminLogin",urlPatterns={"/adminLogin"})
public class AdminLogin extends HttpServlet {
	
	private static final long serialVersionUID = -4697804910426531143L;
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		
		String phone = request.getParameter("phone");//获取用户名
		String password = StringUtil.MD5Encode(request.getParameter("password"));//获取密码
		
		try {
			if ((phone != null && password != null) && (!phone.isEmpty() && !password.isEmpty())) {//都不为空验证
				
				RoleService roleService = new RoleService();
				    User DBrole =   roleService.queryRoleByPhone(phone);
				
				if (password.equals(DBrole.getPassword())) {//判断密码是否正确
					
					DBrole.setPassword("");//清空密码
					
					response.getWriter().print(new Gson().toJson(DBrole));//success;
					
				} else {
					response.getWriter().print(1);// 密码错误;
				}
			} else {
				response.getWriter().print(1);// 手机号或密码不能为空;
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().print(2);// 异常报错;
		}
	}
}
