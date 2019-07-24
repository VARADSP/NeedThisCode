/**
 *
 */
package com.uks.shubham.day02.a2;

import java.sql.Connection;

import com.uks.shubham.day01.a3.PropertyUtil;

/**
 * @author: 	Shubham Bujurge
 * Created Date:07/06/2019 2: 30 PM
 * Assignment:  Day 2
 * Task:  	Getting records from Stored Procedure
 *
 */
public class DataDisplayer {

	static Connection con;
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		//establishing the connection
		PropertyUtil objpropUtil = new PropertyUtil();
		con = objpropUtil.connect();

		DataDisplayer.displayRowsPerPage();
		objpropUtil.disconnect();
	}

	//This is caller function
	public static void displayRowsPerPage() throws Exception{
		//Calling fetchRecords method with paramteres
		SalesByCategoryRunner objSaleByCatRunner = new SalesByCategoryRunner(con, 7);
		objSaleByCatRunner.fetchRecords("Seafood", "1996");
	}

}
