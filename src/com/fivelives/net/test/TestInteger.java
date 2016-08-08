package com.fivelives.net.test;

import java.util.HashMap;

public class TestInteger {
	public static void main(String[] args) {
		
		
		HashMap<Integer, String> testmap = new HashMap<Integer, String>(); 
		testmap.put(1, "1");
		testmap.put(2, "2");
		testmap.put(3, "3");
		testmap.put(4, "4");
		testmap.put(5, "5");
		testmap.put(200, "200");
		Integer key = new Integer(200);
		Integer key2 = new Integer(200);
		System.err.println(testmap.get(key));
		System.err.println(testmap.get(key2));
	}
}
