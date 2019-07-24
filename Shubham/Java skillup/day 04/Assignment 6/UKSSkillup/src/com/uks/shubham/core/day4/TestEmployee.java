/**
 *
 */
package com.uks.shubham.core.day4;

/**
 * @author Shubham
 *
 */
public class TestEmployee {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PLEmployee PL1 = new PLEmployee();
		PLEmployee TL1 = new PLEmployee();

		TLEmployee PL2 = new TLEmployee();
		TLEmployee TL2 = new TLEmployee();

		PL1.doWork();
		TL2.doWork();

		TL1.reportToSenior();
		PL2.reportToSenior();
	}

}
