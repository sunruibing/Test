package com.po;



/**
 * 意见反馈
 * 
 * 对应数据库表：feedback
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年9月22日
 */
public class Feedback {
	
	private Integer id;// 反馈信息id
	
	private String content;// 反馈内容
	
	private String time;// 反馈时间
	
	private Integer userId;// 用户ID

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Advise [id=" + id + ", content=" + content + ", time=" + time + ", userId=" + userId + "]";
	}
	
	
}
