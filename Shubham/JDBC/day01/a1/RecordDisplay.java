/**
 *
 */
package com.uks.shubham.day01.a1;
import java.sql.*;
/**
 * @author: 	Shubham Bujurge
 * Created Date:06/06/2019 08: 37 AM
 * Assignment:  Day 1
 * Task: 		JDBC
 *
 */
public class RecordDisplay {

	/**
	 * @param args
	 */

	//initializing the object of connection
	Connection con;

	//For creating the connection
	void connection(String username, String password){
		try {
			//searching for mysql driver class
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Database Connecting...");
			System.out.println("......................");
			//connecting to the database
			con = DriverManager.getConnection("jdbc:mysql://172.16.1.15:3306/northwind_shubam",username,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//For Display the details of the employee class
	void displayRecords(String query) throws SQLException{
		try {
			Statement stmt = con.createStatement();
			//fire query and store result in resultSet
			ResultSet rs = stmt.executeQuery(query);
			//for formatting of the Headers
			System.out.printf("%5s %15s %30s %40s %45s \n", "Employee ID", "Name", "Title", "Address", "HomePhone");
			System.out.println("==============================================================================================================================================================");
			//is executed until no more rows is there
			while(rs.next()){
				//Printing the Result in tabular format
				System.out.format("%-20s %-30s %-30s %-50s %-25s \n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
			System.out.println("==============================================================================================================================================================");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//For closing the conncetion
	void disconnect() throws SQLException{
		System.out.println("......................");
		System.out.println("Database DisConnected...");
		//closing the connection
		con.close();
	}

}
