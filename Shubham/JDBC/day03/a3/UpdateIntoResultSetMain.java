/**
 *
 */
package com.uks.shubham.day03.a3;

/**
 * @author		: 	Shubham Bujurge
 * Created Date :	10/06/2019 01:25 PM
 * Assignment	:  	Day 3
 * Task			:  	Updation RowSet
 *
 */
public class UpdateIntoResultSetMain {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		//Cretaing object of UpdateIntoResultSet and calling methods for operation
		UpdateIntoResultSet objUpdateIntoResultSet = new UpdateIntoResultSet();
		objUpdateIntoResultSet.connect();
		objUpdateIntoResultSet.updateInto();
		objUpdateIntoResultSet.disconnect();
	}

}
