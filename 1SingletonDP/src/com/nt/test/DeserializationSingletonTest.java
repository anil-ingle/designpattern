package com.nt.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.nt.singleton.PrinterUtil;
import com.nt.singleton.PrinterUtil1;

public class DeserializationSingletonTest {
	public static void main(String[] args) {
		PrinterUtil util=null,util1=null;
		ObjectOutputStream oos=null;
		ObjectInputStream ois=null;
		//get Singleton class obj
		util=PrinterUtil.getInstance();
		try{
		//perform Serialization
		oos=new ObjectOutputStream(new FileOutputStream("Printer.ser"));
		oos.writeObject(util);
		oos.flush();
		oos.close();
		System.out.println("Serailization is completed");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		//Perform DeSerialization
		try{
			ois=new ObjectInputStream(new FileInputStream("Printer.ser"));
			util1=(PrinterUtil)ois.readObject();
			ois.close();
			System.out.println("Deserilization is completed");
			System.out.println("util hashCode:"+util.hashCode());
			System.out.println("util1 hashCode:"+util1.hashCode());
		}//try
		catch(Exception e){
			e.printStackTrace();
		} 
		
	}//main
}//class
