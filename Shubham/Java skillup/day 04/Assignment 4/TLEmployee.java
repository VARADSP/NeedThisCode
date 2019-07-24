/**
 *
 */
package com.jvs.uks.day04;

/**
 * @author: 	Shubham Bujurge
 * Created Date:10/05/2019 11: 40 AM
 * Assignment:  Day 4
 * Task:		Using interface
 *
 *
 */


public class TLEmployee extends PLEmployee implements IWork, IReport {

	public void doWork(){	//Override Methods
		System.out.println("This is Do work method========>of TLEmployee class");
	}

	public void assingTaskToJunior(){	//Override Methods
		System.out.println("This is Assing Task To Junior method=====>");
	}

	public void collectReportFromJunior(){	//Override Methods
		System.out.println("This is Collect Report From Junior method=====>");
	}

	public void reportToSenior(){	//Override Methods
		System.out.println("This is Report To Senior method====>of TLEmployee class");
	}

}
