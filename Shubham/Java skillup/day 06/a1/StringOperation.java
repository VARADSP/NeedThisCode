/**
 *
 */
package com.jvs.uks.day06.a1;

/**
 * @author: 	Shubham Bujurge
 * Created Date:08/05/2019 09: 49 AM
 * Assignment:  Day 2
 * Task: 		String Manipulation
 *
 */
public class StringOperation {
    //Method for string manipulation
	public void doOperationWithRegEx(int intCmd,String[] args){

		if(intCmd == 1){

			int upperCase = 0;
		    int lowerCase = 0;
		    int numberCount = 0;
			int intStr,intChar;
			//intStr = 1
			for(intStr = 0; intStr < args.length; intStr++){
				String strHold = args[intStr];
				char[] ch = strHold.toCharArray(); //converts string to char array
				for(intChar = 0; intChar < strHold.length(); intChar++){	//counter for checking with types

					if (Character.isUpperCase(ch[intChar]))		{ upperCase++; }
		            else if (Character.isLowerCase(ch[intChar])){ lowerCase++; }
		            else if (Character.isDigit(ch[intChar]))	{ numberCount++;}
				}
			}
			System.out.println("Number of UpperCase Letters: " + upperCase);
			System.out.println("Number of Lowercase Letters: " + lowerCase);
			System.out.println("Number of Digits Letters: " + numberCount);
		}
		else{
			System.out.println("You enter 0, No operation should be performed ");
		}
	}
}
