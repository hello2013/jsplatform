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

import com.fivelives.net.pojo.UserJsSite;
import com.fivelives.net.utils.FileUtils;

@Component
public class JssdkTjProperties {
	
	private static Logger log = LoggerFactory.getLogger(JssdkTjProperties.class);
	
	
	public static boolean pageInit =false;
	
	private static long lastTime = 0;
	
//	public static ArrayList<String> jssdkArr = new ArrayList<>();
	
	public static HashMap<Integer,ArrayList<UserJsSite>> ujsMap= new HashMap<Integer,ArrayList<UserJsSite>>();
	
//	public static int jssdkCount=0;
	
	public static void initJsData() throws IOException{
		log.error("-------------JssdkTjProperties-------------------");
		String file_s =Thread.currentThread().getContextClassLoader().getResource("").getPath() ;
		File file = new File(file_s+"/conf/jssdk_tj.properties");
		if(lastTime==file.lastModified())return;
		else lastTime=file.lastModified();
//		PropertiesUtils ssp = new PropertiesUtils("properties/page.properties");
		
		BufferedReader br = FileUtils.getFileReader(file.getPath());
		String line =null ;
//		ArrayList<String> arr = new ArrayList<String>();
		HashMap<Integer,ArrayList<UserJsSite>> tempMap= new HashMap<Integer,ArrayList<UserJsSite>>();
		while((line=br.readLine())!=null){
//			arr.add(line);
			String strs[]=line.split(",");
			UserJsSite ujs = new UserJsSite();
			ujs.setPub(strs[0]);
			ujs.setSlot(strs[1]);
			ujs.setSrc(strs[2]);
			ujs.setMaxcount(Integer.parseInt(strs[3]));
			ujs.setRatio(Double.parseDouble(strs[4]));
			ujs.setUa_type(Integer.parseInt(strs[5]));
			ArrayList<UserJsSite> arrs = tempMap.get(ujs.getUa_type());
			if(null==arrs){
				arrs = new ArrayList<UserJsSite>();
				tempMap.put(ujs.getUa_type(), arrs);
			}
			
			arrs.add(ujs);
		}
		ujsMap = tempMap;
		log.error("--------JssdkTjProperties.ujsMap---------"+ujsMap.size());
	}
	
}
