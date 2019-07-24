/**
 *	I/P: com.jvs.uks.day06.a4.message_en
 */
package com.jvs.uks.day06.a4;

import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * @author: 	Shubham Bujurge
 * Created Date:10/05/2019 04: 30 PM
 * Assignment:  Day 6
 * Task:  Local Resource Bundle
 *
 */
public class CompanyInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Enter the input:");
		Scanner scan=new Scanner(System.in);
		String con=scan.nextLine();
		ResourceBundle bundle = ResourceBundle.getBundle(con);
		System.out.println("Name: "+bundle.getString("Name"));
		System.out.println("Head Office : "+bundle.getString("HeadOff"));
		System.out.println("Branch Office: "+bundle.getString("Branchoff"));
		scan.close();
	}

}
