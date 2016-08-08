package com.fivelives.net.test;

import com.fivelives.net.pojo.UserJsSite;


public class JobJsonp implements Runnable{
	  
    @Override  
    public void run() {  
//        System.out.printf("%s: Going to print a document\n", Thread  
//                .currentThread().getName());  
        int random = Double.valueOf(Math.random()*3).intValue();
//        System.out.println("random="+random);
//       UserJsSite.getUserJsonp("1", random+"", "2");
//        System.out.printf("%s: The document has been printed\n", Thread  
//                .currentThread().getName());  
    }  
}
