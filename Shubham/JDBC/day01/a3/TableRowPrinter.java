/**
 *
 */
package com.uks.shubham.day01.a3;

/**
 * @author: 	Shubham Bujurge
 * Created Date:06/06/2019 11: 30 AM
 * Assignment:  Day 1
 * Task: 		Connection from properties file
 *
 */
public class TableRowPrinter {

	public static void main(String[] args) throws Exception{
		//creating an object of PropertyUtil class
		PropertyUtil objPropUtil = new PropertyUtil();
		//PropertyUtil of connect method is calling
		objPropUtil.connect();
		//PropertyUtil of displayRecords method is calling
		objPropUtil.displayRecords();
		//PropertyUtil of disconnect method is calling for closing connection
		objPropUtil.disconnect();
	}
}
