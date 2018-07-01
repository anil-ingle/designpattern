package com.nt.singleton;

import com.nt.utils.CommonsUtil;

public class PrinterUtil1 extends CommonsUtil {
	//same class type member variable in the class itself
	  private volatile  static PrinterUtil1 instance=null;
	  private static boolean isInstantiated=false;
	  //private static PrinterUtil instance=new PrinterUtil(); //eager instantitaion
	/*private static PrinterUtil instance;
	static{
		instance=new PrinterUtil();  //eager instantation..
	}
	*/
		
	//private constructor to constructor based instatiation from outside the class
	private PrinterUtil1(){
		System.out.println("PrinterUtil:0-param constructor");
		if(isInstantiated==true)
			throw new IllegalArgumentException("We can not create multiple objs for singleton class");
		else
			isInstantiated=true;
	}
	
	//To Stop cloning...
	@Override
	public Object clone() throws CloneNotSupportedException {
      throw new CloneNotSupportedException();	
	}
	
/*	public static PrinterUtil getInstance(){
		return instance;
	}
*/	
	/*//static factory method having singleton logic
	public synchronized static PrinterUtil getInstance(){   //lazy instantiation
		if(instance==null){
			instance=new PrinterUtil();
		}
		return instance;
	}//method
*/
	
	public static PrinterUtil1 getInstance(){   //lazy instantiation
		if(instance==null){ //1st level check
	      synchronized(PrinterUtil1.class)	{
		     if(instance==null){  //2nd level check
		    	instance=new PrinterUtil1();
	     	} //if
	   }//synchronized
	}//if
		return instance;
	}//method
	
	  public Object readResolve(){
		  System.out.println("readResolve()");
		  return instance;
	  }
}//class
