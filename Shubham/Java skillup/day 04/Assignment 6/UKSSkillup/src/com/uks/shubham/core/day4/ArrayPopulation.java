/**
 *
 */
package com.uks.shubham.core.day4;

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
	int iCnt = 0, iLen;
	int jCnt = 0,jLen;
	public int kLen,kCnt;

	//method for contact two array accordingly even and odd position of the array
	int[] populateArray(int[] firstArr,int[] secondArr){
		kLen = firstArr.length + secondArr.length; //Getting length of the resultant array
		resultArr = new int[kLen]; //set resultant array length
		for(kCnt = 0 ; kCnt < kLen; kCnt++){
			//checking index of the array is even or odd
			if(kCnt % 2 == 0){
				resultArr[kCnt] = secondArr[iCnt]; //if position is even then add element to even index
				iCnt++;
			}
			else{
				resultArr[kCnt] = firstArr[jCnt]; //if position is odd then add element to odd index
				jCnt++;
			}
		}
		return resultArr;
	}
}
