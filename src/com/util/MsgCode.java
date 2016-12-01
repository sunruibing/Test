package com.util;

public class MsgCode {
	
	public static String rendom(){
		
        String str = "";
        str += (int)(Math.random()*9+1);
        for(int i = 0; i < 5; i++){
            str += (int)(Math.random()*10);
        }
		return str;
    }
	
}
