package com.fivelives.net.properties;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import com.fivelives.net.utils.ClearServerPerDay;

public class ServerInitCenter implements InitializingBean{
	 private static final Logger log = LoggerFactory.getLogger(ServerInitCenter.class);
	@Override
	public void afterPropertiesSet(){
		log.error("-----------ServerInitCenter.start--------------------------------------");
		this.init();
		log.error("-----------ServerInitCenter.end--------------------------------------");
	}
	
	public void init(){
		
		log.error("--------initing-----------------------");
		//初始化数据
		LoadProperties prop = new LoadProperties();
		try {
			prop.load();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Timer timer = new Timer();
		timer.schedule(prop, 600000,600000);
		
		
		
		Calendar calendar_day = Calendar.getInstance();
		calendar_day.set(Calendar.SECOND, 0);
		calendar_day.set(Calendar.MINUTE, 0);
		calendar_day.set(Calendar.HOUR_OF_DAY,0);
		calendar_day.add(Calendar.DAY_OF_YEAR, 1);
		ClearServerPerDay csp = new ClearServerPerDay();
		csp.initIpFrequencyMap();
		
		Timer timer_server = new Timer();
		timer_server.schedule(csp, calendar_day.getTime(), 86400000);
	}

}
