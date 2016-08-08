package com.fivelives.net.test;
  
public class PrintJsonp {  
      
      
    public static void main(String[] args) {  
    	JobJsonp jj = new JobJsonp();
        Thread thread[] = new Thread[100];  
        for(int i = 0; i < 100; i++) {  
            thread[i] = new Thread(jj, "Thread " + i);  
             
        }  
        for(int i = 0; i < 100; i++) {  
        	thread[i].start(); 
        }  
    }  
}  