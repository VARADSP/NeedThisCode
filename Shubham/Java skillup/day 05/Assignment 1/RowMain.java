/**
 *
 */
package com.jvs.uks.day05.a1;

/**
 * @author: 	Shubham Bujurge
 * Created Date:13/05/2019 09: 20 AM
 * Assignment:  Day 5
 * Task: File Stream and List in java
 *
 */
public class RowMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{//checking enter proper file location or not
			if(args.length == 1){
				RowPrinter objRowPrinter =new RowPrinter();
				objRowPrinter.readFileLines(args[0]);
			}else
			{
				System.out.println("Please Enter the proper file location");
			}
		}
		catch(Exception e){
			System.out.println("File not found");	//if exception occurred
		}
	}

}
