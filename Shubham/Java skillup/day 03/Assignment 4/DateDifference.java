/**
 *
 */
package com.jvs.uks.day03;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * @author: 	Shubham Bujurge
 * Created Date:09/05/2019 2:46 PM
 * Assignment:  Day 3
 * Task: 		Date Difference
 *
 */
public class DateDifference {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		DateDifference obj = new DateDifference();
		if(args.length == 2)	//checking enter both the dates or not
			obj.showDateDifference(args);
		else
			System.out.print("Enter start Date and end Date both the dates");
	}

	public void showDateDifference(String[] args)throws Exception {
		Date startDay = null;
		Date endDay = null;

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");	//format of date

		try{
			startDay = format.parse(args[0]);
			endDay = format.parse(args[1]);
			//in milliseconds
			long diff = endDay.getTime() - startDay.getTime();
			long diffDays = diff / (24 * 60 * 60 * 1000);	//milliseconds converts into dates

			System.out.print(diffDays + " days, ");
		}
		finally{}
	}
}

