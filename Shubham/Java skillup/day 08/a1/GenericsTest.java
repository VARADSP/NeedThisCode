/**
 *
 */
package com.uks.jvs.day08.a1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: 	Shubham Bujurge
 * Created Date:16/05/2019 11: 08 AM
 * Assignment:  Day 8
 * Task:  Generics in java
 *
 */
public class GenericsTest {
	Map<Long, String> map = new HashMap<Long, String>();

	public static void main(String[] args){
		long mobile;
		String name ;
		Scanner scan = new Scanner(System.in);

		try{
			GenericsTest obj = new GenericsTest();
			obj.addToDir();
			System.out.println("Enter many elements you want to add: ");
			int ele = scan.nextInt();

			for(int i = 0; i < ele; i++){
				System.out.println("Enter Mobile number");
				mobile = scan.nextLong();
				System.out.println("Enter first name of user");
				name = scan.next();

				//Calling function for add data to directory
				obj.addToDirectory(mobile, name);
			}

			//print all the elements
			obj.printAll();
			//searching
			//for  dynamically
			System.out.println("===============Enter Mobile number of Jenny or Jecob=====================");
			mobile = scan.nextLong();
			obj.searchMobile(mobile);

			System.out.println("===============Enter Mobile number=====================");
			mobile = scan.nextLong();
			obj.searchMobile(mobile);
		}
		catch(Exception e){
			System.out.println("Enter valid data");
		}
		finally{
			scan.close();
		}
	}

	//data insertion dynamically
	void addToDirectory(Long number, String name){
		map.put(number, name);
	}

	//adding some predefining methods
	void addToDir(){
		//Hashmap add the elements initially
		map.put(9987123456l, "Jacob");
		map.put(9819123456l, "Jenny");
	}

	//Searching for mobile number
	void searchMobile(long key){
		String value = map.get(key);
		System.out.println("Entered number "+ key + " mobile number is belong to:" + value);
	}

	//printing all the information
	@SuppressWarnings("rawtypes")
	void printAll(){
		int i = 1;
		for( Map.Entry entry : map.entrySet() ) {
		    long key = (long) entry.getKey();
		    String value = (String) entry.getValue();
		    System.out.println("("+i+")" + "Name: " + value);
		    System.out.println("Mobile: " + key);
		    i += 1;
		}

	}
}
