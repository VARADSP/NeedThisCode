/**
 *
 */
package com.uks.shubham.core.day4;

/**
 * @author: 	Shubham Bujurge
 * Created Date:07/05/2019 10: 19 AM
 * Assignment:  Day 1
 * Task: 		Reading Command Line Argument Program
 *
 */
public class UserNamePassword {

	//Username and password are 2 constant values
	final String USERNAME = "admin", PASSWORD = "123";

	//This method is for accepting and validating the values
	void validate(String username, String password){
		if(USERNAME.equalsIgnoreCase(username.trim()) || PASSWORD.equalsIgnoreCase(password.trim()))
			System.out.println("Usernaem and password are correct");
		else
			System.out.println("Username and password doesnt match");
	}
}