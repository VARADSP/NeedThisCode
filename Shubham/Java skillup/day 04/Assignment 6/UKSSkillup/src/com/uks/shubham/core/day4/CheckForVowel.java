/**
 *
 */
package com.uks.shubham.core.day4;

/**
 * @author: 	Shubham Bujurge
 * Created Date:08/05/2019 01: 21 PM
 * Assignment:  Day 2
 * Task: 		Arrays in Java
 *
 */
public class CheckForVowel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean status;
		char[] ch = args[0].toCharArray();	//Getting cmd values in char array

		//Checking the entered char then execute
		if(ch.length <= 1){
			VowelConstant vcObj= new VowelConstant();
			status = vcObj.checkChar(ch[0]);	//passing single char to the method for checking

			if(status == true)	// checks char is vowel or not
				System.out.println("This is the Vowel");
			else
				System.out.println("This is the Constant");
		}
		//Otherwise execute this
		else {
			System.out.println("You Entered string, Please Enter the charecter");
		}
	}

}
