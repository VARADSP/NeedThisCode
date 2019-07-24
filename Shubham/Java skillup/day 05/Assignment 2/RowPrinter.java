/**
 *
 */
package com.jvs.uks.day05.a2;

import java.io.BufferedWriter;
import java.io.FileWriter;
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
	void readFileLines(String strFileRead, String strFileWrite) throws IOException{
		ArrayList<GeneralEmployee> empList = objRowReader.empObjList(strFileRead);//which file should be read
		for(int i = 0; i < empList.size(); i++){
			int j = i+1;

			//Writing into the file
			BufferedWriter writer = new BufferedWriter(new FileWriter(strFileWrite, true));//file opened in appebd mode
			writer.write(j+")"+"EmployeeID:	 "+empList.get(i).empCode);writer.newLine();
			writer.write("  Name: 	"+empList.get(i).firstName+" "+empList.get(i).lastName);writer.newLine();
			writer.write("  EmployeeType:	 "+empList.get(i).empType);writer.newLine();
			int sal = Integer.parseInt(empList.get(i).basicSalary.trim());
			writer.write("  Salary:	 "+ (sal + (sal *0.125)));writer.newLine();
			writer.close();	//close the writer class
		}
	}
}
