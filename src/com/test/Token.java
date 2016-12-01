package com.test;

import com.qiniu.util.Auth;


public class Token {
	
	
	static String ACCESS_KEY = "jKxoI6ZkySxBy0cmjHFv9Ek1nU-6zHBTqUd0aRmD";
    static String SECRET_KEY = "SWLtLJfsVxk3GqUpEvnJ7V7Ca_miOvmce3Z3Ke1g";

    
    //static String bucketname = "cyclopedia-cover";
    static String bucketname = "test";
    
    
    static Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    
    public static void main(String[] args) {
    	
    	String uptoken = auth.uploadToken(bucketname);
    	
    	//System.out.println("\"uptoken\""+": "+"\""+uptoken+"\"");
    	System.out.println("'"+uptoken+"'");
	
    }
    
    
    
}
