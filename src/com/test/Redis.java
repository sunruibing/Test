package com.test;

import redis.clients.jedis.Jedis;

public class Redis {
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		jedis.set("test", "fuck");
		
		System.out.println(jedis.get("test"));
		
	}
	
}
