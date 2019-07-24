/**
 *
 */
package com.uks.shubham.core.day4;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author: 	Shubham Bujurge
 * Created Date:09/05/2019 05:45 PM
 * Assignment:  Day 3
 * Task: 		Class Details
 *
 */
public class ClassDetail {

	public void random(){
		System.out.println("Hey");
	}
	public void infoAll(String name, String type) throws Exception, IllegalArgumentException, ReflectiveOperationException{
		//Test aClass = new Test();
		Class<?> newClass = Class.forName(name);
		Object obj = newClass.newInstance();
		Class<? extends Object> cls = obj.getClass();
		// Creating class object from the object using
        // getclass method
        //Class cls = aClass.getClass();
		if(type.equals("all")){
	        System.out.println("The name of class is " + cls.getName());
		}
		else if(type.equals("F")){
			System.out.println("The public methods of class are : ");
	        Field field = cls.getDeclaredField("s");
	        field.setAccessible(true);
	        field.set(obj, "JAVA");
		}
		else if(type.equals("M")){
			// Getting methods of the class through the object
	        // of the class by using getMethods
	        Method[] methods = cls.getMethods();
	        // Printing method names
	        for (Method method:methods)
	            System.out.println(method.getName());

		}
	}
}
