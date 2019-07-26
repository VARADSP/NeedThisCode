package com.uks.varad.jdbc.day02.assignment1_trial;

/**
 *
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.uks.varad.jdbc.day01.assignment3.PropertyUtil;

/**
* @author: 	Varad Paralikar
 * Created Date:24/07/2019
 * Assignment:  Day 2
 * Task:  	Displaying records in Per Page Fashion
 *
 */
public class DisplayUI {

	/**
	 * @param args
	 */
	//creating the connection object
	static Connection connection = null;

	DisplayUI(){
		try {
			//creating object of PropertyUtil class
			new PropertyUtil();
			//searching for mysql driver class
			Class.forName(PropertyUtil.databaseDriverClass);
			System.out.println("Database Connecting...");
			System.out.println("......................");
			//connecting to the database
			connection = DriverManager.getConnection(PropertyUtil.databaseUrl,PropertyUtil.databaseUsername,PropertyUtil.databasePassword);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws Exception {
		//calling Day1-a3 class for creating the connection
		PropertyUtil objPropertyUtil= new PropertyUtil();


		//Calling method of displayRowsPerPage
		DisplayUI.displayRowsPerPage();

	}

	public static void displayRowsPerPage() throws Exception{
		//Calling getRowsPerPage fetch Methods
		RowsFetcher objRowsFetcher = new RowsFetcher();
		//Assign Default size
		objRowsFetcher.rowsPerPage=5;
		//Pasing the Connection and Row per pgae
		objRowsFetcher.getRowsPerPage(connection,7);

	}
}
