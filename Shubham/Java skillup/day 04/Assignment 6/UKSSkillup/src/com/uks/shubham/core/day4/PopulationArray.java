/**
 *
 */
package com.uks.shubham.core.day4;

/**
 * @author: 	Shubham Bujurge
 * Created Date:08/05/2019 08: 55 PM
 * Assignment:  Day 2
 * Task: 		Arrays in Java
 *
 */
public class PopulationArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Declare two arrays
		int[] firstArr =  {10,20,30,40,50,60};
		int[] secondArr = {1,2,3,4,5,6};
		int[] resultArr;
		//Creating the object of ArrayPopulation class
		ArrayPopulation objArrayPopulation = new ArrayPopulation();


		//Checking the two array of same size or not
		if(firstArr.length == secondArr.length){
			resultArr = objArrayPopulation.populateArray(firstArr,secondArr); //Passing two array to the method for rearranging the content
			PopulationArray objPopulationArray = new PopulationArray();
			objPopulationArray.print(resultArr);	//this is the print function with the parameter result array for printing
		}
		else //if array size doesn't match then show this message
			System.out.println("Enter Equal Size of array");
	}

	//printing the resultant array
	void print(int[] resultArr){
		for( int cnt = 0; cnt < resultArr.length; cnt++ ){
			System.out.println(resultArr[cnt]);
		}
	}
}
