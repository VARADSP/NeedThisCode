/**
 *
 */
package com.jvs.uks.day06.a1;

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
	void showDateDifference(String[] args)throws Exception {
		Date startDay = null;
		Date endDay = null;

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		try{
			startDay = format.parse(args[0]);
			endDay = format.parse(args[1]);
			//in milliseconds
			long diff = endDay.getTime() - startDay.getTime();
			long diffDays = diff / (24 * 60 * 60 * 1000);

			System.out.print(diffDays + " days, ");
		}
		finally{}
	}
}

