/**
 *
 */
package com.jvs.uks.day06.a1;

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
	public void addDate(String strDate,String strType,int intNumber) throws ParseException{
		if(strType.equals("day")){
			SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        Date d = DateFormat.parse(strDate);
	        System.out.println(d);
	        Calendar c = Calendar.getInstance();
	    	try{
	    	   c.setTime(DateFormat.parse(strDate));
	    	}catch(ParseException e){
	    	   e.printStackTrace();
	    	 }
	    	//Incrementing the date by n month and year
	    	c.add(Calendar.DATE, intNumber);
	    	String newDate = DateFormat.format(c.getTime());
	    	System.out.println("Date Incremented by Days: "+newDate);
		}
		else if(strType.equals("month")){
			SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        Date d = DateFormat.parse(strDate);
	        System.out.println(d);
	        Calendar c = Calendar.getInstance();
	    	try{
	    	   c.setTime(DateFormat.parse(strDate));
	    	}catch(ParseException e){
	    	   e.printStackTrace();
	    	 }
	    	//Incrementing the date by n month and year
	    	c.add(Calendar.MONTH, intNumber);
	    	String newDate = DateFormat.format(c.getTime());
	    	System.out.println("Date Incremented by Month: "+newDate);
		}
		else if(strType.equals("year")){
			SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        Date d = DateFormat.parse(strDate);
	        System.out.println(d);
	        Calendar c = Calendar.getInstance();
	    	try{
	    	   c.setTime(DateFormat.parse(strDate));
	    	}catch(ParseException e){
	    	   e.printStackTrace();
	    	 }
	    	//Incrementing the date by n month and year
	    	c.add(Calendar.YEAR, intNumber);
	    	String newDate = DateFormat.format(c.getTime());
	    	System.out.println("Date Incremented by One Year: "+newDate);
		}
	}
}
