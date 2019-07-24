/**
 *
 */
package com.jvs.uks.day06.a3;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Scanner;

import com.jvs.uks.day01.MultiCommandLine;
import com.jvs.uks.day02.StringOperation;
import com.jvs.uks.day02.StringOperationRegEx;
import com.jvs.uks.day03.ClassDetail;
import com.jvs.uks.day03.DateAdd;
import com.jvs.uks.day03.DateAndTime;
import com.jvs.uks.day03.DateDifference;
import com.jvs.uks.day04.FrequencyChecker;
import com.jvs.uks.day05.a3.RowPrinter;
import com.jvs.uks.day05.a4.EmployeeSortedList;
import com.jvs.uks.day06.a1.UserInteraction;

/**
 * @author: 	Shubham Bujurge
 * Created Date:10/05/2019 02: 30 PM
 * Assignment:  Day 6
 * Task:  Creating Custom class
 *
 */
public class InvalidInputException {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter any char betwwen a to j");
		String c=scan.nextLine();
		System.out.println("Enter Data for operation");
		String string=scan.nextLine();
		String strArray[] = string.split(" ");
		UserInteraction objUserInteraction =new UserInteraction();
		objUserInteraction.useroutput(c,strArray);
		scan.close();
	}

	//method to choose the action to b perform
	public void useroutput(String c,String[] string) throws Exception{
		try{
			switch(c){

			case "a": fun_assign4_day1(string);break;

			case "b": fun_assign3_day2(string);break;

			case "c": fun_assign4_day2(string);break;

			case "d": fun_assign3_day3(string);break;

			case "e": fun_assign4_day3(string);break;

			case "f": fun_assign5_day3(string);break;

			case "g": fun_assign8_day3(string);break;

			case "h": fun_assign5_day4(string);break;

			case "i": fun_assign3_day5(string);break;

			case "j": fun_assign4_day5(string);break;

			default : System.out.println("Enter valid input");

			}
		}catch(Exception e){}
	}

	private void fun_assign4_day5(String[] string) throws Exception {
		EmployeeSortedList objEmployeeSortedList=new EmployeeSortedList();
		RowPrinter objRowPrinter= new RowPrinter();
		if(string.length==2){
			objEmployeeSortedList.path(string[0],string[1]);
		}
		else{
			objRowPrinter.readFileLines(string[0],string[1]);
		}
	}

	private void fun_assign3_day5(String[] string) throws IOException {	//Done
		RowPrinter objRowPrinter=new RowPrinter();
		objRowPrinter.readFileLines("D:\\JVS_WS\\JVSProject\\src\\com\\jvs\\uks\\day05\\a3\\testout.txt", string[0]);
		objRowPrinter.printSearch();

	}

	private void fun_assign5_day4(String[] string) {
		//For class Java Map and Collection
		FrequencyChecker objChecker = new FrequencyChecker();
		objChecker.frequency(string);
	}

	private void fun_assign8_day3(String[] string) throws Exception, ReflectiveOperationException, Exception {
		ClassDetail objClassDetail =new ClassDetail();
		objClassDetail.infoAll(string[0],string[1]);

	}

	private void fun_assign5_day3(String[] string) throws ParseException {
		int i =Integer.parseInt(string[2]);
		DateAdd objDateAdd=new DateAdd();
		objDateAdd.addDate(string[0],string[1],i);

	}

	private void fun_assign4_day3(String[] string) throws Exception {
		DateDifference objDateDifference=new DateDifference();
		objDateDifference.showDateDifference(string);

	}

	private void fun_assign3_day3(String[] string) throws Exception {
		DateAndTime objDateandTime =new DateAndTime();
		objDateandTime.printDate(string);

	}

	private void fun_assign4_day2(String[] string) throws IOException {
		StringOperation objStringReg = new StringOperation();
		objStringReg.doOperationWithRegEx(1, string);

	}

	private void fun_assign3_day2(String[] string) {	//Done
		System.out.println(string[0]);
		System.out.println("Please choose from following \n 1) String Reverse 2) Count Letters ");
		System.out.println("Your Choice?");
		Scanner scan=new Scanner(System.in);
		int i=scan.nextInt();
		StringOperationRegEx objStringOperationRegEx=new StringOperationRegEx();
		switch(i){
		case 1:	objStringOperationRegEx.doOperationWithRegEx(i,string);break;
		case 2:	objStringOperationRegEx.doOperationWithRegEx(i,string);break;
		default : System.out.println("Please enter 1 or 2");
		scan.close();
		}
	}

	private void fun_assign4_day1(String[] string) {	//Done
		System.out.println("Please choose from following \n 1) Add numbers 2) Change to lower cse ");
		System.out.println("Your Choice?");
		Scanner scan=new Scanner(System.in);
		String i=scan.nextLine();
		String[] finalstr, com;
		MultiCommandLine objMultiCommandLine=new MultiCommandLine();
		try{
			switch(i){
			case "1":com=i.split(" ");
					finalstr = Arrays.copyOf(com,com.length+string.length) ;
					System.arraycopy(string, 0, finalstr, com.length, string.length);
					objMultiCommandLine.doOperation(finalstr);
					break;
			case "2":com=i.split(" ");
					finalstr = Arrays.copyOf(com,com.length+string.length) ;
					System.arraycopy(string, 0, finalstr, com.length, string.length);
					objMultiCommandLine.doOperation(finalstr);
					break;
			default : System.out.println("Please enter 1 or 2");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		scan.close();

	}

}
