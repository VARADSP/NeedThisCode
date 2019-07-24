/**
 *
 */
package com.jvs.uks.day05.a4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: 	Shubham Bujurge
 * Created Date:13/05/2019 09: 51 AM
 * Assignment:  Day 5
 * Task: Search in Record
 *
 */
public class RowPrinter {
	RowReader objRowReader = new RowReader();
	Boolean status = false;
	public Map<Integer, String> map  = new HashMap<Integer, String>();	//public int[] res = null;
	ArrayList<GeneralEmployee> empList;
	//method for printing the lines
	public void readFileLines(String strFilePath, String searchName) throws IOException{
		empList = objRowReader.empObjList(strFilePath);//creating arraylist of General employee
		//res = new int[empList.size()];
		for(int i = 0; i < empList.size(); i++){
			String strName = empList.get(i).lastName.trim();
			if(strName.equals(searchName)){
				status = true;
				//res[i] = Integer.parseInt(empList.get(i).empCode.trim());	//Store empid thode matches the values
				int key = Integer.parseInt(empList.get(i).empCode.trim());
				map.put(key, empList.get(i).firstName);
			}
		}
		if(status == false)
			System.out.println("Not Fount Match Elements");
	}
	void printSearch(){
		for(Map.Entry<Integer, String> entry: map.entrySet()){
			System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
		}
	}

	// method to print details
		public ArrayList<GeneralEmployee> path(String path) throws IOException{
			ArrayList<GeneralEmployee> empList = objRowReader.empObjList(path);
			empList.sort((o1,o2)->o1.empCode.compareTo(o2.empCode));
			System.out.printf("%10s %30s %20s %5s %5s", "Employee ID", "FirstName", "LastName", "Type", "Salary");
			System.out.println();
			for(int i=0;i<empList.size() - 1;i++){
				double element =Double.parseDouble(empList.get(i).basicSalary.trim());
				 System.out.format("%10s %30s %20s %5s %7s",
						 empList.get(i).empCode,empList.get(i).firstName, empList.get(i).lastName,empList.get(i).empType, (element + (element * 0.125)));
			     System.out.println();
			}
			return null;
			}

}



