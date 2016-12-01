package com.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;



/**
 * 日期工具类
 * 
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年10月12日
 */
public class DateUtil {
	
	private static final DateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd");
	
	
	
	//时间段操作
	public static List<String> getTimeSlot(String start, String end) throws ParseException{
		
		List<String> list = new ArrayList<String>();
		
		
		if(start.compareTo(end) == 0){//如果开始跟结束为同一天则直接返回开始日期
			
			list.add(start);
			
			return list;
			
		}else{
			
			Calendar startDay = Calendar.getInstance();
			Calendar endDay = Calendar.getInstance();
			
			startDay.setTime(FORMATTER.parse(start));
			endDay.setTime(FORMATTER.parse(end));
			
			
			Calendar currentDay = startDay;
			
			
			list.add(start);//加上开始时间
			
			while(true){//中间时间
				//日期加一
				currentDay.add(Calendar.DATE, 1);
				
				//判断是否到达结束时间
				if(currentDay.compareTo(endDay)  == 0){
					break;
				}
				
				String middleDay = FORMATTER.format(currentDay.getTime());
				
				list.add(middleDay);
			}
			
			list.add(end);//加上结束时间
			
			return list;
		}
	}
	
	
	
	//日期转成字符串
	public static String DateToString(Date date){
		
		if(date != null && !"".equals(date)){
			String dateSting = new SimpleDateFormat("yyyy-MM-dd hh:mm").format(date);
			
			return dateSting;
		}
		return "";
	}
	
	
	
}
