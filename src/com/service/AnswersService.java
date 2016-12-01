package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.po.Answers;
import com.util.DBUtil;

/**
 *疾病详情问答
 * @author FFFF
 *
 */
public class AnswersService {
	
	
	//根据疾病id查询所有问答
	public List<Answers> queryAnswersList(Integer diseaseId) throws SQLException{
		
		String sql = "SELECT id,content,time,username,icon FROM zsmz.answers WHERE disease_id = "+ diseaseId +" ";
		DBUtil dbUtil = new DBUtil(sql);
		
		List<Answers> answersList = new ArrayList<Answers>();
		
		ResultSet result = null;
		try {
			result = dbUtil.pst.executeQuery();
			
			while (result.next()) {
				
				Integer id = result.getInt("id");
				String content = result.getString("content");
				String time = result.getString("time");
				String userName = result.getString("username");
				String icon = result.getString("icon");
				
				Answers answers = new Answers();
				answers.setId(id);
				answers.setContent(content);
				answers.setTime(time);
				answers.setUserName(userName);
				answers.setIcon(icon);
				
				answersList.add(answers);
			}
			return answersList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(result != null)result.close();
			if(dbUtil != null)dbUtil.close();
		}
		return answersList;
	}
	
	
	
}
