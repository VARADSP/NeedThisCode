/**
 *
 */
package com.uks.shubham.core.day4;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author: 	Shubham Bujurge
 * Created Date:10/05/2019 08: 52 AM
 * Assignment:  Day 4
 * Task: 		Basic of inheritance
 *
 */
public class EmployeeMain {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String empFirstName = null,empLastName = null,empType = null,empMobile = null;
		long mobileNumber = 0;
		Pattern mobValidator = Pattern.compile("[0-9]{10}");
		Scanner sc = new Scanner(System.in);

		try{
			System.out.println("Enter first name");
			empFirstName = sc.nextLine();
			System.out.println("Enter last name");
			empLastName = sc.nextLine();
			System.out.println("Enter type of employee. for employee = emp and Poject Leader = PL");
			empType = sc.nextLine();
			System.out.println("Enter mobile number");
			empMobile = sc.nextLine();
			mobileNumber = Long.parseLong(empMobile);
		}
		catch(Exception e){ System.out.println(e); }

		finally{ sc.close(); }

		if(!empFirstName.isEmpty() && !empLastName.isEmpty() && empType.equalsIgnoreCase("PL") && mobValidator.matcher(empMobile).matches() ){
			ProjectLeader objProject = new ProjectLeader( empFirstName, empLastName, empType);
			objProject.setNumber(mobileNumber);
			objProject.print();
		}
		else
			System.out.println("Pleas entered proper values");
	}

}