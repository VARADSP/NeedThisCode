/**
 *
 */
package com.jvs.uks.day05.a1;

/**
 * @author: 	Shubham Bujurge
 * Created Date:13/05/2019 09: 50 AM
 * Assignment:  Day 5
 * Task: File Stream and List in java
 *
 */
public class GeneralEmployee extends BaseEmployee {

	//GeneralEmployee parameterized constructor
	GeneralEmployee(String strArray, String first, String last, String emp, String basic) {
		super(strArray, first, last, emp, basic);
	}

	//Getting GeneralEmployee elements
	public GeneralEmployee getElement(){
		return(this);
	}
}
