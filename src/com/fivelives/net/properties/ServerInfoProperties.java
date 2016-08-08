package com.fivelives.net.properties;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fivelives.net.utils.PropertiesParameter;
import com.fivelives.net.utils.PropertiesUtils;

@Component
public class ServerInfoProperties {
	
	private static Logger log = LoggerFactory.getLogger(ServerInfoProperties.class);
	
	public static boolean pageInit =false;
	
	private static long lastTime = 0;
	
	
	public static void initServerinof() throws IOException{
		System.err.println("-------------initServerinof-------------------");
		String file_s =ServerInfoProperties.class.getClassLoader().getResource("/conf/serverinfo.properties").getFile();
		File file = new File(file_s);
		if(lastTime==file.lastModified())return;
		else lastTime=file.lastModified();
		
		PropertiesUtils ssp = new PropertiesUtils(file_s);
		Properties prop = ssp.getProperties();
		
		PropertiesParameter.ipFrequencyPerDay_shorturl = Integer.valueOf(prop.getProperty("ipFrequencyPerDay_shorturl"));
		PropertiesParameter.ipFrequencyPerDay_tj = Integer.valueOf(prop.getProperty("ipFrequencyPerDay_tj"));
		
		log.error("ipFrequencyPerDay_shorturl="+PropertiesParameter.ipFrequencyPerDay_shorturl);
		log.error("ipFrequencyPerDay_tj="+PropertiesParameter.ipFrequencyPerDay_tj);
	}
	
}
