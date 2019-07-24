/**
 *
 */
package com.jvs.uks.day03;

import java.text.DecimalFormat;

/**
 * @author: 	Shubham Bujurge
 * Created Date:09/05/2019 03:30 AM
 * Assignment:  Day 3
 * Task: 		Date
 *
 */
public class FormattedNumber {

	/**
	 * @param args
	 * @throws Exception
	 */
	private static DecimalFormat formatter; // = new DecimalFormat();
	public static void main(String[] args) throws Exception {
		FormattedNumber obj = new FormattedNumber();
		if(args.length == 2){
			String res = obj.formattingOfNumber(args[0], Double.parseDouble(args[1]));	//passing parrameter and return string as format
			System.out.println(res);
		}
		else
			System.out.println("Enter command line arguments");
	}

	String formattingOfNumber(String type, Double number) throws Exception{
		formatter = new DecimalFormat(type);	//assign a format
		String formattedNumber = formatter.format(number);	//number is passing cheack the format
		return "Number:" + number + ", Pattern:" + type + ", Formatted Number:" + formattedNumber;	//returning the string
	}
}
