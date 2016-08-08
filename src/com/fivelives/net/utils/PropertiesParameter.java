package com.fivelives.net.utils;

import java.text.SimpleDateFormat;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import com.fivelives.net.pojo.UserJsSite;


public class PropertiesParameter {
	
	public static ConcurrentHashMap<String, Integer> hour_imp = new ConcurrentHashMap<String, Integer>();
	public static ConcurrentHashMap<String, AtomicInteger> hour_clk = new ConcurrentHashMap<String, AtomicInteger>();
	
	public static SimpleDateFormat hour_date_format=new SimpleDateFormat("yyyyMMddHH"); 
	
	public static int liubao_min_count = 1000;
	public static double liubao_max_ctr = 0.006;
	
	public static String liubao_log_path_pre = "/data/logs/jsq1/liubao/liubao_";
	public static String liubao_log_path_suf = ".log";
	public static String liubao_clk_path_suf = ".log";
	
	
	// shorturl 短链:使用控量
	public static ConcurrentHashMap<String, AtomicInteger> day_url_count = new ConcurrentHashMap<String, AtomicInteger>();
	
	//shorturl  ip:频控  shorturl业务
	public static ConcurrentHashMap<String, AtomicInteger> day_ip_count_shorturl = new ConcurrentHashMap<String, AtomicInteger>();
	public static int ipFrequencyPerDay_shorturl = 500;
	
	// tj 控量
	public static ConcurrentHashMap<String, AtomicInteger> day_ip_count_tj = new ConcurrentHashMap<String, AtomicInteger>();
	public static int ipFrequencyPerDay_tj = 500;
	public static ConcurrentHashMap<String, UserJsSite> day_ip_ujs_tj = new ConcurrentHashMap<String, UserJsSite>();
	
	
	
	public static SimpleDateFormat date_format=new SimpleDateFormat("yyyyMMdd"); 
	
	
}
