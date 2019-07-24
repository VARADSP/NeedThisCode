/**
 *
 */
package com.uks.shubham.core.day4;

/**
 * @author: 	Shubham Bujurge
 * Created Date:08/05/2019 02: 33 PM
 * Assignment:  Day 2
 * Task: 		String Manipulation
 *
 */
public class StringManipulation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringOperation objStringOperation = new StringOperation();
		int operation = Integer.parseInt(args[0]);
		objStringOperation.doOperationWithRegEx(operation, args);

	}

}
