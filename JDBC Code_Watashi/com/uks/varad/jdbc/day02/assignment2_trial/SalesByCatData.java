package com.uks.varad.jdbc.day02.assignment2_trial;

/**
 *
 */


/**
* @author: 	Varad Paralikar
 * Created Date:24/07/2019
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
