/**
 *
 */
package com.jvs.uks.day05.a4;

import java.util.Scanner;

/**
 * @author: 	Shubham Bujurge
 * Created Date:13/05/2019 02: 09 PM
 * Assignment:  Day 5
 * Task: Search in Record
 *
 */
public class EmployeeSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		try{//checking enter proper input or not
			System.out.println("Enter last that will search");
			String strName = sc.nextLine();
			RowPrinter objPrinter = new RowPrinter();
			objPrinter.readFileLines("D:\\JVS_WS\\JVSProject\\src\\com\\jvs\\uks\\day05\\a3\\testout.txt",strName);
			objPrinter.printSearch();
		}
		catch(Exception e){
			System.out.println("File not found");	//if exception occurred
		}
		finally{
			sc.close();
		}

	}

}
