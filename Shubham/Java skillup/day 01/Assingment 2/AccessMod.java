/**
 *
 */
package com.jvs.uks.day01;

/**
 * @author: 	Shubham Bujurge
 * Created Date:07/05/2019 9: 23 AM
 * Assignment:  Day 1
 * Task: 		Access Modifier Program
 *
 */
public class AccessMod {

	//Assign values to the Data type accordingly
	public int intVar = 1;
	public long longVar = 100l;
	char charecterVar = 's';
	private String stringVar = "usrname";
	boolean booleanVar = true;
	protected float floatVar = 10.0f;
	protected double doubleVar = 1000.0;


	//creating a method for print values
	public void printProperties(){
		System.out.println(intVar);
		System.out.println(longVar);
		System.out.println(charecterVar);
		System.out.println(stringVar);
		System.out.println(booleanVar);
		System.out.println(floatVar);
		System.out.println(doubleVar);
	}
}
