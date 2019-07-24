/**
 *
 */
package com.jvs.uks.day07.a3;

import java.util.Arrays;
import java.util.Random;

/**
 * @author: 	Shubham Bujurge
 * Created Date:15/05/2019 02: 47 PM
 * Assignment:  Day 7
 * Task:  Garbage Collector
 *
 */
public class ArrayShuffling {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random rand = new Random();

	 	if(args.length>20){
	 		System.out.println("Please enter 20 or less elements");
	 	}
	 	else{
	 		System.out.println("Entered array: " + Arrays.toString(args));
	 		// to shuffle the elements
		    for(int i = 0; i < args.length; i++)
		    {
		      int someString =rand.nextInt(args.length);
		      String temp = args[i];
		      args[i] = args[someString];
		      args[someString] = temp;
		    }
		    System.out.println("Randamly Shuffeled arrayy: " +Arrays.toString(args));
	 	}
	}

}
