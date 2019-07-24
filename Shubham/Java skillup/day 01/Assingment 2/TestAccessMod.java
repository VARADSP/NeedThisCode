/**
 *
 */
package com.jvs.uks.day01;

/**
 * @author: 	Shubham Bujurge
 * Created Date:07/05/2019 9: 32 AM
 * Assignment:  Day 1
 * Task: 		Access Modifier Program
 *
 */
class TestAccessMod {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Creating object of AccessMod class and calling method
		AccessMod accMod = new AccessMod();
		accMod.printProperties();

		//trying to access all the variable sin the class
		System.out.println("Printing all the variables:");
		System.out.println(accMod.intVar);
		System.out.println(accMod.longVar);
		System.out.println(accMod.charecterVar);
		//System.out.println(accMod.stringVar);
		System.out.println(accMod.booleanVar);
		System.out.println(accMod.floatVar);
		System.out.println(accMod.doubleVar);
	}

}
