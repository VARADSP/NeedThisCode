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
public class VowelConstant {

	//This checks entered char is vowel or constant
	 boolean checkChar(char ch){
		 //using switch case we check
		 switch(ch){
		 	case 'a':
		 		return true;
		 	case 'e':
		 		return true;
		 	case 'i':
		 		return true;
		 	case 'o':
		 		return true;
		 	case 'u':
		 		return true;
		 	default:
		 		return false; //the default result is false
		 }
	}
}
