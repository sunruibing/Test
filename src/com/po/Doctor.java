package com.po;



/**
 * 医生
 * 
 * 对应数据库 表：doctor
 *@author FFFF
 * Put 
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年9月21日
 */
public class Doctor {

	private Integer id;//医生id
	
	private String name;//医生真实姓名
	
	private String username;//医生账号
	
	private String password;//密码
	
	private String icon;//医生头像
	
	private String title;//职称
	
	private String section;//所属科室
	
	private String hospital;//所属医院

	private String chatCost;//图文咨询价格
	
	private String callCost;//电话咨询价格
	
	private String seniority;//资历
	
	private String bio;//简介
	
	private String adept;//擅长
	
	private String commentCount;//被评论的次数

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public String getChatCost() {
		return chatCost;
	}

	public void setChatCost(String chatCost) {
		this.chatCost = chatCost;
	}

	public String getCallCost() {
		return callCost;
	}

	public void setCallCost(String callCost) {
		this.callCost = callCost;
	}

	public String getSeniority() {
		return seniority;
	}

	public void setSeniority(String seniority) {
		this.seniority = seniority;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getAdept() {
		return adept;
	}

	public void setAdept(String adept) {
		this.adept = adept;
	}

	public String getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(String commentCount) {
		this.commentCount = commentCount;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + ", icon="
				+ icon + ", title=" + title + ", section=" + section + ", hospital=" + hospital + ", chatCost="
				+ chatCost + ", callCost=" + callCost + ", seniority=" + seniority + ", bio=" + bio + ", adept=" + adept
				+ ", commentCount=" + commentCount + "]";
	}
	
}
