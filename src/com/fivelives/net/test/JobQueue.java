package com.fivelives.net.test;

public class JobQueue implements Runnable{
	private PrintQueue printQueue;  
	  
    public JobQueue(PrintQueue printQueue) {  
        this.printQueue = printQueue;  
    }  
  
    @Override  
    public void run() {  
        System.out.printf("%s: Going to print a document\n", Thread  
                .currentThread().getName());  
        printQueue.printJob(new Object());  
        System.out.printf("%s: The document has been printed\n", Thread  
                .currentThread().getName());  
    }  
}
