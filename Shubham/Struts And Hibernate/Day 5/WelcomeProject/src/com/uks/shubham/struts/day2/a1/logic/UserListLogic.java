package com.uks.shubham.struts.day2.a1.logic;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.uks.shubham.struts.common.db.logic.DbLogic;
import com.uks.shubham.struts.day2.a1.bean.UserDataBean;

/**
 * Logic for fetching user list from database
 *
 * @author shubham
 *
 */
public class UserListLogic {
	// creating object of database class
	DbLogic objDb = new DbLogic();
	Connection con = null;

	// Initializing the arrayList
	ArrayList<UserDataBean> list = new ArrayList<UserDataBean>();

	// according to selection of the data select query genearete and getting the
	// select result
	public ArrayList<UserDataBean> getUserList(String uname, String category, String fname, String address,
			String gender, String email) throws SQLException, IOException {

		try {
			con = objDb.connect();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM northwind_shubam.userdetails";

			if (uname == null || category == null || fname == null || address == null || gender == null
					|| email == null) {
				System.out.println(query);

				return list;
			} else {
				// if every thing is empty
				if (!uname.equals("") || !category.equals("---") || !fname.equals("") || !address.equals("")
						|| !gender.equals("---") || !email.equals("")) {
					query = query + " WHERE salulation Like '%%'  ";
				}
				// if username is not null
				if (!uname.equals("")) {
					query = query + " AND userid = '" + uname + "'";
				}
				// if category is not null
				if (!category.equals("---")) {
					query = query + " AND category = '" + category + "'";
				}
				// if firstnmae is not null
				if (!fname.equals("")) {
					query = query + " AND firstname = '" + category + "'";
				}
				// if address is not null
				if (!address.equals("")) {
					query = query + " AND address = '" + address + "'";
				}
				// if gender is not null
				if (!gender.equals("---")) {
					query = query + " AND gender = '" + gender + "'";
				}
				// if email is not null
				if (!email.equals("")) {
					query = query + " AND email = '" + email + "'";
				}

				// System.out.println(query);
				ResultSet rs = stmt.executeQuery(query);

				while (rs.next()) {
					UserDataBean listbean = new UserDataBean();

					listbean.setUname(rs.getString("userid"));
					listbean.setFirstName(rs.getString("firstname"));
					// listbean.setSalutation(rs.getString("salulation"));
					listbean.setCategory(rs.getString("category"));
					listbean.setGender(rs.getString("gender"));
					listbean.setAddress(rs.getString("address"));
					listbean.setEmailId(rs.getString("email"));

					list.add(listbean);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			objDb.disconnect();
		}
		return list;
	}
}
