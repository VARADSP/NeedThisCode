/**
 *
 */
package com.uks.shubham.core.day4;

/**
  * @author: 	Shubham Bujurge
 * Created Date:07/05/2019 01: 21 PM
 * Assignment:  Day 1
 * Task: 		Reading undefined number of Command Line Argument Program
 *
 */
public class TestMultiCommandLine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length != 0){
			//Creating the object and passing command line argument to the function
			MultiCommandLine multiCommandObj = new MultiCommandLine();
			multiCommandObj.doOperation(args);
		}
		else
			System.out.println("Commanad line arguments is empty");
	}

}
