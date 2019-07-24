package com.uks.shubham.servlet;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 *
 */

/**
 * @author Shubham
 *
 */
public class DatabaseConnection {

	// Intializing the connection
	Connection con = null;

	@SuppressWarnings("finally")
	public Connection connect() {
		try {
			// Getting database url,bb,name and pass from properties file
			FileInputStream fis = new FileInputStream("D:\\JVS_WS\\UserDetails\\src\\settings.properties");
			// Created ResourceBundle with parameter fileInputStream
			ResourceBundle myBundle = new PropertyResourceBundle(fis);
			// Storing the DB info into local variables
			String dbname = myBundle.getString("DBname");
			String url = myBundle.getString("URL");
			String db_user = myBundle.getString("Username");
			String db_pass = myBundle.getString("Password");
			// Intializing the dbname
			Class.forName(dbname);
			// establishmenting the connection
			con = DriverManager.getConnection(url, db_user, db_pass);
			System.out.println("Database Connecting.....");

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			return con;
		}
	}
}
