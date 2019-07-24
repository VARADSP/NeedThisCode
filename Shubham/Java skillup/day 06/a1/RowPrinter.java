/**
 *
 */
package com.jvs.uks.day05.a3;

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
	public void printSearch(String strFilePath){
		for(Map.Entry<Integer, String> entry: map.entrySet()){
			//System.out.println("Key = " + entry.getKey() +", Value = " + entry.getValue());
			int id = entry.getKey();
			//for printing records in map
			ArrayList<GeneralEmployee> empList;
			try {
				empList = objRowReader.empObjList(strFilePath);
				//creating arraylist of General employee
				for(int i = 0; i < empList.size(); i++){
					int j = i+1;
					int thisId = Integer.parseInt(empList.get(i).empCode.trim());
					if(id == thisId){
						//Printing all the employee information to console
						System.out.println(j+")"+"EmployeeID:	 "+empList.get(i).empCode);							//emplList is return from RowReader in the form of arrayList of objects
						System.out.println("  Name: 	"+empList.get(i).firstName+" "+empList.get(i).lastName); 	//using empl .(dot) we can access variables
						System.out.println("  EmployeeType:	 "+empList.get(i).empType);
						int sal = Integer.parseInt(empList.get(i).basicSalary.trim());	//converting string to int salary
						System.out.println("  Salary:	 "+ (sal + (sal *0.125)));	//calculate total salary and print it
						break;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}



