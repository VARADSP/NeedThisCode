/**
 *
 */
package com.uks.shubham.day03.a4;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author		: 	Shubham Bujurge
 * Created Date :	13/06/2019 11:30 AM
 * Assignment	:  	Day 3
 * Task			:  	MetaData RowSet
 *
 */
public class MetaData {
	Connection con=null;
	public Connection connect() throws Exception {
		Properties prop = new Properties();

		try {

			FileInputStream reader = new FileInputStream(
					"D:\\JVS_WS\\JDBC\\src\\com\\uks\\shubham\\day01\\a3\\settings.properties");

			// load a properties file
			prop.load(reader);
			String user = prop.getProperty("Username");
			String pass = prop.getProperty("Password");
			String url = prop.getProperty("URL");
			String driverClass = prop.getProperty("DBname");
			try {
				Class.forName(driverClass);
				con = DriverManager.getConnection(url, user, pass);
				System.out.println("Database Connected...");
				System.out.println("......................");

			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return con;
	}

	/**
	 * Method to perform operations with resultset metadata
	 */
	public void dataMetadate() {
		try {
			Statement stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(
					"select * from employees");
			ResultSetMetaData rsMetaData = rs.getMetaData();
			System.out.println("Total No of columns in this table: " + rsMetaData.getColumnCount());
			System.out.println("First coulumn name of in this table: " + rsMetaData.getColumnName(1));
			System.out.println("First coulumn type of in this table: " + rsMetaData.getColumnTypeName(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Close connection
	public void closeCon() throws SQLException {
		con.close();
		System.out.println("......................");
		System.out.println("Database Disconnected...");
	}
}
