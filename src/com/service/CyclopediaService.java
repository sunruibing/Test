package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.po.Cyclopedia;
import com.util.DBUtil;



/**
 * 百科模块
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年9月22日
 */
public class CyclopediaService {
	
    
	//分页查询
	public List<Cyclopedia> queryCylopediaList(Integer PageCount) throws SQLException{
		
		String sql = " SELECT id,icon,cover,title,content,time, collect_count FROM cyclopedia order by id desc limit "+PageCount+",20; ";
		DBUtil dbUtil = new DBUtil(sql);
		
		
		List<Cyclopedia> list = new ArrayList<Cyclopedia>();

		ResultSet result = null;
		
		try {
			result = dbUtil.pst.executeQuery();
			
			while (result.next()) {
				
				Integer id = result.getInt("id");
				String icon = result.getString("icon");
				String cover = result.getString("cover");
				String title = result.getString("title");
				String content = result.getString("content");
				String time = result.getString("time");
				Integer collectCount = result.getInt("collect_count");
				
				Cyclopedia cyclopedia = new Cyclopedia();
				cyclopedia.setId(id);
				cyclopedia.setIcon(icon);
				cyclopedia.setCover(cover);
				cyclopedia.setTitle(title);
				cyclopedia.setContent(content.substring(0, content.length()>20?20:content.length()));//截取部分文章内容
				cyclopedia.setTime(time);
				cyclopedia.setCollectCount(collectCount);
				
				list.add(cyclopedia);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(result != null)result.close();
			if(dbUtil != null)dbUtil.close();
		}
		return list;
	}
	
	
	
	//根据文章id查询内容详情
	public Cyclopedia queryCyclopediaById(Integer cyclopediaId) throws SQLException{
		
		String sql = "SELECT cover,title,content,time FROM cyclopedia WHERE id = "+cyclopediaId+" ";
		DBUtil dbUtil = new DBUtil(sql);
		
		
		Cyclopedia cyclopedia = new Cyclopedia();
		
		ResultSet result = null;
		
		try {
			result = dbUtil.pst.executeQuery();
			
			while (result.next()) {
				
				cyclopedia.setCover(result.getString("cover"));
				cyclopedia.setTitle(result.getString("title"));
				cyclopedia.setContent(result.getString("content"));
				cyclopedia.setTime(result.getString("time"));
				
			}
			return cyclopedia;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(result != null)result.close();
			if(dbUtil != null)dbUtil.close();
		}
		return cyclopedia;
	}
	
	
	
	//查询所有科室
	public List<Map<String, String>> querySectionList() throws SQLException {
		
		String sql = "select id, name, icon1, icon2 from section";
		DBUtil dbUtil = new DBUtil(sql);

		
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		ResultSet result = null;
		try {
			result = dbUtil.pst.executeQuery();

			while (result.next()) {
				
				Map<String, String> map = new HashMap<String, String>();
				map.put("name", result.getString("name"));
				map.put("icon1", result.getString("icon1"));
				map.put("icon2", result.getString("icon2"));

				list.add(map);
			}
			return list;
		} catch (Exception e) {
			e.getMessage();
		} finally {
			if(result != null)result.close();
			if(dbUtil != null)dbUtil.close();
		}
		return list;
	}
	
	
	
	//随机查询两条记录
	public List<Cyclopedia> queryCyclopediaRandomTwo() throws SQLException{
		
		String sql = " select id,icon,title,content,time, collect_count from cyclopedia order by Rand() limit 2 ";
		DBUtil dbUtil = new DBUtil(sql);
		
		
		ResultSet result = null;

		
		List<Cyclopedia> list = new ArrayList<Cyclopedia>();
		
		try {
			result = dbUtil.pst.executeQuery();
			
			while (result.next()) {
				
				Cyclopedia cyclopedia = new Cyclopedia();
				cyclopedia.setId(result.getInt("id"));
				cyclopedia.setIcon(result.getString("icon"));
				cyclopedia.setTitle(result.getString("title"));
				cyclopedia.setContent(result.getString("content"));
				cyclopedia.setTime(result.getString("time"));
				cyclopedia.setCollectCount(result.getInt("collect_count"));
				
				list.add(cyclopedia);
			}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(result != null)result.close();
			if(dbUtil != null)dbUtil.close();
		}
		return list;
	}
	
	
	
	//add collect count in cyclopedia
	public void insertCollectCount(Integer count, Integer cyclopediaId){
		
		String sql = " update cyclopedia set collect_count = "+count+" where id = "+cyclopediaId+" ";
		DBUtil dbUtil = new DBUtil(sql);
		
		try {
			dbUtil.pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(dbUtil != null)dbUtil.close();
		}
	}
	
	
	
	//add cyclopedia
	public int insertCyclopedia(Cyclopedia cyclopedia){
			
			String sql = " insert into cyclopedia(icon, cover, title, content, time) values("+"'"+cyclopedia.getIcon()+"'"+","+"'"+cyclopedia.getCover()+"'"+","+"'"+cyclopedia.getTitle()+"'"+","+"'"+cyclopedia.getContent()+"'"+","+"'"+cyclopedia.getTime()+"'"+")";
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
