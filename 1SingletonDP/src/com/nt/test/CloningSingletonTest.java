package com.nt.test;

import com.nt.singleton.PrinterUtil;

public class CloningSingletonTest {

	public static void main(String[] args) {
		PrinterUtil util=null;
		PrinterUtil util1=null;
		try{
			util=PrinterUtil.getInstance();
			//perform cloning
			util1=(PrinterUtil) util.clone();
			System.out.println("util obj hashCode::"+util.hashCode());
			System.out.println("util1 obj hashCode::"+util1.hashCode());
		}//try
		catch(CloneNotSupportedException cnse ){
		cnse.printStackTrace();
     	}
		catch(Exception e){
			e.printStackTrace();
		}
	}//main
}//class
