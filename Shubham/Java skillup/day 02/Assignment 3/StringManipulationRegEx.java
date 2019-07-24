/**
 *
 */
package com.jvs.uks.day02;

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
		if(args.length > 0){
			StringOperationRegEx objStringOperation = new StringOperationRegEx();
			int operation = Integer.parseInt(args[0]);
			objStringOperation.doOperationWithRegEx(operation, args);
		}
		else{
			System.out.println("Pleas Pass the command line arguments");
		}
	}

}
