package com.uks.shubham.struts.day2.a1.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.uks.shubham.struts.common.db_logic.DbLogic;
import com.uks.shubham.struts.day2.a1.bean.LoginBean;
import com.uks.shubham.struts.day2.a1.bean.UserDataBean;

public class FetchUserDataAction {

	DbLogic objDbLogic = new DbLogic();
	Connection con = null;
	UserDataBean objuser = new UserDataBean();
	LoginBean objbean = new LoginBean();

	public UserDataBean fetchData(UserDataBean objuser_old, LoginBean objbean) throws SQLException, IOException {
	//	UserDataBean objuser=null;
		con = objDbLogic.connect();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM northwind_shubam.userdetails where userid = '"
				+ objbean.getUsername() + "' and password ='" + objbean.getPassword() + "'");

		while (rs.next()) {
		//objuser = new UserDataBean();
			//String salutation = rs.getString(2).trim();
			objuser.setSalutation(rs.getString(2));
			objuser.setFname(rs.getString(2));
			objuser.setMiddle(rs.getString(3));
			objuser.setLname(rs.getString(4));
			objuser.setSex(rs.getString(5));
			objuser.setEmail(rs.getString(6));
			objuser.setBirth(rs.getString(7));
			objuser.setAddress(rs.getString(8));
			objuser.setUsername(rs.getString(9));
			objuser.setPassword(rs.getString(10));
			objuser.setInterest(rs.getString(11));
			objuser.setOthinterest(rs.getString(12));
		}
		return objuser;
	}
}
