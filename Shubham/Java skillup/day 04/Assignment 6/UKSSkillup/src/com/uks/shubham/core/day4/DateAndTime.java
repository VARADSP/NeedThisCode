package com.uks.shubham.core.day4;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * @author: 	Shubham Bujurge
 * Created Date:09/05/2019 11:35 AM
 * Assignment:  Day 3
 * Task: 		Date And Time
 *
 */
public class DateAndTime {
	void printDate(String[] args) throws Exception{
		if(args.length == 1){
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat(args[0]);	//For formatting pass the argument
			formatter = new SimpleDateFormat(args[0]);	//For formatting pass the argument
			String strDate = formatter.format(date);
			System.out.println(strDate);
		}
		else if(args.length == 2){
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = formatter.parse(args[1]);
			System.out.println("Date is: "+ date);
		}
		else if(args.length == 0){
			Date date = new Date();
		    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		    String strDate= formatter.format(date);
		    System.out.println(strDate);
		}
		else{
			System.out.println("Entered the wroung input");
		}
	}
}
