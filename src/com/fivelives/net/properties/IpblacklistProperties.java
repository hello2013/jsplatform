package com.fivelives.net.properties;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fivelives.net.utils.FileUtils;

@Component
public class IpblacklistProperties {
	
	private static Logger log = LoggerFactory.getLogger(IpblacklistProperties.class);
	
	
	public static boolean pageInit =false;
	
	private static long lastTime = 0;
	
	public static int jssdkCount=0;
	
	public static ConcurrentHashMap<String, String> ipblacklistMap = new ConcurrentHashMap<String, String>();
	
	public static void initJsData() throws IOException{
		
		String file_s =Thread.currentThread().getContextClassLoader().getResource("").getPath() ;
		File file = new File(file_s+"/conf/ipblacklist.properties");
		if(lastTime==file.lastModified())return;
		else lastTime=file.lastModified();
		log.error("-------------ipblacklistMap-------------------");
		BufferedReader br = FileUtils.getFileReader(file.getPath());
		String line =null ;
		ConcurrentHashMap<String, String> tempMap = new ConcurrentHashMap<String, String>();
		while((line=br.readLine())!=null){
			String strs[]= line.split(" ");
			tempMap.put(strs[0], strs[1]);
		}
		ipblacklistMap = tempMap;
		log.error("--------IpblacklistProperties.ipblacklistMap---------"+ipblacklistMap.size());
	}
	
}
