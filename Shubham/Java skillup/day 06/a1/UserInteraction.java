/**
 *
 */
package com.jvs.uks.day06.a1;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: 	Shubham Bujurge
 * Created Date:10/05/2019 08: 49 AM
 * Assignment:  Day 6
 * Task:  User Interaction
 *
 */
public class UserInteraction {

	String[] str = new String[2];
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter any char betwwen a to j");
		String c=scan.nextLine();
		/*System.out.println("Enter Data for operation");
		String string=scan.nextLine();
		String strArray[] = string.split(" ");*/
		String strArray[] = null;
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
		}
		catch(Exception e){
			System.out.println(e.getMessage());}
	}

	//enter == j
	private void fun_assign4_day5(String[] string) throws Exception {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter Path of the file");
		String path = scan.nextLine();
		System.out.println("Enter column name to be search");
		String colname = scan.nextLine();
		EmployeeSortedList objEmployeeSortedList=new EmployeeSortedList();
		//RowPrinter objRowPrinter= new RowPrinter();
		scan.close();
//		if(string.length==2){
		objEmployeeSortedList.path(path,colname);
//		}
//		else{
			//objRowPrinter.path(string[0]);
//		}
	}

	//enter == i
	private void fun_assign3_day5(String[] string) throws IOException {	//Done
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter lastname that will search");
		String strName = scan.nextLine();
		scan.close();
		RowPrinter objRowPrinter=new RowPrinter();
		objRowPrinter.readFileLines("D:\\JVS_WS\\JVSProject\\src\\com\\jvs\\uks\\day06\\a1\\testout.txt",strName);
		objRowPrinter.printSearch("D:\\JVS_WS\\JVSProject\\src\\com\\jvs\\uks\\day06\\a1\\testout.txt");

	}

	//enter == h
	private void fun_assign5_day4(String[] string) {
		//For class Java Map and Collection
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter a string");
		String temp=scan.nextLine();
		string = temp.split(" ");	//split the string
		scan.close();
		FrequencyChecker objChecker = new FrequencyChecker();
		objChecker.frequency(string);
	}

	//enter == g
	private void fun_assign8_day3(String[] string) throws Exception, ReflectiveOperationException, Exception {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter name of the class for calculating the method , fields");
		String name = scan.nextLine();
		System.out.println("Enter a type all | M for method | F for fields");
		String type = scan.nextLine();
		scan.close();
		String[] strArr = new String[2];
		strArr[0] = name;
		strArr[1] = type;
		ClassDetail objClassDetail =new ClassDetail();
		objClassDetail.infoAll(strArr[0],strArr[1]);
	}

	//enter == f
	private void fun_assign5_day3(String[] string) throws ParseException {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter a Date format");
		String date = scan.nextLine();
		System.out.println("Enter a type like day , month or year");
		String type = scan.nextLine();
		System.out.println("Enter a value to be incremented");
		int i = scan.nextInt();
		scan.close();
		str[0] = date;
		str[1] = type;
		DateAdd objDateAdd=new DateAdd();
		try{
		objDateAdd.addDate(str[0],str[1],i);
		}catch(Exception e){}
	}

	//enter == e
	private void fun_assign4_day3(String[] string) throws Exception {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter a Date format ex. dd/MM/yyyy");
		String startDay = scan.nextLine();
		System.out.println("Enter a Date");
		String endDay = scan.nextLine();
		scan.close();
		str[0] = startDay;
		str[1] = endDay;
		DateDifference objDateDifference=new DateDifference();
		objDateDifference.showDateDifference(str);

	}

	//enter == d
	private void fun_assign3_day3(String[] string) throws Exception {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter a Date format ex. dd/MM/yyyy");
		String dateFormat=scan.nextLine();
		System.out.println("Enter a Date (if you dont want enter date then enter => no )");
		String date=scan.nextLine();

		str[0] = dateFormat;
		str[1] = date;
		DateAndTime objDateandTime =new DateAndTime();
		objDateandTime.printDate(str);
		scan.close();
	}

	//enter == c
	private void fun_assign4_day2(String[] string) throws IOException {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter a string");
		String temp=scan.nextLine();
		string = temp.split(" ");	//split the string
		StringOperation objStringReg = new StringOperation();
		objStringReg.doOperationWithRegEx(1, string);
		scan.close();
	}

	//enter == b
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

	//enter == a
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
