/**
 *
 */
package com.jvs.uks.day03;

import java.text.ParseException;

/**
  * @author: 	Shubham Bujurge
 * Created Date:09/05/2019 03:40 AM
 * Assignment:  Day 3
 * Task: 		Date
 *
 */
public class SetAddDate {

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		DateAdd objDate = new DateAdd();
		if(args.length == 3)
		objDate.addDate(args[0], args[1], args[2]);
		else
			System.out.println("Enter date, type (day, month or year) and incements by");
	}

}
