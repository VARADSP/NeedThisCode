/**
 *
 */
package com.uks.shubham.struts.day2.a1.logic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import com.uks.shubham.struts.common.db.logic.DbLogic;
import com.uks.shubham.struts.day2.a1.bean.LoginBean;

/**
 * @author Shubham
 *
 */
public class LoginLogic{

	DbLogic objDbLogic = new DbLogic();
	Connection con = null;
	LoginBean objbean = new LoginBean();

	//This methods validate user is prasent in your system or not
	public boolean validateUser(String uname,String pass, Map<String, Object> sessionMap) throws SQLException {

		boolean valid = false;
		try {
			con = objDbLogic.connect();
			Statement stmt = con.createStatement();
			//Executing the query
			ResultSet rs = stmt.executeQuery("SELECT * FROM northwind_shubam.userdetails where userid = '"
					+ uname + "' and password ='" + pass + "'");

			//checks records available or not
			if (rs.next()) {
				String category = rs.getString(14);
				sessionMap.put("category",category);
				//System.out.println(sessionMap.get("username"));
				valid = true;

			} else {
				valid = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//discooneting the connection
			objDbLogic.disconnect();
		}

		//returning the boolean
		return valid;
	}

}
