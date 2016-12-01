package com.po;



/**
 * 疾病库
 * 
 * 对应数据库表：disease_library
 *@author FFFF
 * Put 
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 */
public class DiseaseLibrary {
	
	private Integer id;// 疾病id

	private String name;// 疾病名

	private String bio;// 疾病简介

	private String userIcon;// 用户头像

	private String userName;// 用户名称

	private String userPutQuestion;// 用户的提问

	private String doctorIcon;// 医生头像
	
	private String doctorName;// 医生名称
	
	private String doctorAnswerQuestion;// 医生的回答
	
	private String symptom;// 症状
	
	private String cure;// 治疗
	
	private String prompt;// 温馨提示
	
	private String sectionName;// 科室名
	
	private Integer doctorId;//推荐的医生

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

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getUserIcon() {
		return userIcon;
	}

	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPutQuestion() {
		return userPutQuestion;
	}

	public void setUserPutQuestion(String userPutQuestion) {
		this.userPutQuestion = userPutQuestion;
	}

	public String getDoctorIcon() {
		return doctorIcon;
	}

	public void setDoctorIcon(String doctorIcon) {
		this.doctorIcon = doctorIcon;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorAnswerQuestion() {
		return doctorAnswerQuestion;
	}

	public void setDoctorAnswerQuestion(String doctorAnswerQuestion) {
		this.doctorAnswerQuestion = doctorAnswerQuestion;
	}

	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public String getCure() {
		return cure;
	}

	public void setCure(String cure) {
		this.cure = cure;
	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	@Override
	public String toString() {
		return "DiseaseLibrary [id=" + id + ", name=" + name + ", bio=" + bio + ", userIcon=" + userIcon + ", userName="
				+ userName + ", userPutQuestion=" + userPutQuestion + ", doctorIcon=" + doctorIcon + ", doctorName="
				+ doctorName + ", doctorAnswerQuestion=" + doctorAnswerQuestion + ", symptom=" + symptom + ", cure="
				+ cure + ", prompt=" + prompt + ", sectionName=" + sectionName + ", doctorId=" + doctorId + "]";
	}

}
