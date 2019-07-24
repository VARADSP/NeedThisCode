package com.uks.shubham.struts.day2.a1.logic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.uks.shubham.struts.common.db.logic.DbLogic;
import com.uks.shubham.struts.day2.a1.bean.UserDataBean;

public class UserLogic {
	// Initilizing the objects
	DbLogic objDbLogic = new DbLogic();
	Connection con = null;
	UserDataBean objuser = new UserDataBean();

	public UserDataBean fetchUser(String userid) throws SQLException {

		try {
			// UserDataBean objuser=null;
			con = objDbLogic.connect();
			Statement stmt = con.createStatement();
			// Executing the query
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM northwind_shubam.userdetails where userid = '" + userid + "'");
			// cheking records are available or not
			while (rs.next()) {
				// Setting the value through the setter method

				objuser.setSalutation(rs.getString("salulation"));
				objuser.setFirstName(rs.getString("firstname"));
				objuser.setMiddleName(rs.getString("middleinitial"));
				objuser.setLastName(rs.getString("lastname"));
				objuser.setGender(rs.getString("gender"));
				objuser.setEmailId(rs.getString("email"));
				objuser.setBirth(rs.getString("dob"));
				objuser.setAddress(rs.getString("address"));
				objuser.setUname(rs.getString("userid"));
				objuser.setPass(rs.getString("password"));
				objuser.setInterest(rs.getString("areaofinterest"));
				objuser.setOthintrest(rs.getString("otherinterest"));
				objuser.setCategory(rs.getString("category"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			objDbLogic.disconnect();
		}
		// retuns the object of UserDataBean class
		return objuser;
	}

	public ArrayList<UserDataBean> fetchAllUsers() throws SQLException {
		ArrayList<UserDataBean> list = new ArrayList<UserDataBean>();

		try {
			Statement stmt = con.createStatement();
			// Executin gthe query
			ResultSet rs = stmt.executeQuery("SELECT * FROM northwind_shubam.userdetails");

			// cheking records are available or not
			while (rs.next()) {
				// Creating object here for storing multiple objects and returns
				// it
				UserDataBean objuser = new UserDataBean();
				// Setting the value through the setter method
				objuser.setAddress(rs.getString("address"));
				objuser.setEmailId(rs.getString("email"));
				objuser.setFirstName(rs.getString("firstname"));
				objuser.setGender(rs.getString("gender"));
				objuser.setLastName(rs.getString("lastname"));
				objuser.setMiddleName(rs.getString("middleinitial"));

				// Adding data into the arraylist
				list.add(objuser);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		// Returning the arraylist of objects
		return list;
	}
}
