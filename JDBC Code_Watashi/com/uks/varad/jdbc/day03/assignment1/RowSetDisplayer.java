package com.uks.varad.jdbc.day03.assignment1;

/**
 *
 */


import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.WebRowSet;

/**
 * @author: 	Varad Paralikar
 * Created Date:2019/07/25
 * Assignment:  Day 3
 * Task:  	Understanding RowSet
 *
 */
public class RowSetDisplayer {

	/**
	 * @param args
	 */

	//Cretaing object of DataFetcher class
	DataFetcher objDataFetcher = new DataFetcher();

	public static void main(String[] args) {
		try{
			//Getting the input from user
			System.out.println("Enter the input 1 for Cached or 2 for XML");
			Scanner scanner = new Scanner(System.in);
			int input = scanner.nextInt();
			//Creating object and calling the DisplayEmpData method
			RowSetDisplayer objRowSetDisplayer = new RowSetDisplayer();
			objRowSetDisplayer.DisplayEmpData(input);
			scanner.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void DisplayEmpData(int num) throws SQLException{
		//Establishing the connection
		objDataFetcher.connect();
		//user enters 1 then Cached function is called
		if(num == 1){
			CachedRowSet rowset = objDataFetcher.executeInCached();
			displayCached(rowset);
		}
		//user enters 1 then Cached function is called
		else if(num ==2){
			WebRowSet rowset = objDataFetcher.executeInXML();
			displayXML(rowset);
		}
		//Enter other than 0 or 1
		else{
			System.out.println("Entered wroung input");
		}
	}

	public void displayCached(CachedRowSet rowset) throws SQLException{
		//Default header is printing
		System.out.printf("%10s %20s %20s %30s %20s \n", "Employee ID","Last Name","First Name","Title","Birth Date");
		System.out.println("============================================================================================================");

		while(rowset.next()){
			System.out.printf("%10s %20s %20s %30s %20s \n", rowset.getString(1),rowset.getString(2),rowset.getString(3),rowset.getString(4),rowset.getString(5));
		}
	}

	public void displayXML(WebRowSet rowset) throws SQLException{
		//Default header is printing
		System.out.printf("%10s %20s %20s %30s %20s \n", "Employee ID","Last Name","First Name","Title","Birth Date");
		System.out.println("============================================================================================================");
		while(rowset.next()){
			System.out.printf("%10s %20s %20s %30s %20s \n", rowset.getString(1),rowset.getString(2),rowset.getString(3),rowset.getString(4),rowset.getString(5));
		}
	}
}
