/**
 *
 */
package com.uks.shubham.struts.common.util;

/**
 * @author Shubham
 *
 */
public class Constants {

	//Static final String variables
	public static final String DB_DriverName = "DBname";
	public static final String DB_URL="URL";
	public static final String DB_username  = "Username" ;
	public static final String Db_password = "Password";


	//Connection message
	public static final String connectMsg = "Database Connecting.....";
	public static final String dissConnctMsg = "Database Disonnecting.....";

	public static final String stratInceptor = "Start Interceptor";
	public static final String endInceptor = "End Interceptor";



	//WelcomeAction
	public static final String incorrectUnamePass = "Username and password is incorrect";

	//DeleteAction
	public static final String deleteUser = "Deleting the user ";
	public static final String deleteSuccess = "Record is deleted Successfully";


	//UpdateAction
	public static final String updateRecordSucc = "Record Updated Successfully";
	public static final String updateRecordUnSucc = "Record not updated Successfully";


	//Register Logic
	public static final String recordInserted = "<br>Record has been inserted";
	public static final String recordNotInserted ="We are anable to register user, try again";
	public static final String recordError = "We are anable to register user verify data or try again later";

	public void getPropertyValue() {

	}
}
