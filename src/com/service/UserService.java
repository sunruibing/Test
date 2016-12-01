package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.po.User;
import com.util.DBUtil;
import com.util.StringUtil;



/**
 * 用户模块
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年9月23日
 */
public class UserService {
	
	
	// 根据手机号查询用户
	public User queryUserByPhone(String phone) throws SQLException {
		
		String sql = "select id,phone,password,name,gender,age,icon from user where phone = " + phone + "";// SQL语句
		DBUtil dbUtil = new DBUtil(sql);

		
		User user = new User();

		ResultSet result = null;
		try {
			
			result = dbUtil.pst.executeQuery();// 执行语句，得到结果集
			
			while (result.next()) {// 遍历结果
			 
				Integer id = result.getInt("id");
				String DBphone = result.getString("phone");
				String password = result.getString("password");
				String name = result.getString("name");
				String gender = result.getString("gender");
				int age = result.getInt("age");
				String icon = result.getString("icon");

				user.setId(id);
				user.setPhone(DBphone);
				user.setPassword(password);
				user.setName(name);
				user.setGender(gender);
				user.setAge(age);
				user.setIcon(icon);

				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return user;
		} finally {
			if(result != null)result.close();
			if(dbUtil != null)dbUtil.close();
		}
		return user;
	}
	
	

	// 根据id查询用户
	public User queryUserById(Integer id) throws SQLException {
		
		String sql = "select id,phone,password  from user where id = "+id+" ";
		DBUtil dbUtil = new DBUtil(sql);

		
		User user = new User();

		ResultSet result = null;
		try {
			result = dbUtil.pst.executeQuery();
			
			while (result.next()) {
				
				user.setId(result.getInt("id"));
				user.setPhone(result.getString("phone"));
				user.setPassword(result.getString("password"));

				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(result != null)result.close();
			if(dbUtil != null)dbUtil.close();
		}
		return user;
	}
	
	

	// 添加用户（默认只添加两个参数，phone和password）
	public int addUser(User user) {
		
		String password = StringUtil.MD5Encode(user.getPassword());//密码加密
		
		String sql = "insert into user(phone,password)values("+ "'"+user.getPhone()+"'" +","+ "'"+password+"'" +")";
		DBUtil dbUtil = new DBUtil(sql);// 创建连接数据工具类对象

		try {
			dbUtil.pst.executeUpdate();
			return 1;// 成功
		} catch (SQLException e) {
			e.printStackTrace();
			return 2;// 失败
		} finally {
			if(dbUtil != null)dbUtil.close();
		}
	}

	
	
	// 根据手机号更改用户密码
	public int updataPassword(String password, String phone) {
		
		String sql = "UPDATE user SET password = " + "'" + password + "'" + " WHERE phone = " + "'" + phone + "'" + " ";
		DBUtil dbUtil = new DBUtil(sql);

		
		try {
			dbUtil.pst.executeUpdate();// 更新数据库中的密码数据
			return 1;// 成功
		} catch (Exception e) {
			return 2;// 失败
		} finally {
			if(dbUtil != null)dbUtil.close();
		}
	}
	
	

	// 根据id修改用户昵称
	public int updataUserName(Integer id, String name) {
		
		String sql = "UPDATE user SET  name= "+ "'"+name+"'" +" WHERE id = "+id+" ";
		DBUtil dbUtil = new DBUtil(sql);

		
		try {
			dbUtil.pst.executeUpdate();
			return 1;// 成功
		} catch (SQLException e) {
			e.printStackTrace();
			return 2;// 失败
		} finally {
			if(dbUtil != null)dbUtil.close();
		}
	}
	

	// 根据id修改用户性别
	public int updataUserGender(Integer id, String gender) {
		
		String sql = "UPDATE user SET gender = "+ "'"+gender+"'" +"  WHERE id = "+id+" ";
		DBUtil dbUtil = new DBUtil(sql);

		
		try {
			dbUtil.pst.executeUpdate();
			return 1;// 成功
		} catch (SQLException e) {
			e.printStackTrace();
			return 2;// 失败
		} finally {
			if(dbUtil != null)dbUtil.close();
		}
	}
	
	
	
	//用户注册选择昵称性别
	public int insertGenderAndName(User user) {
			
		String sql = "UPDATE user SET name = "+ "'"+ user.getName() +"'" +" ,gender = "+ "'"+ user.getGender()+"'" +" WHERE id = "+ user.getId() +" ";
		DBUtil dbUtil = new DBUtil(sql);
			
		try {
			dbUtil.pst.executeUpdate();
			return 1;//成功
		} catch (SQLException e) {
			e.printStackTrace();
			return 2;//失败
		} finally {
			if(dbUtil != null)dbUtil.close();
		}
	}
	
		

	// 根据用户ID查找用户头像
	public String queryIcon(Integer id) throws SQLException {
		
		String sql = "SELECT icon FROM user WHERE id = " + id + " ";
		DBUtil dbUtil = new DBUtil(sql);

		
		ResultSet result = null;
		
		
		String icon = "";

		try {
			result = dbUtil.pst.executeQuery();

			while (result.next()) {
				icon = result.getString("icon");
				return icon;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(result != null)result.close();
			if(dbUtil != null)dbUtil.close();
		}
		return icon;
	}

	
	
	// 根据id修改用户头像
	public int updataIcon(Integer id, String icon) {
		
		String sql = "UPDATE user SET icon = " + "'" +icon+ "'" + " WHERE id= " + id + " ";
		DBUtil dbUtil = new DBUtil(sql);

		
		try {
			dbUtil.pst.executeUpdate();
			return 1;// 成功
		} catch (Exception e) {
			e.printStackTrace();
			return 2;// 失败

		} finally {
			if(dbUtil != null)dbUtil.close();
		}
	}
	
	
	
	// 根据id修改密码
	public int updataPassword(Integer id, String password) {
		
		String sql = "UPDATE user SET password = " + "'" + password + "'" + " WHERE id=" + id + "";
		DBUtil dbUtil = new DBUtil(sql);

		
		try {
			dbUtil.pst.executeUpdate();
			return 1;// 成功
		} catch (Exception e) {
			e.printStackTrace();
			return 2;// 失败
		} finally {
			if(dbUtil != null)dbUtil.close();
		}
	}
	
	
	
	// 根据用户Id绑定手机号
	public int insertBinding(Integer id , String phone) {
		
		String sql = "UPDATE user SET phone = "+ "'"+phone+"'" +" WHERE id=" + id + "";
		DBUtil dbUtil = new DBUtil(sql);// 创建连接数据工具类对象
		
		
		try {
			dbUtil.pst.executeUpdate();// 执行sql
			return 1;//成功
		} catch (Exception e) {
			return 2;//失败
		} finally {
			if(dbUtil != null)dbUtil.close();
		}
	}
	
	
	
}