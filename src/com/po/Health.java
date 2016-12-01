package com.po;



/**
 * 健康状况表
 * 
 * 对应数据库表：health
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年10月7日
 */
public class Health {

	private Integer id;
	
	private String createDate;
	
	private String tag;
	
	private String content;
	
	private String doctorEnjoin;
	
	private Integer userId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDoctorEnjoin() {
		return doctorEnjoin;
	}

	public void setDoctorEnjoin(String doctorEnjoin) {
		this.doctorEnjoin = doctorEnjoin;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Health [id=" + id + ", createDate=" + createDate + ", tag=" + tag + ", content=" + content
				+ ", doctorEnjoin=" + doctorEnjoin + ", userId=" + userId + "]";
	}
	
}
