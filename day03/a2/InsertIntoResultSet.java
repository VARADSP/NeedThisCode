/**
 *
 */
package com.uks.shubham.day03.a2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.uks.shubham.day01.a3.PropertyUtil;

/**
 * @author   	: 	Shubham Bujurge
 * Created Date	:	10/06/2019 10:40 AM
 * Assignment	: 	 Day 3
 * Task			:  	Insertion RowSet
 *
 */
public class InsertIntoResultSet {
	Connection con;
	PropertyUtil objPropertyUtil = new PropertyUtil();

	//For connecting to the DB
	void connect(){
		con = objPropertyUtil.connect();
	}

	//For insertion of the Row
	void inserInto(){
		try{
			//Firing query to DB
			String query = "select * FROM employees";
			PreparedStatement  prepStmt = con.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = prepStmt.executeQuery();
			System.out.println("Before Adding new record");
			showRecords(rs);

			//Inserting Operation start
			System.out.println("Inserting new Records");
			rs.moveToInsertRow();
			rs.updateInt("EmployeeID",104);
			rs.updateString("FirstName", "Bharat");
			rs.updateString("LastName", "Awachar");
			rs.updateString("Title", "Tester");
			rs.updateDate("BirthDate", Date.valueOf("1994-08-04"));
			rs.updateString("Notes", "");
			rs.insertRow();
			System.out.println("New Records added");
			System.out.println("After Adding new record");
			//Display the records
			showRecords(rs);
			rs.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	//For disconnecting to the DB
	void disconnect() throws Exception{
		objPropertyUtil.disconnect();
	}

	//For Display the data
	void showRecords(ResultSet rs){
		System.out.printf("%5s %15s %30s %40s %45s \n", "Employee ID", "Name", "Title", "Address", "HomePhone");
		System.out.println("==============================================================================================================================================================");
		//is executed until no more rows is there
		try {
			while(rs.next()){
				//Printing the Result in tabular format
				System.out.format("%-20s %-30s %-30s %-50s %-25s \n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("==============================================================================================================================================================");
	}
}
