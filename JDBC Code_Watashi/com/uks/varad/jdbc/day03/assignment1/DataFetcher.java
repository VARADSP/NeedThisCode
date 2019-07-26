package com.uks.varad.jdbc.day03.assignment1;

/**
 *
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

import com.uks.varad.jdbc.day01.assignment3.PropertyUtil;

/**
 * @author: 	Varad Paralikar
 * Created Date:2019/07/25
 * Assignment:  Day 3
 * Task:  	Understanding RowSet
 *
 */
public class DataFetcher {

	String command,dataSourceName;
	Connection connection = null;

	/*
	 * method connect for creating the connection to the database.
	 * return type :void
	 */
	public void connect() {
		try {
			// creating object of PropertyUtil class
			new PropertyUtil();
			// searching for mysql driver class
			Class.forName(PropertyUtil.databaseDriverClass);
			System.out.println("Database Connecting...");
			System.out.println("......................");
			// connecting to the database
			connection = DriverManager.getConnection(PropertyUtil.databaseUrl, PropertyUtil.databaseUsername,
					PropertyUtil.databasePassword);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/*
	 * method disconnect for closing the conncetion.
	 * return type : void
	 */
	void disconnect() throws SQLException {
		System.out.println("......................");
		System.out.println("Database DisConnected...");
		// closing the connection
		connection.close();
	}

	//For display the data using the Cached method
	CachedRowSet executeInCached() throws SQLException{
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT EmployeeID, FirstName, LastName,Title,date(BirthDate) as DateOfBirth FROM employees");
		RowSetFactory factory = RowSetProvider.newFactory();
		CachedRowSet rowSet = factory.createCachedRowSet();
		rowSet.populate(resultSet);
		connection.close();
		return rowSet;
	}

	//For display the data using the WebRowSet method
	WebRowSet executeInXML() throws SQLException{
		RowSetFactory factory = RowSetProvider.newFactory();
		WebRowSet webRowSet = factory.createWebRowSet();
		webRowSet.setCommand("SELECT EmployeeID, FirstName, LastName,Title,date(BirthDate) as DateOfBirth FROM employees");
		webRowSet.execute(connection);
		connection.close();
		return webRowSet;
	}

	//For display the data using the ResultSet method
	ResultSet executeInJDBC() throws SQLException{
		Statement statement = connection.createStatement();
		//fire query and store result in resultSet
		ResultSet resultSet = statement.executeQuery("SELECT EmployeeID, concat(FirstName,' ', LastName) as FullName,Title,concat(Address ,city ,country) as Address,HomePhone FROM employees");
		//for formatting of the Headers
		System.out.printf("%5s %15s %30s %40s %45s \n", "Employee ID", "Name", "Title", "Address", "HomePhone");
		System.out.println("==============================================================================================================================================================");
		//is executed until no more rows is there
		while(resultSet.next()){
			//Printing the Result in tabular format
			System.out.format("%-20s %-30s %-30s %-50s %-25s \n",resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5));
		}
		connection.close();
		return resultSet;
	}


}
