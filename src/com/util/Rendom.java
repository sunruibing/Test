package com.util;

//生成6位验证码工具类
public class Rendom {
	public String rendom(){
        String str = "";
        str += (int)(Math.random()*9+1);
        for(int i = 0; i < 5; i++){
            str += (int)(Math.random()*10);
        }
		return str;
    }
}
