/**
 *
 */
package com.uks.shubham.core.day4;

/**
 * @author: 	Shubham Bujurge
 * Created Date:07/05/2019 11: 16 AM
 * Assignment:  Day 1
 * Task: 		Reading undefined number of Command Line Argument Program
 *
 * Last Updated: 09/05/2019 10:37 AM
 *
 */
public class MultiCommandLine {

	public Integer[] arrInt;
	public String[] arrStr;

	//This function is doing the operations
	void doOperation(String[] args){
		//Getting the first argument of args
		String firstArgument = args[0];
		int intLength = args.length;
		int intCnt, intSum = 0;
		boolean flag;
		boolean isValid = false;
		arrInt = new Integer[args.length];
		//Condition checking if 1st argument is 1 then execute this
		if(firstArgument.equalsIgnoreCase("1")){
			for(intCnt = 1; intCnt < intLength; intCnt++){
				flag = isNumber(args[intCnt]);
				if(flag == true){
					arrInt[intSum] = Integer.parseInt(args[intCnt]);
					intSum++;
					//System.out.println(args[intCnt]);
				}
				else{
					System.out.println("Enter Arguments in not in correct format");
					isValid = true;
					break;

					//System.out.println("Argument had the String value: "+ args[intCnt]);
				}
			}
			if(isValid == false)
			printIntegerArray();
		}
		//Condition checking if 1st argument is 2 then execute this
		else if(firstArgument.equalsIgnoreCase("2")){
			for(intCnt = 1; intCnt < intLength; intCnt++){
				flag = isCharecter(args[intCnt]);
				if(flag == true){
					arrStr[intSum] = args[intCnt];
					intSum++;
					//System.out.println(args[intCnt].toLowerCase());
				}
				else{
					System.out.println("Enter Arguments in not in correct format");
					break;
					//System.out.println("Argument had the String value: "+ args[intCnt]);
				}
				if(isValid == false)
				printStringArray();
			}
		}
		//Condition checking if 1st argument is AddNumber then execute this
		else if(firstArgument.equalsIgnoreCase("AddNumber")){
			for(intCnt = 1; intCnt < intLength; intCnt++){
				flag = isNumber(args[intCnt]);
				if(flag == true){
					intSum += Integer.parseInt(args[intCnt]);
				}
			}
			System.out.println("Sum of Integer Numbers = " + intSum);
		}
		//Condition checking for nothing has to match
		else{
			System.out.println("You have not entered first args according to program");
		}
	}

	//Method for checking the Number
	boolean isNumber(String str){
		try{
			Integer.parseInt( str );
			return true;
		} catch( NumberFormatException e ){ return false; }
	}

	//Method for checking the Character
	boolean isCharecter(String str){

		char ch = str.charAt(0);
		if ((!(ch >= 'A' && ch <= 'Z')) && (!(ch >= 'a' && ch <= 'z'))) {
			return false;
        }
		return true;
	}

	//Method for checking number and Permitted Cherecter
	boolean isCharPermitted(String str){
		char ch = str.charAt(0);
		if (ch == 'L' || ch == 'D' || ch == 'F' || ch == 'l' || ch == 'd' || ch == 'f'){
			return true;
		}
		else if ((!(ch >= 'A' && ch <= 'Z')) && (!(ch >= 'a' && ch <= 'z'))) {
			return false;
        }
		return true;
	}
	void printIntegerArray(){
		int sum = 0;
		for(int i = 0; i < arrInt.length; i++ ){
			if(arrInt[i] != null)
			sum = sum + arrInt[i];
		}
		System.out.println("Sum of Integer Numbers = " + sum );
	}
	void printStringArray(){
		int sum = 0;
		for(int i = 0; i < arrInt.length; i++ ){
			if(arrInt[i] != null)
			sum = sum + arrInt[i];
		}
		System.out.println("Sum of Integer Numbers = " + sum );
	}
}
