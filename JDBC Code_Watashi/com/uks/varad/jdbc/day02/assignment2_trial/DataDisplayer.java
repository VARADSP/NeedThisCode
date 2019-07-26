/**
 *
 */
package com.uks.varad.jdbc.day02.assignment2_trial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.uks.varad.jdbc.day01.assignment3.PropertyUtil;



/**
 * @author: 	Varad Paralikar
 * Created Date:24/07/2019
 * Assignment:  Day 2
 * Task:  	Getting records from Stored Procedure
 *
 */
public class DataDisplayer {

	static Connection connection;

	DataDisplayer(){
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
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) {


try{


		DataDisplayer.displayRowsPerPage();
		connection.close();
}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	//This is caller function
	public static void displayRowsPerPage(){
		//Calling fetchRecords method with paramteres
		try{


		SalesByCategoryRunner objSaleByCatRunner = new SalesByCategoryRunner(connection, 7);
		objSaleByCatRunner.fetchRecords("Seafood", "1996");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
