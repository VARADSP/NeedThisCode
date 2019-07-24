/**
 *
 */
package com.jvs.uks.day05.a4;

import java.io.IOException;
/**
 * @author: 	Shubham Bujurge
 * Created Date:13/05/2019 04: 10 PM
 * Assignment:  Day 5
 * Task: Search in Record
 *
 */

public class ShowList {

	public static void main(String[] args) throws IOException {
		EmployeeSortedList objEmployeeSortedList=new EmployeeSortedList();
		RowPrinter objRowPrinter=new RowPrinter();
		if(args.length==2){
			objEmployeeSortedList.path(args[0],args[1]);
		}
		else{
			objRowPrinter.path(args[0]);
		}

	}

}


