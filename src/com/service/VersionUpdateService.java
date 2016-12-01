package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.util.DBUtil;

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
public class VersionUpdateService {
	
	//查询当前最新版本
	public String queryVersion() throws SQLException{
		
		String sql = " select version from version_update ";
		DBUtil dbUtil = new DBUtil(sql);
		
		
		ResultSet result = null;
		
		
		String version = "";
		
		try {
			result = dbUtil.pst.executeQuery();
			
			while(result.next()){
				version = result.getString("version");
				
				return version;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(result != null)result.close();
			if(dbUtil != null)dbUtil.close();
		}
		return version;
	}
	
	
	//获取版本更新信息
	public Map<String, String> getVersion() throws SQLException{
		
		String sql = " select version, download_path, update_log from version_update ";
		DBUtil dbUtil = new DBUtil(sql);
		
		
		ResultSet result = null;
		
		
		Map<String, String> map = new HashMap<String, String>();
		
		try {
			result = dbUtil.pst.executeQuery();
			
			while(result.next()){
				
				
				map.put("version", result.getString("version"));
				map.put("downloadPath", result.getString("download_path"));
				map.put("updateLog", result.getString("update_log"));
				
				return map;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(result != null)result.close();
			if(dbUtil != null)dbUtil.close();
		}
		return map;
	}
	
	
}
