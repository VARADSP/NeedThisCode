/**
 *
 */
package com.jvs.uks.day05.a2;

import java.io.IOException;
import java.util.Scanner;

/**
  * @author: 	Shubham Bujurge
 * Created Date:13/05/2019 11: 15 AM
 * Assignment:  Day 5
 * Task: File Stream and List in java
 *
 */
public class RowToFileConvert {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		try{
		System.out.println("Enter the path of the file to be read");
		String strFileRead = sc.nextLine();
		System.out.println("Enter the path of the write to be read");
		String strFileWrite = sc.nextLine();

		if(!strFileRead.isEmpty() && !strFileWrite.isEmpty()){
			RowPrinter obj = new RowPrinter();	//Creating obj of rowPrinter class
			obj.readFileLines(strFileRead,strFileWrite);// passing both the location should be pass
			System.out.println("Write data sucessfully");
		}
		else{
			System.out.println("Please Enter the proper values");
		}
		}catch(Exception e)
		{
			System.out.println("Enter a Proper Path of file with extension");
		}
		finally{
			sc.close();
		}
	}

}
