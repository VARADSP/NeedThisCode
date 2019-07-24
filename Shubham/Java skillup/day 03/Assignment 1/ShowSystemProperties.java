/**
 *
 */
package com.jvs.uks.day03;

/**
 * @author: 	Shubham Bujurge
 * Created Date:08/05/2019 08: 49 AM
 * Assignment:  Day 3
 * Task: 		System Properties in java
 *
 */
public class ShowSystemProperties {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length != 0){
			//Creating a object and passing the parameter to the method
			SystemProperties objSysProp = new SystemProperties();
			objSysProp.getParameter(args);	//calling method
		}
		else{
			System.out.println("No command line argument is passed");
		}
	}

}
