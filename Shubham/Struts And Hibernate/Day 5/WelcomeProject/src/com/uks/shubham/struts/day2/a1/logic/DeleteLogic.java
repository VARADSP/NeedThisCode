/**
 *
 */
package com.uks.shubham.struts.day2.a1.logic;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.uks.shubham.struts.common.db.logic.DbLogic;

/**
 * @author Shubham
 *
 */
public class DeleteLogic {

	//creating object of database class
	DbLogic objdb = new DbLogic();
	Connection con=null;

	//methods perform delete operation
	public void deleteUser(String[] uname) throws SQLException, IOException{
		try {
			con=objdb.connect();
			Statement stmt=con.createStatement();
			for(int i=0;i<uname.length;i++){
				//deleting user from database
				@SuppressWarnings("unused")
				boolean rs=stmt.execute("DELETE FROM northwind_shubam.userdetails WHERE userid = '"+uname[i] +"'");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			objdb.disconnect();
		}
	}
}
