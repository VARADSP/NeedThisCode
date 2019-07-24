/**
 *
 */
package com.uks.shubham.core.day4;

import java.util.Scanner;
/**
 * @author: 	Shubham Bujurge
 * Created Date:07/05/2019 10: 30 AM
 * Assignment:  Day 1
 * Task: 		Reading Command Line Argument Program
 *
 * Last Updated: 09/05/2019 9:23 AM
 *
 */
public class TestCommandLine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Getting username and password from user
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Username and password");
		String username = scan.nextLine().toString();
		String password = scan.nextLine().toString();

		if(!username.isEmpty() && !password.isEmpty()){
			//sent the arguments to validate function
			UserNamePassword objUserName = new UserNamePassword();
			objUserName.validate(username, password);
		}
		else
			System.out.println("Enter the username and password Both");
		//closing the scanner object
		scan.close();
	}

}
