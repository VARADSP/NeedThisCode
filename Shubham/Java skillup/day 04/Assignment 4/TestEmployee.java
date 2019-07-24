/**
 *
 */
package com.jvs.uks.day04;

/**
 * @author: 	Shubham Bujurge
 * Created Date:10/05/2019 11: 00 AM
 * Assignment:  Day 4
 * Task:		Using interface
 *
 *
 */
public class TestEmployee {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PLEmployee PL1 = new PLEmployee();	//creating objects
		PLEmployee TL1 = new PLEmployee();	//creating objects

		TLEmployee PL2 = new TLEmployee();	//creating objects
		TLEmployee TL2 = new TLEmployee();	//creating objects

		PL1.doWork();	//Calling method
		TL2.doWork();	//Calling method

		TL1.reportToSenior();	//Calling method
		PL2.reportToSenior();	//Calling method
	}

}
