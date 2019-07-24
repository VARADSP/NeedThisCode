/**
 *
 */
package com.uks.shubham.day03.a1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

import com.uks.shubham.day01.a3.PropertyUtil;

/**
 * @author: 	Shubham Bujurge
 * Created Date:10/06/2019 08:49 AM
 * Assignment:  Day 3
 * Task:  	Understanding RowSet
 *
 */
public class DataFetcher {

	String command,dataSourceName;
	Connection con = null;
	PropertyUtil objPropertyUtil = new PropertyUtil();

	void connect(){
		con = objPropertyUtil.connect();
	}

	//For display the data using the Cached method
	CachedRowSet executeInCached() throws SQLException{
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT EmployeeID, FirstName, LastName,Title,date(BirthDate) as DateOfBirth FROM employees");
		RowSetFactory factory = RowSetProvider.newFactory();
		CachedRowSet rowSet = factory.createCachedRowSet();
		rowSet.populate(rs);
		con.close();
		return rowSet;
	}

	//For display the data using the WebRowSet method
	WebRowSet executeInXML() throws SQLException{
		RowSetFactory factory = RowSetProvider.newFactory();
		WebRowSet webRowSet = factory.createWebRowSet();
		webRowSet.setCommand("SELECT EmployeeID, FirstName, LastName,Title,date(BirthDate) as DateOfBirth FROM employees");
		webRowSet.execute(con);
		con.close();
		return webRowSet;
	}

	//For display the data using the ResultSet method
	ResultSet executeInJDBC() throws SQLException{
		Statement stmt = con.createStatement();
		//fire query and store result in resultSet
		ResultSet rs = stmt.executeQuery("SELECT EmployeeID, concat(FirstName,' ', LastName) as FullName,Title,concat(Address ,city ,country) as Address,HomePhone FROM employees");
		//for formatting of the Headers
		System.out.printf("%5s %15s %30s %40s %45s \n", "Employee ID", "Name", "Title", "Address", "HomePhone");
		System.out.println("==============================================================================================================================================================");
		//is executed until no more rows is there
		while(rs.next()){
			//Printing the Result in tabular format
			System.out.format("%-20s %-30s %-30s %-50s %-25s \n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
		}
		con.close();
		return rs;
	}

	//For discconeting the Database
	void disconnect() throws Exception{
		objPropertyUtil.disconnect();
	}
}
