/**
 *
 */
package com.jvs.uks.day05.a4;

/**
 * @author: 	Shubham Bujurge
 * Created Date:10/05/2019 10: 47 AM
 * Assignment:  Day 4
 * Task: Search in Record
 *
 */
public class BaseEmployee {

	public String firstName, lastName, empType;
	public String basicSalary;
	public String  empCode;

	//Parameterized constructor and set all local variables
	BaseEmployee(String strArray,String first,String last,String emp, String basic){
		this.empCode=strArray;
		this.firstName=first;
		this.lastName=last;
		this.empType=emp;
		this.basicSalary=basic;
	}
}
