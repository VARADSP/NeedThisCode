/**
 *
 */
package com.jvs.uks.day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author: 	Shubham Bujurge
 * Created Date:09/05/2019 03:30 PM
 * Assignment:  Day 3
 * Task: 		Date
 *
 */
public class DateAdd {
	public void addDate(String date,String type,String inctValue) throws ParseException{
		if(type.equals("day")){
			SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        Date d = DateFormat.parse(date);
	        System.out.println(d);
	        Calendar c = Calendar.getInstance();
	    	try{
	    	   c.setTime(DateFormat.parse(date));
	    	}catch(ParseException e){
	    	   e.printStackTrace();
	    	 }
	    	//Incrementing the date by n month and year
	    	c.add(Calendar.DATE, Integer.parseInt(inctValue));
	    	String newDate = DateFormat.format(c.getTime());
	    	System.out.println("Date Incremented by Days: "+newDate);
		}
		else if(type.equals("month")){
			SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        Date d = DateFormat.parse(date);
	        System.out.println(d);
	        Calendar c = Calendar.getInstance();
	    	try{
	    	   c.setTime(DateFormat.parse(date));
	    	}catch(ParseException e){
	    	   e.printStackTrace();
	    	 }
	    	//Incrementing the date by n month and year
	    	c.add(Calendar.MONTH,  Integer.parseInt(inctValue));
	    	String newDate = DateFormat.format(c.getTime());
	    	System.out.println("Date Incremented by Month: "+newDate);
		}
		else if(type.equals("year")){
			SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        Date d = DateFormat.parse(date);
	        System.out.println(d);
	        Calendar c = Calendar.getInstance();
	    	try{
	    	   c.setTime(DateFormat.parse(date));
	    	}catch(ParseException e){
	    	   e.printStackTrace();
	    	 }
	    	//Incrementing the date by n month and year
	    	c.add(Calendar.YEAR,  Integer.parseInt(inctValue));
	    	String newDate = DateFormat.format(c.getTime());
	    	System.out.println("Date Incremented by One Year: "+newDate);
		}
		else{
			System.out.println("Enter something wrong, type shoud be (day, month, year)");
		}
	}
}
