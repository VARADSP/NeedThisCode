/**
 *
 */
package com.uks.shubham.core.day4;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author: 	Shubham Bujurge
 * Created Date:10/05/2019 10: 47 AM
 * Assignment:  Day 4
 * Task: Abstract class & overriding
 *
 */
public class StartBaseEmployee {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String empFirstName = null, empLastName = null, empType = null, empMobile = null;
		double basicSalary = 0;
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
			System.out.println("Enter Salary of Employee");
			basicSalary = sc.nextDouble();
		}
		catch(Exception e){ System.out.println(e); }

		finally{ sc.close(); }
		System.out.println("==============================================");
		if(!empFirstName.isEmpty() && !empLastName.isEmpty() && empType.equalsIgnoreCase("PL") && mobValidator.matcher(empMobile).matches() ){
			PLEmployee obj = new PLEmployee();
			obj.setBasicSalary(basicSalary);
			obj.setFirstName(empFirstName);
			obj.setLasttName(empLastName);
			obj.setNumber(mobileNumber);
			obj.setType(empType);

			System.out.println(obj.getFirstName());
			System.out.println(obj.getLasttName());
			System.out.println(obj.getType());
			System.out.println(obj.getNumber());
			System.out.println(obj.getBasicSalary());

			obj.doWork();
			obj.assingTaskToJunior();
			obj.collectReportFromJunior();
			obj.reportToSenior();
		}
		else
			System.out.println("Pleas entered proper values");

	}

}
