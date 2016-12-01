package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.util.DBUtil;

/**
 * 热点推荐
 * 
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年11月3日
 */
public class HotService {

	
	//查询所有记录
	public List<Map<String, Object>> queryAllHot() throws SQLException{
		
		String sql = " select id, title, site from hot ";
		DBUtil dbUtil = new DBUtil(sql);
		
		
		ResultSet result = null;
		
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		try {
			result = dbUtil.pst.executeQuery();
			
			while(result.next()){
				
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", result.getInt("id"));
				map.put("title", result.getString("title"));
				map.put("site", result.getString("site"));
				
				list.add(map);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(result != null)result.close();
			if(dbUtil != null)dbUtil.close();
		}
		return list;
	}
	
	
	
}
