package com.jvs.uks.day04;

import com.jvs.uks.day04.Employee;
/**
* @author: 	Shubham Bujurge
* Created Date:10/05/2019 09: 47 AM
* Assignment:  Day 4
* Task: 		Basic of inheritance
*/
class ProjectLeader extends Employee {
	private long mobileNumber;
	ProjectLeader(String firstName, String lastName, String type) {
		super(firstName, lastName, type);	//calling the parent class constructor
	}

	//seteer for mobile number
	void setNumber(long number) {
		this.mobileNumber = number;
	}

	//print the values
	void print(){
		System.out.println("First name of the Employee: "+empFirstName);
		System.out.println("Last name of the Employee: "+empLastName);
		System.out.println("Type of the Employee: " +empType);
		System.out.println("Mobile number of the Employee: "+mobileNumber);
	}
}
