/**
 *
 */
package com.jvs.uks.day03;

/**
 * @author: 	Shubham Bujurge
 * Created Date:09/05/2019 05:20 PM
 * Assignment:  Day 3
 * Task: 		Employee
 *
 */
public class Employee {

	private String name;

	void setName(String newName){
		this.name = newName;
	}

	String getName(){
		return name;
	}

	//Inner Class
	static class SalaryStructure{
		private double basicSal;
		private double hra;

		void setSalary(double salary){
			this.basicSal = salary;
		}

		double getSalary(){
			return basicSal;
		}
		/*
		void setgetHra(long hra){
			this.hra = hra;
		}

		long getgetHra(){
			return hra;
		}
		 */
		double totalSalary(){
			return basicSal+ hra;
		}

		double hra(){
			hra = (double) (basicSal / 100) *12.5 ;
			return hra;
		}
	}
}
