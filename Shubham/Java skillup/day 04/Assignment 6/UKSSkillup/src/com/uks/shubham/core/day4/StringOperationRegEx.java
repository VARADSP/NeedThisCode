/**
 *
 */
package com.uks.shubham.core.day4;

/**
 * @author: 	Shubham Bujurge
 * Created Date:08/05/2019 09: 49 AM
 * Assignment:  Day 2
 * Task: 		String Manipulation & Regular expression
 *
 */
public class StringOperationRegEx {
    //Method for string manuplation
	void doOperationWithRegEx(int intCmd,String[] args){

		String strInput = args[1];
		String strReverse = "";

		//for reverse string
		if(intCmd ==1){
			// convert String to character array
	        // by using toCharArray
	        char[] ch = strInput.toCharArray();
	        for (int i = ch.length-1; i>=0; i--)
	        	strReverse += ch[i];

	        System.out.println(strReverse);
	    }
		//for counting the upper, lower and digits
		else if(intCmd == 2){

			int upperCase = 0;
		    int lowerCase = 0;
		    int numberCount = 0;
			String digPat="[0-9]";
			String lowPat="[a-z]";
			String uppPat="[A-Z]";
			int intStr,intChar;

			for(intStr = 1; intStr < args.length; intStr++){
				String strHold = args[intStr];
				char[] ch = strHold.toCharArray();

				for(intChar = 0; intChar < strHold.length(); intChar++){
					String charc = Character.toString(ch[intChar]);
					if(charc.matches(digPat)){
						numberCount++;
					}
					else if(charc.matches(lowPat)){
						lowerCase++;
					}
					else if(charc.matches(uppPat)){
						upperCase++;
					}
				}
			}
			System.out.println("Number of UpperCase Letters: " + upperCase);
			System.out.println("Number of Lowercase Letters: " + lowerCase);
			System.out.println("Number of Digits Letters: " + numberCount);
		}
	}
}
