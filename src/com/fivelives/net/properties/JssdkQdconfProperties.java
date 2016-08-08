package com.fivelives.net.properties;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fivelives.net.utils.FileUtils;

@Component
public class JssdkQdconfProperties {
	
	private static Logger log = LoggerFactory.getLogger(JssdkQdconfProperties.class);
	
	
	public static boolean pageInit =false;
	
	private static long lastTime = 0;
	
//	public static ArrayList<String> jssdkArr = new ArrayList<>();
	
	public static HashMap<String,String> jssdkMap = new HashMap<String,String>();
	public static int jssdkCount=0;
	
	public static void initJsData() throws IOException{
		log.error("-------------initjssdkArrData-------------------");
		String file_s =Thread.currentThread().getContextClassLoader().getResource("").getPath() ;
		File file = new File(file_s+"/conf/jssdkconf_qd.properties");
		if(lastTime==file.lastModified())return;
		else lastTime=file.lastModified();
//		PropertiesUtils ssp = new PropertiesUtils("properties/page.properties");
		
		BufferedReader br = FileUtils.getFileReader(file.getPath());
		String line =null ;
		HashMap<String,String> map = new HashMap<String,String>();
		while((line=br.readLine())!=null){
			String []strs = line.split("=");
			map.put(strs[0], strs[1]);
		}
		jssdkMap = map;
		jssdkCount = map.size();
		log.error("--------PropertiesParameter.jssdkCount---------"+jssdkCount);
	}
	
}
