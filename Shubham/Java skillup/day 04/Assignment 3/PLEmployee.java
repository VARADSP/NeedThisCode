/**
 *
 */
package com.jvs.uks.day04;

/**
 * @author: 	Shubham Bujurge
 * Created Date:10/05/2019 10: 30 AM
 * Assignment:  Day 4
 * Task:Abstract class & overriding
 *
 */
public class PLEmployee extends BaseEmployee implements IWork, IReport {	//implements some interface and extends class
	private long mobileNumber;

	//Setter Methods
	void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	void setLasttName(String lastName) {
		this.lastName = lastName;
	}
	void setType(String empType) {
		this.empType = empType;
	}
	void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}
	void setNumber(long number) {
		this.mobileNumber = number;
	}

	//Getter Methods
	String getFirstName(){
		return this.firstName;
	}
	String getLasttName(){
		return this.lastName;
	}
	String getType(){
		return this.empType;
	}
	double getBasicSalary(){
		return this.basicSalary;
	}
	long getNumber(){
		return this.mobileNumber;
	}

	//Some defined method for operation
	public void doWork(){
		System.out.println("This is Do work method");
	}

	public void assingTaskToJunior(){
		System.out.println("This is Assing Task To Junior method");
	}

	public void collectReportFromJunior(){
		System.out.println("This is Collect Report From Junior method");
	}

	public void reportToSenior(){
		System.out.println("This is Report To Senior method");
	}
}
