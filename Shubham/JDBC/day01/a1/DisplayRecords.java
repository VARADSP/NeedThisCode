/**
 *
 */
package com.uks.shubham.day01.a1;

/**
 * @author: 	Shubham Bujurge
 * Created Date:06/06/2019 08: 37 AM
 * Assignment:  Day 1
 * Task: 		JDBC
 *
 */
public class DisplayRecords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			//creating an object and passing usernmae and password
			RecordDisplay objRecordDisplay = new RecordDisplay();
			objRecordDisplay.connection("shubam","shubam@123");
			//passing query to the method
			objRecordDisplay.displayRecords("SELECT EmployeeID, concat(FirstName,' ', LastName) as FullName,Title,concat(Address ,city ,country) as Address,HomePhone FROM employees");
			//for closing the connection
			objRecordDisplay.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
