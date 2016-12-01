package com.po;



/**
 * 用药提醒
 * 
 * 对应数据库表：remind
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年10月12日
 */
public class Remind {
	
	private Integer id;
	
	private String remindDate;//日期
	
	private String time1;//具体提醒时间1
	
	private String time2;//具体提醒时间2
	
	private String time3;//具体提醒时间3
	
	private String content1;//提醒内容1
	
	private String content2;//提醒内容2
	
	private String content3;//提醒内容3
	
	private Integer userId;//用户id
	
	private String timestamp;//时间戳

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRemindDate() {
		return remindDate;
	}

	public void setRemindDate(String remindDate) {
		this.remindDate = remindDate;
	}

	public String getTime1() {
		return time1;
	}

	public void setTime1(String time1) {
		this.time1 = time1;
	}

	public String getTime2() {
		return time2;
	}

	public void setTime2(String time2) {
		this.time2 = time2;
	}

	public String getTime3() {
		return time3;
	}

	public void setTime3(String time3) {
		this.time3 = time3;
	}

	public String getContent1() {
		return content1;
	}

	public void setContent1(String content1) {
		this.content1 = content1;
	}

	public String getContent2() {
		return content2;
	}

	public void setContent2(String content2) {
		this.content2 = content2;
	}

	public String getContent3() {
		return content3;
	}

	public void setContent3(String content3) {
		this.content3 = content3;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Remind [id=" + id + ", remindDate=" + remindDate + ", time1=" + time1 + ", time2=" + time2 + ", time3="
				+ time3 + ", content1=" + content1 + ", content2=" + content2 + ", content3=" + content3 + ", userId="
				+ userId + ", timestamp=" + timestamp + "]";
	}

}
