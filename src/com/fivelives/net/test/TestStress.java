package com.fivelives.net.test;

import java.util.concurrent.atomic.AtomicInteger;

public class TestStress {
	public static void main(String[] args) {
		AtomicInteger ai = new AtomicInteger();
		System.err.println(ai.get());
	}
	
	
}
