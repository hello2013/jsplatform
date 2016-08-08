package com.fivelives.net.mvc;


import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fivelives.net.pojo.UserJsSite;
import com.fivelives.net.properties.JssdkQdconfProperties;


@Controller
@Scope("session")
public class JsonpQudaoController{
	 private static final org.slf4j.Logger log = LoggerFactory.getLogger(JsonpQudaoController.class);
	@RequestMapping("/jsonp_qd.json")
    @ResponseBody
    public UserJsSite jsonp2qd(String ad_qdid) {
		
		   String result =	JssdkQdconfProperties.jssdkMap.get(ad_qdid);
		   if(null == result){
			   log.error("this qudao id is not EXISTS="+ad_qdid);
			   return null;
		   }
		   
		String strs[]=   result.split(",");
//		UserJsSite uj = UserJsSite.getUserJsonp(strs[0],strs[1],strs[2]);
//		uj.setPub(strs[0]);
//		uj.setSlot(strs[1]);
//		uj.setSrc(strs[2]);
		log.error("req by qudao="+ad_qdid);
        return null;
    }
	   
	  
}
