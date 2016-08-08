package com.fivelives.net.mvc;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;
@ControllerAdvice(basePackages = "com.fivelives.net.mvc")
public class JsonpAdvice  extends AbstractJsonpResponseBodyAdvice{
	public JsonpAdvice() {  
        super("callback", "jsonp"); //指定jsonpParameterNames  
    }  
}
