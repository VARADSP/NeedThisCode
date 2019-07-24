/**
 *
 */
package com.uks.shubham.struts.day2.a1.logic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.uks.shubham.struts.common.db_logic.DbLogic;
import com.uks.shubham.struts.day2.a1.bean.LoginBean;

/**
 * @author Shubham
 *
 */
public class LoginLogic {
	/*
	 * This class is using for the Login logic
	 * */
	DbLogic objDbLogic = new DbLogic();
	Connection con = null;
	LoginBean objbean = new LoginBean();

	//This methods validate user is prasent in your system or not
	public String validateUser(LoginBean objbean) throws SQLException {

		//String category = null;
		try {
			con = objDbLogic.connect();
			Statement stmt = con.createStatement();
			//Executing the query
			ResultSet rs = stmt.executeQuery("SELECT * FROM northwind_shubam.userdetails where userid = '"
					+ objbean.getUsername() + "' and password ='" + objbean.getPassword() + "'");
			//checks records available or not
			if (rs.next()) {
				objbean.setCategory(rs.getString(14));
				return objbean.getCategory();
			} else {
				return objbean.getCategory();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//discooneting the connection
			objDbLogic.disconnect();
		}

		//returning the boolean
		return objbean.getCategory();
	}
}
