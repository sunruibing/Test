package com.po;



/**
 * 日历表
 * 
 * 对应数据库表：calendar
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年10月7日
 */
public class Calendar {
	
	private Integer id;
	
	private String date;
	
	private Integer registrationId;
	
	private Integer remindId;
	
	private Integer healthId;
	
	private Integer userId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Integer registrationId) {
		this.registrationId = registrationId;
	}

	public Integer getRemindId() {
		return remindId;
	}

	public void setRemindId(Integer remindId) {
		this.remindId = remindId;
	}

	public Integer getHealthId() {
		return healthId;
	}

	public void setHealthId(Integer healthId) {
		this.healthId = healthId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Calendar [id=" + id + ", date=" + date + ", registrationId=" + registrationId + ", remindId=" + remindId
				+ ", healthId=" + healthId + ", userId=" + userId + "]";
	}
	
}
