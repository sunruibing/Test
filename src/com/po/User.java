package com.po;

public class User {
	
	private Integer id;//用户id
	
	private String phone;//手机号
	
	private String name;//名称
	
	private String password;//密码

	private String gender;//性别

	private Integer age;//年龄
	
	private String icon;//头像
	
	private String qq;//QQ号
	
	private String weibo;//微博
	
	private String wechat;//微信
	
	private String email;//邮箱
	
	private String registrationId;//极光设备注册id

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWeibo() {
		return weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", phone=" + phone + ", name=" + name + ", password=" + password + ", gender="
				+ gender + ", age=" + age + ", icon=" + icon + ", qq=" + qq + ", weibo=" + weibo + ", wechat=" + wechat
				+ ", email=" + email + ", registrationId=" + registrationId + "]";
	}
	
}
