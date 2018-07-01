package com.nt.singleton;

import com.nt.utils.CommonsUtil;

public class PrinterUtil extends CommonsUtil{
	private static volatile PrinterUtil instance;
	private static boolean isInstantiated=false;
	
	//private constructor
	private PrinterUtil(){
		if(isInstantiated)
			throw new IllegalArgumentException("Second obj is created for Singleton--BadPratice");
		else
			isInstantiated=true;
	}
	
	public static final PrinterUtil getInstance(){
		if(instance==null) { //1st null Check
			  synchronized(PrinterUtil.class){
				  if(instance==null){
					  instance=new PrinterUtil();
				  }//if
			  }//synchronized
		}//if
		return instance;
	}//method
	
	// protection from cloning
@Override
public Object clone() throws CloneNotSupportedException {
  throw new CloneNotSupportedException();
}

//protection from  Deserialization
public Object readResolve(){
	return instance;
 }

}//class
