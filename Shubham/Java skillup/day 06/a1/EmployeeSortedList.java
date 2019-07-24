/**
 *
 */
package com.jvs.uks.day05.a4;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author: 	Shubham Bujurge
 * Created Date:13/05/2019 04: 10 PM
 * Assignment:  Day 5
 * Task: Search in Record
 *
 */
public class EmployeeSortedList {
	//printing the table according to column name
	public ArrayList<GeneralEmployee> path(String path,String colname) throws IOException{
		RowReader objRowReader =new RowReader();
		ArrayList<GeneralEmployee> empList = objRowReader.empObjList(path);
		empList.sort((o1,o2)->o1.getProperty(colname).compareTo(o2.getProperty(colname)));
		System.out.printf("%10s %30s %20s %5s %5s", "Employee ID", "FirstName", "LastName", "Type", "Salary");
		System.out.println();
		for(int i=0;i<empList.size()-1;i++){
			double element =Double.parseDouble(empList.get(i).basicSalary.trim());
			System.out.format("%10s %30s %20s %5s %5f",	 empList.get(i).empCode,empList.get(i).firstName, empList.get(i).lastName,empList.get(i).empType, (element + (element * 0.125)));
	        System.out.println();
		}
		return null;
	}
}
