/**
 *
 */
package com.jvs.uks.day03;

/**
 * @author: 	Shubham Bujurge
 * Created Date:09/05/2019 11:19 AM
 * Assignment:  Day 3
 * Task: 		String Tokenizer
 *
 */
public class StringTokenizer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestStringTokenizer objTestStringTokenizer = new TestStringTokenizer();
		if(args.length != 0 ){	//checks args is empty or not
			for(int i =0; i < args.length; i++)
				objTestStringTokenizer.displayColumn(args[i]);	//passing args arguments to method
		}
		else{
			System.out.println("Enter Command line arguments");	//message if cmd line args not passes
		}
	}

}
