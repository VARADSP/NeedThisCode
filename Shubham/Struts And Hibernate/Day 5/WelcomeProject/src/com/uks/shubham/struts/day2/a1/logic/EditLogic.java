/**
 *
 */
package com.uks.shubham.struts.day2.a1.logic;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.uks.shubham.struts.common.db.logic.DbLogic;
import com.uks.shubham.struts.day2.a1.bean.UserDataBean;

/**
 * @author Shubham
 *
 */
public class EditLogic {
	//creating object of database class
	DbLogic objdb = new DbLogic();
	Connection con=null;
	UserDataBean listbean=new UserDataBean();

	// methods perform edit user operation
	public UserDataBean editUser(String uname) throws SQLException, IOException{
		try {
			con=objdb.connect();
			Statement stmt=con.createStatement();
			//getting resultset from the database
			ResultSet rs=stmt.executeQuery("SELECT * FROM northwind_shubam.userdetails Where userid = '"+uname+"'");
			System.out.println(uname);
			while(rs.next()){
				//added data into the listbean setter metrhods
				listbean=new UserDataBean();
				listbean.setSalutation(rs.getString("salulation"));
				listbean.setFirstName(rs.getString("firstname"));
				listbean.setMiddleName(rs.getString("middleinitial"));
				listbean.setLastName(rs.getString("lastname"));
				listbean.setGender(rs.getString("gender"));
				listbean.setEmailId(rs.getString("email"));
				listbean.setBirth(rs.getString("dob"));
				listbean.setAddress(rs.getString("address"));
				listbean.setUname(rs.getString("userid"));
				listbean.setPass(rs.getString("password"));
				listbean.setInterest(rs.getString("areaofinterest"));
				listbean.setOthintrest(rs.getString("otherinterest"));
				listbean.setCategory(rs.getString("category"));

				//System.out.println(rs.getString("areaofinterest"));
				if(!rs.getString("areaofinterest").isEmpty() ){
					String[] arrTemp = rs.getString("areaofinterest").split(",");
					listbean.setArrList(arrTemp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			objdb.disconnect();
		}
		return listbean;

	}

}