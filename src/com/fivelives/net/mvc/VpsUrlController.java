package com.fivelives.net.mvc;




import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fivelives.net.properties.IpblacklistProperties;


@Controller
@Scope("session")
public class VpsUrlController{

	 private static final org.slf4j.Logger log_err = LoggerFactory.getLogger(VpsUrlController.class);
	@RequestMapping("/spvurl.json")
    @ResponseBody
    public boolean spvurl(HttpServletRequest request) {
		
		String ip = request.getHeader("X-Real-IP");
		if(null == ip){
			ip = request.getRemoteAddr();
		}
		if(null != ip){
//			ip = "219.146.182.228";
			//黑名单ip查询,在黑名单中的ip,返回null
			String val = IpblacklistProperties.ipblacklistMap.get(ip);
			if(null != val){
				return false;
			}else{
				return true;
			}
		}else{
			log_err.error("X-Real-IP ip is null");
			return false;
		}
    }
	   
}
