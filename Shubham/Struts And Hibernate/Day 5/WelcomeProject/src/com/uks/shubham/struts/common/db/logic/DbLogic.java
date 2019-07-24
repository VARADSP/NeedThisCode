/**
 *
 */
package com.uks.shubham.struts.common.db.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.uks.shubham.struts.common.util.Constants;

/**
 * @author Shubham
 *
 * Common Database class and returing the connection object
 *
 */
public class DbLogic {

	Connection con = null;

	@SuppressWarnings("finally")
	public Connection connect(){
		try{
			ResourceBundle myBundle = ResourceBundle.getBundle("com.uks.shubham.struts.common.util.database");
			String URL = myBundle.getString(Constants.DB_URL);
			String Driver = myBundle.getString(Constants.DB_DriverName);
			String db_username = myBundle.getString(Constants.DB_username);
			String db_password = myBundle.getString(Constants.Db_password);

			//finding the class
			Class.forName(Driver);
			//establishmenting the connection
			con = DriverManager.getConnection(URL,db_username,db_password);
			System.out.println(Constants.connectMsg);

		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			return con;
			//Returning connection object
		}
	}

	//Disconnecting the connection of database
	public void disconnect(){
		try {
			System.out.println(Constants.dissConnctMsg);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
