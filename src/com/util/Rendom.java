package com.util;

public class Rendom {
	public String rendom(){
        String str = "";
        str += (int)(Math.random()*9+1);
        for(int i = 0; i < 3; i++){
            str += (int)(Math.random()*10);
        }
		return str;
    }
}
