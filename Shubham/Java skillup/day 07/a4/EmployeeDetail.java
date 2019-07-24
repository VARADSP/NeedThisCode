package com.jvs.uks.day07.a4;

import java.io.Serializable;

/**
 * @author: 	Shubham Bujurge
 * Created Date:15/05/2019 03: 21 PM
 * Assignment:  Day 7
 * Task:  serialization and de-serialization
 *
 */
public class EmployeeDetail implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;	//serialVesrionId is created for the checking each time calling the object and thats uniq ID
	public String name;
	public int age;
	public double basicsal;

	//constructor with name age and basicsal parameters
	public EmployeeDetail(String name, int age, double basicsal) {
		this.name = name;
		this.age = age;
		this.basicsal = basicsal;
	}
}
