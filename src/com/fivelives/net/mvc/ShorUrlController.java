package com.fivelives.net.mvc;



import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fivelives.net.pojo.ShortUrl;
import com.fivelives.net.properties.IpblacklistProperties;
import com.fivelives.net.properties.ShorturlconfProperties;
import com.fivelives.net.utils.PropertiesParameter;


@Controller
@Scope("session")
public class ShorUrlController{

	 private static final org.slf4j.Logger log_err = LoggerFactory.getLogger(ShorUrlController.class);
	@RequestMapping("/shorturl.json")
    @ResponseBody
    public ShortUrl shorturl(int ua_type, HttpServletRequest request) {

		
//		log_err.error("ua_type="+ua_type);
		String ip = request.getHeader("X-Real-IP");
		if(null == ip){
			ip = request.getRemoteAddr();
		}
		if(null != ip){
			//黑名单ip查询,在黑名单中的ip,返回null
//			String val = IpblacklistProperties.ipblacklistMap.get(ip);
//			if(null != val){
//				return null;
//			}
			
//			//开启ip频控,关闭ip黑名单.
			AtomicInteger ai_ip = PropertiesParameter.day_ip_count_shorturl.get(ip);
			if(null != ai_ip){
				int aii = ai_ip.get();
				if(aii>PropertiesParameter.ipFrequencyPerDay_shorturl){
					log_err.error("ipFrequencyPerDay_shorturl get the max val="+ip);
					 return null;
				}else{
//					ai_ip.getAndIncrement();
				}
			}else{
				ai_ip = new AtomicInteger(0);
				PropertiesParameter.day_ip_count_shorturl.put(ip, ai_ip);
			}
			
			boolean isok = false;
			Random r= new Random();
			ShortUrl result=null;
			for(int i=0;i<ShorturlconfProperties.shorturCount;i++){
				if(isok){
					break;
				}
				ShortUrl su = ShorturlconfProperties.shotUrlMap.get(i);
				if( ua_type != su.getUa_type()){
					continue;
				}
				
				String date = PropertiesParameter.hour_date_format.format(Calendar.getInstance().getTime());
				String key = su.getName()+"_" +date;
				AtomicInteger ai =  PropertiesParameter.day_url_count.get(key);
				if(ai==null){
					ai = new AtomicInteger(0);
					PropertiesParameter.day_url_count.put(key, ai);
				}
				if(su.getMaxcount()<ai.get()){
					continue;
				}
				
				
				Double d = r.nextDouble();
				if(d<su.getRatio()){
					result = su;
					isok = true;
					ai.getAndIncrement();
				}
				
			}
			if(isok){
				ai_ip.getAndIncrement();
				return result;
			}else{
				return null;
			}
		}else{
			log_err.error("X-Real-IP ip is null");
			return null;
		}
    }
	   
//	@RequestMapping("/shorturl_tj.json")
//    @ResponseBody
//	public ShortUrl shorturl_tj(int ua_type, HttpServletRequest request){
//
//		
//		log_err.error("ua_type="+ua_type);
//		String ip = request.getHeader("X-Real-IP");
//		if(null == ip){
//			ip = request.getRemoteAddr();
//		}
//		if(null != ip){
//			//黑名单ip查询,在黑名单中的ip,返回null
//			String val = IpblacklistProperties.ipblacklistMap.get(ip);
//			if(null != val){
//				return null;
//			}
//			
//			boolean isok = false;
//			Random r= new Random();
//			ShortUrl result=null;
//			for(int i=0;i<ShorturlconfProperties.shorturCount;i++){
//				if(isok){
//					break;
//				}
//				ShortUrl su = ShorturlconfProperties.shotUrlMap.get(i);
//				if( ua_type != su.getUa_type()){
//					continue;
//				}
//				
//				String date = PropertiesParameter.hour_date_format.format(Calendar.getInstance().getTime());
//				String key = su.getName()+"_" +date;
//				AtomicInteger ai =  PropertiesParameter.day_clk.get(key);
//				if(ai==null){
//					ai = new AtomicInteger(0);
//					PropertiesParameter.day_clk.put(date, ai);
//				}
//				if(su.getMaxcount()<ai.get()){
//					continue;
//				}
//				
//				
//				Double d = r.nextDouble();
//				if(d<su.getRatio()){
//					result = su;
//					isok = true;
//					ai.getAndIncrement();
//				}
//				
//			}
//			if(isok){
//				return result;
//			}else{
//				return null;
//			}
//		}else{
//			log_err.error("X-Real-IP ip is null");
//			return null;
//		}
//    }
}
