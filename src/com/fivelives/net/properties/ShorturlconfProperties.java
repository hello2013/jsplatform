package com.fivelives.net.properties;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fivelives.net.pojo.ShortUrl;
import com.fivelives.net.utils.FileUtils;

@Component
public class ShorturlconfProperties {
	
	private static Logger log = LoggerFactory.getLogger(ShorturlconfProperties.class);
	
	
	public static boolean pageInit =false;
	
	private static long lastTime = 0;
	
	
	public static ConcurrentHashMap<Integer, ShortUrl> shotUrlMap = new ConcurrentHashMap<Integer, ShortUrl>();
	public static int shorturCount=0;
	
	public static void initShorurlData() throws IOException{
		log.error("-------------initjssdkArrData-------------------");
		String file_s =Thread.currentThread().getContextClassLoader().getResource("").getPath() ;
		File file = new File(file_s+"/conf/shorturlconf.properties");
		if(lastTime==file.lastModified())return;
		else lastTime=file.lastModified();
//		PropertiesUtils ssp = new PropertiesUtils("properties/page.properties");
		
		BufferedReader br = FileUtils.getFileReader(file.getPath());
		String line =null ;
		ConcurrentHashMap<Integer, ShortUrl> tempmap = new ConcurrentHashMap<Integer, ShortUrl>();
		while((line=br.readLine())!=null){
			ShortUrl url = new ShortUrl();
			String strs[] = line.split(",");
			url.setName(strs[0]);
			url.setUrl(strs[1]);
			url.setMaxcount(Integer.valueOf(strs[2]));
			url.setRatio(Double.valueOf(strs[3]));
			url.setUa_type(Integer.valueOf(strs[4]));
			tempmap.put(tempmap.size(), url);
		}
		shotUrlMap = tempmap;
		shorturCount = shotUrlMap.size();
		log.error("--------PropertiesParameter.ShortCount---------"+shorturCount);
	}
	
}
