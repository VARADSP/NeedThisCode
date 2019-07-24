/**
 *
 */
package com.uks.shubham.core.day4;

/**
 * @author: 	Shubham Bujurge
 * Created Date:08/05/2019 10: 19 AM
 * Assignment:  Day 2
 * Task: 		String Manipulation & Regular expression
 *
 */
public class StringManipulationRegEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringOperationRegEx objStringOperation = new StringOperationRegEx();
		int operation = Integer.parseInt(args[0]);
		objStringOperation.doOperationWithRegEx(operation, args);
	}

}
