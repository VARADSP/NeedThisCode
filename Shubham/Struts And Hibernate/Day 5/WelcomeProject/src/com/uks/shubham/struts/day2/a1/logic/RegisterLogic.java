package com.uks.shubham.struts.day2.a1.logic;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;
import com.uks.shubham.struts.common.db.logic.DbLogic;
import com.uks.shubham.struts.common.util.Constants;
import com.uks.shubham.struts.day2.a1.bean.LoginBean;
import com.uks.shubham.struts.day2.a1.bean.UserDataBean;

/**
 * Logic for registering new user in database
 *
 * @author shubham
 *
 */
public class RegisterLogic extends ActionSupport {

	private static final long serialVersionUID = 1L;
	//creating object of database class
	DbLogic objDbLogic = new DbLogic();
	Connection con = null;
	LoginBean objbean = new LoginBean();
	UserDataBean listbean;

	//this method added new user into the database
	public void registeruser(UserDataBean listbean) throws SQLException, IOException {
		try {
			con = objDbLogic.connect();
			System.out.println(listbean.getAddress());
			//getting resultset from the database
			String query = "insert into northwind_shubam.userdetails(salulation,firstname,middleinitial,lastname,gender,email,dob,address,userid,password,areaofinterest,otherinterest,category)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);

			//added data into the listbean getter and setter metrhods
			pst.setString(1, listbean.getSalutation());
			pst.setString(2, listbean.getFirstName());
			pst.setString(3, listbean.getMiddleName());
			pst.setString(4, listbean.getFirstName());
			pst.setString(5, listbean.getGender());
			pst.setString(6, listbean.getEmailId());
			pst.setString(7, listbean.getBirth());
			pst.setString(8, listbean.getAddress());
			pst.setString(9, listbean.getUname());
			pst.setString(10, listbean.getPass());
			pst.setString(11, listbean.getInterest());
			pst.setString(12, listbean.getOthintrest());
			pst.setString(13, listbean.getCategory());
			int i = pst.executeUpdate();
			if (i != 0) {
				System.out.println(Constants.recordInserted);
			} else {
				addActionError(Constants.recordError);
				System.out.println(Constants.recordNotInserted);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
