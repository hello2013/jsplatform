package com.fivelives.net.mvc;



import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fivelives.net.logger.liubao.LiuBaoLog;
import com.fivelives.net.pojo.ShortUrl;
import com.fivelives.net.pojo.UserJsSite;
import com.fivelives.net.properties.IpblacklistProperties;
import com.fivelives.net.properties.JssdkTjProperties;
import com.fivelives.net.properties.ShorturlconfProperties;
import com.fivelives.net.utils.PropertiesParameter;


@Controller
@Scope("session")
public class JsdTjController{

//	 private static final org.slf4j.Logger log = LoggerFactory.getLogger(LiuBaoLog.class);
	 private static final org.slf4j.Logger log_err = LoggerFactory.getLogger(JsdTjController.class);
	@RequestMapping("/shorturl_tj.json")
    @ResponseBody
    public UserJsSite jsonp_tj(int ua_type,HttpServletRequest request) {
		
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
			
			AtomicInteger ai_ip = PropertiesParameter.day_ip_count_tj.get(ip);
			if(null != ai_ip){
				int aii = ai_ip.get();
				if(aii>PropertiesParameter.ipFrequencyPerDay_tj){
					log_err.error("ipFrequencyPerDay_tj get the max val="+ip);
					 return null;
				}
			}else{
				ai_ip = new AtomicInteger(0);
				PropertiesParameter.day_ip_count_tj.put(ip, ai_ip);
			}
			
			
			if(JssdkTjProperties.ujsMap.size()>0){
				
//				控制ip只返回特定账号
				UserJsSite ujs = PropertiesParameter.day_ip_ujs_tj.get(ip);
				
				
				if(ujs != null){
					ai_ip.getAndIncrement();
					return ujs;
				}else{
					ArrayList<UserJsSite> arrs = JssdkTjProperties.ujsMap.get(ua_type);
					if(null == arrs || arrs.size()==0){
						return null;
					}
					int random = Double.valueOf(Math.random()*arrs.size()).intValue();
					ujs = arrs.get(random);
					
					double random_return = Math.random();
					if(random_return>ujs.getRatio()){
						return null;
					}else{
						PropertiesParameter.day_ip_ujs_tj.put(ip, ujs);
						ai_ip.getAndIncrement();
						  return ujs;
					}
					
				      
				}
				
				
			}else{
				return null;
			}
			  
		}else{
			log_err.error("X-Real-IP ip is null");
			return null;
		}
		
		
    }
	   
	@RequestMapping("/removeip_count_tj.json")
    @ResponseBody
    public void removeip_count_tj(HttpServletRequest request) {
		String ip = request.getHeader("X-Real-IP");
		if(null == ip){
			ip = request.getRemoteAddr();
		}
		if(null != ip){
			if(PropertiesParameter.day_ip_ujs_tj.containsKey(ip)){
				PropertiesParameter.day_ip_ujs_tj.remove(ip);
			}
			
		}
	}
	
}
