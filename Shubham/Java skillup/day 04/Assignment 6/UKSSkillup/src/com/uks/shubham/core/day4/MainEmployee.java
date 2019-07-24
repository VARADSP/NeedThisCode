/**
 *
 */
package com.uks.shubham.core.day4;

import java.util.Scanner;

/**
 * @author: 	Shubham Bujurge
 * Created Date:09/05/2019 05:10 PM
 * Assignment:  Day 3
 * Task: 		Employee
 *
 */
public class MainEmployee {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name of the employee");
		String name = sc.nextLine();
		System.out.println("Enter salary of the employee");
		double  salary = sc.nextDouble();
		sc.close();
		if(!name.isEmpty() && salary > 0){
			Emp eObj = new Emp();
			eObj.setName(name);
			System.out.println("Name of the empolyee: "+eObj.getName());
			Emp.SalaryStructure sObj = new Emp.SalaryStructure();
			sObj.setSalary(salary);
			System.out.println("Basic salary: "+sObj.getSalary());
			System.out.println("Total HRA: "+sObj.hra());
			System.out.println("Total Salary: "+ sObj.totalSalary());
		}
	}

}
