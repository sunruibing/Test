package com.service;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.po.DiseaseLibrary;
import com.po.Doctor;
import com.util.DBUtil;



/**
 * 疾病库模块
 *@author FFFF
 *
 */
public class DiseaseService {
	
    
    //根据科室id查询所有疾病
    public List<String> queryDiseaseList(Integer sectionId) throws SQLException{
    	
    	String sql = "SELECT name FROM disease_library where section_id = "+ sectionId +"";
    	DBUtil dbUtil = new DBUtil(sql);
    	
    	
    	List<String> DiseaseList = new ArrayList<String>();
    	
    	ResultSet result = null;
		try {
    		result = dbUtil.pst.executeQuery();
    		
    		while(result.next()){
    			
    			String diseaseName = result.getString("name");
    			// Integer  id =  Integer.getInteger("id");
    			
    			DiseaseList.add(diseaseName);
    		}
    		return DiseaseList;
		} catch (Exception e) {
			e.getMessage();
		}finally {
			if(result != null)result.close();
			if(dbUtil != null)dbUtil.close();
		}
		return DiseaseList;
    }
    
    
    
    
    //根据疾病名查询疾病详情
	public List<Object> queryDisease(String diseaseName) throws SQLException{
    	
    	String sql = " SELECT disease_library.id,disease_library.name,disease_library.bio,disease_library.user_icon,disease_library.user_name,disease_library.user_put_question,disease_library.doctor_icon, disease_library.doctor_name, disease_library.doctor_answer_question, disease_library.symptom, disease_library.cure, disease_library.prompt,section.name AS section_name,doctor.id as doctor_id, doctor.username as doctor_account, doctor.`name` as doctor_name1, doctor.icon, doctor.title, doctor.section, doctor.adept, doctor.chat_cost, doctor.hospital FROM disease_library left join section on disease_library.section_id = section.id left join doctor on disease_library.doctor_id = doctor.id WHERE disease_library.name = "+"'"+diseaseName+"'"+" ";
		DBUtil dbUtil = new DBUtil(sql);
    	
    	
    	ResultSet result = null;
    	
    	
    	List<Object> list = new ArrayList<Object>();
    	
		try {
    		result  = dbUtil.pst.executeQuery();
    		
    		while (result.next()) {
    			
    			Integer id = result.getInt("id");
    			String name = result.getString("name");
    			String bio = result.getString("bio");
    			String userIcon = result.getString("user_icon");
    			String userName = result.getString("user_name");
    			String userPutQuestion = result.getString("user_put_question");
    			String doctorIcon = result.getString("doctor_icon");
    			String doctorName = result.getString("doctor_name");
    			String doctorAnswerQuestion = result.getString("doctor_answer_question");
    			String symptom = result.getString("symptom");
    			String cure = result.getString("cure");
    			String prompt = result.getString("prompt");
    			String sectionName = result.getString("section_name");
    			Integer doctorId = result.getInt("doctor_id");
    			String doctorAccount = result.getString("doctor_account");
    			String doctorName1 = result.getString("doctor_name1");
    			String icon = result.getString("icon");
    			String title = result.getString("title");
    			String section = result.getString("section");
    			String adept = result.getString("adept");
    			String chatCost = result.getString("chat_cost");
    			String hospital = result.getString("hospital");
    			
    			DiseaseLibrary diseaseLibrary = new DiseaseLibrary();
    			diseaseLibrary.setId(id);
    			diseaseLibrary.setName(name);
    			diseaseLibrary.setBio(bio);
    			diseaseLibrary.setUserIcon(userIcon);
    			diseaseLibrary.setUserName(userName);
    			diseaseLibrary.setUserPutQuestion(userPutQuestion);
    			diseaseLibrary.setDoctorIcon(doctorIcon);
    			diseaseLibrary.setDoctorName(doctorName);
    			diseaseLibrary.setDoctorAnswerQuestion(doctorAnswerQuestion);
    			diseaseLibrary.setSymptom(symptom);
    			diseaseLibrary.setCure(cure);
    			diseaseLibrary.setPrompt(prompt);
    			diseaseLibrary.setSectionName(sectionName);
    			
    			Doctor doctor = new Doctor();
    			doctor.setId(doctorId);
    			doctor.setUsername(doctorAccount);
    			doctor.setName(doctorName1);
    			doctor.setIcon(icon);
    			doctor.setTitle(title);
    			doctor.setSection(section);
    			doctor.setAdept(adept);
    			doctor.setChatCost(chatCost);
    			doctor.setHospital(hospital);
    			
    			list.add(diseaseLibrary);
    			list.add(doctor);
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
    
	
 
}
