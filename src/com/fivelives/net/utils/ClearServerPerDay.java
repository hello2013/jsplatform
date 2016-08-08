package com.fivelives.net.utils;

import java.io.IOException;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.LoggerFactory;

import com.fivelives.net.pojo.UserJsSite;



/**
 * 计数器清零
 * @author CYF
 *
 */
public class ClearServerPerDay extends TimerTask{
	 private static final org.slf4j.Logger log = LoggerFactory.getLogger(ClearServerPerDay.class);
	 
	public void initIpFrequencyMap(){
		PropertiesParameter.day_ip_count_shorturl = new ConcurrentHashMap<String, AtomicInteger>();
		log.error("day_ip_count_shorturl init="+PropertiesParameter.day_ip_count_shorturl.size());
		
		PropertiesParameter.day_ip_count_tj = new ConcurrentHashMap<String, AtomicInteger>();
		log.error("day_ip_count_tj init="+PropertiesParameter.day_ip_count_tj.size());
		
		PropertiesParameter.day_ip_ujs_tj = new ConcurrentHashMap<String, UserJsSite>();
		log.error("day_ip_ujs_tj init="+PropertiesParameter.day_ip_ujs_tj.size());
	}
	 
	 
	
	public static void main(String[] args) throws IOException {
	}
	@Override
	public void run() {
		this.initIpFrequencyMap();
	}
}
