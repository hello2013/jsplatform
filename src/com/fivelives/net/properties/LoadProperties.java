package com.fivelives.net.properties;

import java.io.IOException;
import java.text.ParseException;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoadProperties extends TimerTask{
	Logger log = LoggerFactory.getLogger(LoadProperties.class);
	public void load() throws ParseException{
		try {
			IpblacklistProperties.initJsData();
			
			ShorturlconfProperties.initShorurlData();
			
			JssdkTjProperties.initJsData();
			
			ServerInfoProperties.initServerinof();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		log.debug("重新加载配置文件");
		try {
			this.load();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
}
