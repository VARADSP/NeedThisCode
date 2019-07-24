/**
 *
 */
package com.uks.shubham.core.day4;

/**
 * @author: 	Shubham Bujurge
 * Created Date:10/05/2019 08: 41 AM
 * Assignment:  Day 4
 * Task: 		Basic of inheritance
 *
 */
public class Employee {

	protected String empFirstName;
	protected String empLastName;
	protected String empType;

	Employee(String firstName,String lastName,String type){
		this.empFirstName = firstName;
		this.empLastName = lastName;
		this.empType = type;
	}

}

