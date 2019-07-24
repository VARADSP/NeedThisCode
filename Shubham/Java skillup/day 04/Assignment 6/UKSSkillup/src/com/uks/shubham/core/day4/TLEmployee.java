/**
 *
 */
package com.uks.shubham.core.day4;

/**
 * @author Shubham
 *
 */
public class TLEmployee extends PLEmployee implements IWork, IReport {

	public void doWork(){
		System.out.println("This is Do work method========>of TLEmployee class");
	}

	public void assingTaskToJunior(){
		System.out.println("This is Assing Task To Junior method=====>");
	}

	public void collectReportFromJunior(){
		System.out.println("This is Collect Report From Junior method=====>");
	}

	public void reportToSenior(){
		System.out.println("This is Report To Senior method====>of TLEmployee class");
	}

}
