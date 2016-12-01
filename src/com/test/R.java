package com.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class R {
	
	private static final DateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd");
	
	
	public static void main(String[] args) throws ParseException {
		
		Calendar startDay = Calendar.getInstance();  
		Calendar endDay = Calendar.getInstance();
	  
		startDay.setTime(FORMATTER.parse("2016-09-30"));  
		endDay.setTime(FORMATTER.parse("2016-10-11"));  
		  
		printDay(startDay, endDay);
		
		
		String start = "2016-10-11";
		
		Calendar.getInstance().setTime(FORMATTER.parse(start));
		
		System.out.println(startDay.getClass());
		
		
	}

	private static void printDay(Calendar startDay, Calendar endDay) {
		
		// 给出的日期开始日比终了日大则不执行打印  
		if (startDay.compareTo(endDay) >= 0) {  
			return;
		}
		
		
		// 现在打印中的日期  
		Calendar currentPrintDay = startDay;
		
		
		while(true){
			
			// 日期加一  
			currentPrintDay.add(Calendar.DATE, 1);  
			// 日期加一后判断是否达到终了日，达到则终止打印  
			if (currentPrintDay.compareTo(endDay) == 0) {  
				break;  
			}  
			// 打印日期
			String aa = FORMATTER.format(currentPrintDay.getTime());
			System.out.println(aa);  
		}
		
	}
	
	

}  
