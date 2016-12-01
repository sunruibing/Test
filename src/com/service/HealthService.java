package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.po.Health;
import com.util.DBUtil;



/**
 * 健康状况
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年10月5日
 */
public class HealthService {
	
	
	//添加健康记录
	public int insertHealth(Health health){
		
		String sql = " insert into health(create_date, tag, content, user_id) values("+ "'"+health.getCreateDate()+"'" +", "+ "'"+health.getTag()+"'" +", "+ "'"+health.getContent()+"'" +", "+ "'"+health.getUserId()+"'" +") ";
		DBUtil dbUtil = new DBUtil(sql);
		
		try {
			dbUtil.pst.executeUpdate();
			return 1;//success
		} catch (SQLException e) {
			e.printStackTrace();
			return 2;//error
		} finally{
			if(dbUtil != null)dbUtil.close();
		}
	}
	
	
	
	//根据日期和用户id查询健康记录
	public Integer queryHealthByDateAndUserId(String date, Integer userId) throws SQLException{
		
		String sql = " select id from health where create_date = "+ "'"+date+"'" +" and user_id = "+userId+" ";
		DBUtil dbUtil = new DBUtil(sql);
		
		
		ResultSet result = null;
		
		
		Integer id = 0;
		
		try {
			result = dbUtil.pst.executeQuery();
			
			while(result.next()){
				id = result.getInt("id");
				
				return id;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(result != null)result.close();
			if(dbUtil != null)dbUtil.close();
		}
		return id;
	}
	
	
	//根据健康状况id删除一条记录
	public int deleteHealthById(Integer id){
		
		String sql = " delete from health where id = "+id+" ";
		DBUtil dbUtil = new DBUtil(sql);
		
		
		try {
			dbUtil.pst.executeUpdate();
			return 1;//success
		} catch (SQLException e) {
			e.printStackTrace();
			return 2;//error
		}
	}
	
	
}
