/**
 *
 */
package com.jvs.uks.day02;

/**
 * @author: 	Shubham Bujurge
 * Created Date:08/05/2019 08: 54 PM
 * Assignment:  Day 2
 * Task: 		Arrays in Java
 *
 */
public class ArrayPopulation {

	//Initialization of array
	int[] resultArr;
	//counter and length variables are initialization
	int iCounter = 0,jCounter = 0,kCounter, length;

	//method for contact two array accordingly even and odd position of the array
	int[] populateArray(int[] firstArr,int[] secondArr){
		length = firstArr.length + secondArr.length; //Getting length of the resultant array
		resultArr = new int[length]; //set resultant array length
		for(kCounter = 0 ; kCounter < length; kCounter++){
			//checking index of the array is even or odd
			if(kCounter % 2 == 0){
				resultArr[kCounter] = secondArr[iCounter]; //if position is even then add element to even index
				iCounter++;
			}
			else{
				resultArr[kCounter] = firstArr[jCounter]; //if position is odd then add element to odd index
				jCounter++;
			}
		}
		return resultArr;
	}
}
