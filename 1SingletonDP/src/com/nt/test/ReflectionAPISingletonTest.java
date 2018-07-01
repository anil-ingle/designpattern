package com.nt.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import com.nt.singleton.PrinterUtil;

public class ReflectionAPISingletonTest {
	public static void main(String[] args) {
		PrinterUtil util = null, util1 = null;
		Class clazz = null;
		Constructor cons[] = null;
		// get Singleton class object
		util = PrinterUtil.getInstance();
		try {
			// create obj for PrinterUtil by Accessing private Constructor of
			// that class
			// load class
			clazz = Class.forName("com.nt.singleton.PrinterUtil");
			// get All consturctors of the class
			cons = clazz.getDeclaredConstructors();
			// provide access to private constructor
			cons[0].setAccessible(true);
			// dear Santosh just i am adding this four following line
			Field f = (PrinterUtil.class).getDeclaredField("isInstantiated");
			f.setAccessible(true); 
			f.set(true,false); 
			// creating obj using the Accessed constructor
			util1 = (PrinterUtil) cons[0].newInstance(null);
			System.out.println("util hashCode:::" + util.hashCode());
			System.out.println("util1 hashCode:::" + util1.hashCode());
		} // try
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
