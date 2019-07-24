/**
 *
 */
package com.jvs.uks.day05.a2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author: 	Shubham Bujurge
 * Created Date:13/05/2019 09: 06 AM
 * Assignment:  Day 5
 * Task: File Stream and List in java
 *
 */
public class RowReader {

	public ArrayList<GeneralEmployee> empObjList(String strFilePath) throws IOException {
		ArrayList<GeneralEmployee> list = new ArrayList<GeneralEmployee>();
		BufferedReader reader = new BufferedReader(new FileReader(strFilePath));
		String string=reader.readLine();
		GeneralEmployee objGeneralEmployee = null;	//creating the object of General employee class
		try{
			while(string!=null)
			{
				String strArray[]=string.split(",");
				objGeneralEmployee = new GeneralEmployee(strArray[0],strArray[1],strArray[2],strArray[3],strArray[4]);	//Pass parameter to constructor of General Employee class
				list.add(objGeneralEmployee.getElement());
				string=reader.readLine();
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		reader.close();
		return list;
	}
}
