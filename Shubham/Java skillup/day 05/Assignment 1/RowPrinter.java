/**
 *
 */
package com.jvs.uks.day05.a1;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author: 	Shubham Bujurge
 * Created Date:13/05/2019 09: 51 AM
 * Assignment:  Day 5
 * Task: File Stream and List in java
 *
 */
public class RowPrinter {
	RowReader objRowReader = new RowReader();
	//method for printing the lines
	void readFileLines(String strFilePath) throws IOException{
		ArrayList<GeneralEmployee> empList = objRowReader.empObjList(strFilePath);//creating arraylist of General employee
		for(int i = 0; i < empList.size(); i++){
			int j = i+1;
			//Printing all the employee information to console
			System.out.println(j+")"+"EmployeeID:	 "+empList.get(i).empCode);							//emplList is return from RowReader in the form of arrayList of objects
			System.out.println("  Name: 	"+empList.get(i).firstName+" "+empList.get(i).lastName); 	//using empl .(dot) we can access variables
			System.out.println("  EmployeeType:	 "+empList.get(i).empType);
			int sal = Integer.parseInt(empList.get(i).basicSalary.trim());	//converting string to int salary
			System.out.println("  Salary:	 "+ (sal + (sal *0.125)));	//calculate total salary and print it
		}
	}
}
