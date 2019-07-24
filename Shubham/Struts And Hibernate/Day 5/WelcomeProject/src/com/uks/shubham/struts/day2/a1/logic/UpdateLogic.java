/**
 *
 */
package com.uks.shubham.struts.day2.a1.logic;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.uks.shubham.struts.common.db.logic.DbLogic;
import com.uks.shubham.struts.common.util.Constants;
import com.uks.shubham.struts.day2.a1.bean.UserDataBean;

/**
 * @author Shubham
 *
 */
public class UpdateLogic {
	//creating object of database class
	DbLogic objdb = new DbLogic();
	Connection con=null;
	UserDataBean listbean=new UserDataBean();
	String message;

	// methods perform update user operation
	public String updateuser(UserDataBean listbean) throws SQLException, IOException{
		try{

		con=objdb.connect();
		Statement stmt=con.createStatement();
		System.out.println(listbean.getAddress());
		//setting resultset from the database and update the records
		String query="UPDATE northwind_shubam.userdetails SET salulation='"+listbean.getSalutation()+"',"
				+ "firstname='"+listbean.getFirstName()+"',middleinitial='"+listbean.getMiddleName()
				+"',lastname='"+listbean.getLastName()+"',gender='"+listbean.getGender()
				+"',email='"+listbean.getEmailId()+"',dob='"+listbean.getBirth()
				+"',address='"+listbean.getAddress()+"',userid='"+listbean.getUname()
				+"',password='"+listbean.getPass()+"',areaofinterest='"+listbean.getInterest()
				+"',otherinterest='"+listbean.getOthintrest()+"' WHERE userid='"+listbean.getUname()+"'" ;
		int rs=stmt.executeUpdate(query);
		if(rs > 0){
			message=Constants.updateRecordSucc;
		}
		else{
			message=Constants.updateRecordUnSucc;
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			objdb.disconnect();
		}
		return message;
	}

}
