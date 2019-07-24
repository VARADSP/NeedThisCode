/**
 *
 */
package com.uks.shubham.core.day4;

import java.text.DecimalFormat;
import java.util.Scanner;

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
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter which format should number convert ");
		String numType = sc.nextLine();
		System.out.println("Enter number to be convert ");
		double  numDouble = sc.nextDouble();
		sc.close();
		FormattedNumber obj = new FormattedNumber();
		obj.formattingOfNumber(numType, numDouble);
	}

	void formattingOfNumber(String type, Double number) throws Exception{
		//if(type.equalsIgnoreCase("decimal")){
				DecimalFormat numberFormat = new DecimalFormat("type");
				System.out.println(numberFormat.format(number));
		//}
	}
}
