/**
 *
 */
package com.jvs.uks.day02;

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
		if(args.length > 0){
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
		else{
			System.out.println("Pleas Pass the command line arguments");
		}
	}

}
