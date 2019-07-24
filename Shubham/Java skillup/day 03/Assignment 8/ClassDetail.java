/**
 *
 */
package com.jvs.uks.day03;

import java.lang.reflect.Constructor;
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

	public int i= 0;
	public void random(){
		System.out.println("Hey");
	}
	@SuppressWarnings("rawtypes")
	public void infoAll(String name, String type) {
		if(type.equals("all")){
			try {
				Class<?> aClass = Class.forName(name);
				Constructor[] constructors = aClass.getConstructors();
				for(Constructor<?> constructor:constructors)
				{
					System.out.println(constructor.getName());
				}
				System.out.println(constructors);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(type.equals("F")){
			try {
				Class<?> aClass = Class.forName(name);
				Field[] fields = aClass.getFields();
				for(Field field:fields)
				{
					System.out.println(field.getName());
				}
				System.out.println(fields);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(type.equals("M")){
			// Getting methods of the class through the object
			try {
				Class<?> aClass = Class.forName(name);
				Method[] methods = aClass.getMethods();
				for(Method method:methods)
				{
					System.out.println(method.getName());
				}
				System.out.println(methods);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
