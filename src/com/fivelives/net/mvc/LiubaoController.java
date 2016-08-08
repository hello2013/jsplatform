package com.fivelives.net.mvc;

import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fivelives.net.logger.liubaoclk.LiuBaoClk;
import com.fivelives.net.utils.PropertiesParameter;
@Controller
@Scope("session")
public class LiubaoController {
//	private static final org.slf4j.Logger log = LoggerFactory.getLogger(LiuBaoClk.class);
		@RequestMapping("/liubao")
      public String liubao(){
			
			String str = PropertiesParameter.hour_date_format.format(Calendar.getInstance().getTime());
			
			Integer imp = PropertiesParameter.hour_imp.get(str);
			if(imp==null)imp=0;
			//小于最小值,不做请求处理
			if(imp<PropertiesParameter.liubao_min_count){
				return ("forward:/404.html"); 
			}
			AtomicInteger ai = PropertiesParameter.hour_clk.get(str);
			if(null == ai){
				ai = new AtomicInteger();
				PropertiesParameter.hour_clk.put(str, ai);
			}
			int clk =ai.get();
			double ctr= Double.valueOf(clk)/imp;
			if(ctr>PropertiesParameter.liubao_max_ctr){
				return ("forward:/404.html"); 
			}
			String url ="http://jsq.fivelives.net/jsquery/lbad.html";
			double random = Math.random();
			if(random<0.66){
//				clk++;
				PropertiesParameter.hour_clk.get(str).getAndIncrement();
//				liubao_clk_path_suf
//				PropertiesParameter.hour_clk.put(str, clk);
			}
			
			return ("redirect:"+url);  
      }
}
