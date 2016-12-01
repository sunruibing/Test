package com.service;

import java.sql.SQLException;

import com.po.Feedback;
import com.util.DBUtil;



/**
 * 意见反馈
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年9月22日
 */
public class FeedbackService {
	
	
	//添加意见反馈信息
	public int insertFeedback(Feedback advise) throws SQLException {
		
		String sql = "INSERT  INTO feedback(content,time,user_id) VALUES(" + "'" + advise.getContent() + "'" + "," + "'" + advise.getTime() + "'" + "," + advise.getUserId() + ") ";
		DBUtil dbUtil = new DBUtil(sql);

		try {
			dbUtil.pst.executeUpdate(sql);// 执行SQL
			return 1;//成功
		} catch (Exception e) {
			return 2;//失败
		} finally {
			if(dbUtil != null)dbUtil.close();
		}
	}



}
