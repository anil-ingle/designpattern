package com.nt.test;

import com.nt.singleton.PrinterUtil;

public class SingletonTest {

	public static void main(String[] args){
		PrinterUtil util1=null,util2=null;
		//get PrinterUtil class obj
		util1=PrinterUtil.getInstance();
		util2=PrinterUtil.getInstance();
		
		//display hashcodes
		System.out.println("util1 hashcode:"+util1.hashCode());
		System.out.println("util2 hashcode:"+util2.hashCode());
		//compare references
		System.out.println("util1==util2?::"+(util1==util2));
	}//main
}//class
