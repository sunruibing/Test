package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.po.Collect;
import com.util.DBUtil;



/**
 * 我的收藏
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年9月21日
 */
public class CollectService {
	
	
	//根据用户id来查询用户的所有收藏
	public List<Map<String,Object>> queryCollectListByUserId(Integer userId) throws SQLException {
		
		String sql = " SELECT collect.id, cyclopedia_id, collect.time, cyclopedia.icon, cyclopedia.title, cyclopedia.content, cyclopedia.collect_count FROM collect,cyclopedia WHERE cyclopedia_id = cyclopedia.id AND collect.user_id = "+userId+" ";
		DBUtil dbUtil = new DBUtil(sql);

		
		List<Map<String,Object>>  list = new ArrayList<Map<String,Object>>();
		
		ResultSet result = null;
		try {
			result = dbUtil.pst.executeQuery();
			
			while (result.next()) {
				
				String content = result.getString("content");

				Map<String,Object>  map  = new HashMap<String,Object>();
				map.put("id", result.getInt("id"));
				map.put("cyclopediaId", result.getInt("cyclopedia_id"));
				map.put("time", result.getString("time"));
				map.put("icon", result.getString("icon"));
				map.put("title", result.getString("title"));
				map.put("content", content.substring(0, content.length()>20?20:content.length()));
				map.put("collectCount", result.getInt("collect_count"));
				
				list.add(map);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(result != null)result.close();
			if(dbUtil != null)dbUtil.close();
		}
		return list;
	}

	
	
	//根据用户id和文章id来添加我的收藏
	public int insertCollectByUserIdAndCyclopediaId(Collect collect) throws SQLException {
		
		String sql = "insert into collect(user_id,cyclopedia_id,time)values(" + collect.getUserId()+ "," + "" + collect.getCyclopediaId() + ","+"'"+collect.getTime()+"'"+")";
		DBUtil dbUtil = new DBUtil(sql);
		
		try {
			dbUtil.pst.executeUpdate();
			return 1;//收藏成功
		} catch (Exception e) {
			return 2;//收藏失败
		} finally {
			if(dbUtil != null)dbUtil.close();
		}
	}
	
	
	
	//根据用户id和文章id删除我的收藏
	public int deleteCollectByUserIdAndCyclopediaId(Integer userId, Integer cyclopediaId){
		
		String sql = " delete from collect where user_id = "+userId+" and cyclopedia_id = "+cyclopediaId+" ";
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
	
	
	
	//根据收藏表的id来删除我的收藏
	public int deleteCollectById(Integer id){
		
		String sql = " DELETE FROM collect WHERE id = "+id+" ";
		DBUtil dbUtil = new DBUtil(sql);
		
		
		try {
			dbUtil.pst.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 2;
		} finally{
			if(dbUtil != null)dbUtil.close();
		}
	}
	
	
	
	//根据用户id和文章id来查询此文章是否已被当前用户收藏
	public int queryCollectByUserIdAndCyclopediaId(Integer userId, Integer cyclopediaId) throws SQLException{
		
		String sql = " SELECT id FROM collect WHERE user_id = "+userId+" AND cyclopedia_id = "+cyclopediaId+" ";
		DBUtil dbUtil = new DBUtil(sql);
		
		
		int id = 0;
		
		
		ResultSet result = null;
		
		try {
			result = dbUtil.pst.executeQuery();
			
			while(result.next()){
				
				id = result.getInt("id");
				return id;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(result != null)result.close();
			if(dbUtil != null)dbUtil.close();
		}
		return id;
	}
	
	
	
	//根据文章id查询一篇文章被收藏的总次数
	public int queryCollectCount(Integer cyclopediaId) throws SQLException{
		
		String sql = " select count(cyclopedia_id) from collect where cyclopedia_id = "+cyclopediaId+" ";
		DBUtil dbUtil = new DBUtil(sql);
		
		
		int count = 0;
		
		
		ResultSet result = null;
		
		try {
			
			result = dbUtil.pst.executeQuery();
			
			while(result.next()){
				count = result.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
			return count;
		} finally {
			if(result != null)result.close();
			if(dbUtil != null)dbUtil.close();
		}
	}
	
	
	
}
