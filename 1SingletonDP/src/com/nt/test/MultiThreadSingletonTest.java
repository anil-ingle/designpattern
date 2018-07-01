package com.nt.test;

import com.nt.singleton.PrinterUtil;

class  TicketPrinterServlet implements Runnable{

	@Override
	public void run() {
		PrinterUtil util=null;
		//gives PrinterUtil class obj
		util=PrinterUtil.getInstance();
		System.out.println("Current thread name::"+Thread.currentThread().getName());
		System.out.println("PrintUtil class object hashCode"+util.hashCode());
	}//run()

}//class


public class MultiThreadSingletonTest {

	public static void main(String[] args) {
		TicketPrinterServlet servlet=null;
		Thread req1=null,req2=null;
		//create  TicketPrinterServlet class obj
		servlet=new TicketPrinterServlet();
		//Start threads representing requests
		req1=new Thread(servlet);
		req2=new Thread(servlet);
		//start threads 
		req1.start();
		req2.start();
	}//main
}//class
