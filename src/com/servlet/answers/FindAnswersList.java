package com.servlet.answers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.po.Answers;
import com.service.AnswersService;


/**
 *根据疾病id查询所有问答
 * @author FFFF
 *
 */
@WebServlet(name="FindAnswersList", urlPatterns={"/FindAnswersList"})
public class FindAnswersList extends HttpServlet {

	private static final long serialVersionUID = -3347863058021854975L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer diseaseId = Integer.parseInt(request.getParameter("id"));//接收客户端传来的具体疾病id

		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		AnswersService answersService = new AnswersService();
		
		try {
			
			List<Answers> answersList = answersService.queryAnswersList(diseaseId);//用id去调用查询方法
			
			response.getWriter().print(new Gson().toJson(answersList));//把查询结果转程json返回给客户端
			
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().print(2);//异常报错，返回2表示错误是服务端导致
			
		}
		
	}
	
	
	
	@Override
	public void destroy() {
		super.destroy();
	}
}
