/**
 *
 */
package com.uks.shubham.day03.a2;

/**
 * @author   	: 	Shubham Bujurge
 * Created Date	:	10/06/2019 10:50 AM
 * Assignment	: 	 Day 3
 * Task			:  	Insertion RowSet
 *
 */
public class InsertIntoResultSetMain {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		//Creating object and calling method for operation
		InsertIntoResultSet objInsertIntoResultSet =new InsertIntoResultSet();
		objInsertIntoResultSet.connect();
		objInsertIntoResultSet.inserInto();
		objInsertIntoResultSet.disconnect();
	}

}
