package com.util.token;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qiniu.util.Auth;


@WebServlet(name="Token", urlPatterns={"/getToken"})
public class Token extends HttpServlet {
	
	private static final long serialVersionUID = -8802750564897950344L;
	
	
	static String ACCESS_KEY = "jKxoI6ZkySxBy0cmjHFv9Ek1nU-6zHBTqUd0aRmD";
    static String SECRET_KEY = "SWLtLJfsVxk3GqUpEvnJ7V7Ca_miOvmce3Z3Ke1g";

    
    static String bucketname = "usericon";
    
    
    static Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    
    
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doPost(req, resp);
    }
    
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	resp.getWriter().print(auth.uploadToken(bucketname));
    	
    }
    
    

}
