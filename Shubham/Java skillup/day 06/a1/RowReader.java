/**
 *
 */
package com.jvs.uks.day05.a3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author: 	Shubham Bujurge
 * Created Date:13/05/2019 09: 06 AM
 * Assignment:  Day 5
 * Task: Search in Record
 *
 */
public class RowReader {
	//This return arrayList of Objects and parameter is file location
	public ArrayList<GeneralEmployee> empObjList(String strFilePath) throws IOException {
		ArrayList<GeneralEmployee> list = new ArrayList<GeneralEmployee>();	//initializing the arrayList
		BufferedReader reader = new BufferedReader(new FileReader(strFilePath));	//reading the file
		String string=reader.readLine();
		GeneralEmployee objGeneralEmployee = null;
		while(string!=null)
		{
			String strArray[]=string.split(",");
			objGeneralEmployee = new GeneralEmployee(strArray[0],strArray[1],strArray[2],strArray[3],strArray[4]);	//passing parameter to constructor to General employee and Returns Object list
			list.add(objGeneralEmployee.getElement());	//Adding obj to arrayList
			string=reader.readLine();
		}
		reader.close();
		return list;	//Returning array list
	}
}
