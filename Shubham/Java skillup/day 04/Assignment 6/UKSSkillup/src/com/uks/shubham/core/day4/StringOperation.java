/**
 *
 */
package com.uks.shubham.core.day4;

/**
 * @author: 	Shubham Bujurge
 * Created Date:08/05/2019 09: 49 AM
 * Assignment:  Day 2
 * Task: 		String Manipulation
 *
 */
class StringOperation {
    //Method for string manipulation
	void doOperationWithRegEx(int intCmd,String[] args){

		if(intCmd == 1){

			int upperCase = 0;
		    int lowerCase = 0;
		    int numberCount = 0;
			int intStr,intChar;
			for(intStr = 1; intStr < args.length; intStr++){
				String strHold = args[intStr];
				char[] ch = strHold.toCharArray();
				for(intChar = 0; intChar < strHold.length(); intChar++){

					if (Character.isUpperCase(ch[intChar]))		{ upperCase++; }
		            else if (Character.isLowerCase(ch[intChar])){ lowerCase++; }
		            else if (Character.isDigit(ch[intChar]))	{ numberCount++;}
				}
			}
			System.out.println("Number of UpperCase Letters: " + upperCase);
			System.out.println("Number of Lowercase Letters: " + lowerCase);
			System.out.println("Number of Digits Letters: " + numberCount);
		}
	}
}
