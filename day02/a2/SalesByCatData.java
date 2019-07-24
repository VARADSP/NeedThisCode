/**
 *
 */
package com.uks.shubham.day02.a2;

/**
* @author: 	Shubham Bujurge
 * Created Date:07/06/2019 02: 10 PM
 * Assignment:  Day 2
 * Task:  	Getting records from Stored Procedure
 *
 */
public class SalesByCatData {

	String productName;
	double totalPurches;

	//Contsructor with name and total purchess parameter
	SalesByCatData(String productName, double totalPurches){
		this.productName = productName;
		this.totalPurches = totalPurches;
	}
}
