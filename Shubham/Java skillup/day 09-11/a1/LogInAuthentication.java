/**
 *
 */
package com.uks.jvs.day09to11.a1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: 	Shubham Bujurge
 * Created Date:20/05/2019 09: 45 AM
 * Assignment:  Day 9-11
 * Task:  Demo Application
 *
 */
public class LogInAuthentication extends Thread{

	public String username,password;

	//execution start of LogInAuthentication
	public void run(){
		userAuthentication();
	}

	//Authenticate the user according to the input values and file values
	public void userAuthentication(){
		int attempt = 3, i = 0;
		boolean flag = false;
		List<UserLoginInfo> userData = null;
		List<UserLoginInfo> loginData = null;
		UserLoginInfo objUserLogInInfo = null;
		DisplayInfo objDisplayInfo = null;
		try {
			objUserLogInInfo = new UserLoginInfo();
			loginData = objUserLogInInfo.loginInfo();
			objDisplayInfo = new DisplayInfo();
			userData = new ArrayList<UserLoginInfo>();
			do {
				// take input for username and password by calling getData()
				getData();
				for (i = 0; i < loginData.size(); i++) {
					objUserLogInInfo = loginData.get(i);
					if (username.equalsIgnoreCase(objUserLogInInfo.getUsername())
							&& password.equalsIgnoreCase(objUserLogInInfo.getPassword())) {
						/**
						 * when username and password are correct than welcome
						 * message will be printed
						 **/
						System.out.println("\n" + "Welcome "
								+ objUserLogInInfo.getUsername() + " ("
								+ objUserLogInInfo.getUserId() + ")");
						userData.add(objUserLogInInfo);
						/**
						 * userId of LogIned user will pass to dispRecord() of
						 * DisplayInfo class
						 **/
						objDisplayInfo.dispRecord(Integer
								.toString(objUserLogInInfo.getUserId()));
						flag = true;
						break;
					}
				}
				/**
				 * when username or password will be wrong, it will display
				 * message and show how much attempt/attempts are remaining
				 */

				if (flag == false) {
					System.out
							.println("------------------------------------------------------------------");
					System.out
							.println("username and password you entered don't match. Please try again.");
					System.out.println("-----------------------");
					System.out.println((attempt - 1) + " attempt remaining.");
					System.out.println("-----------------------");

					/**
					 * when attempt will be 0 system get exited by saying this
					 * message.
					 */
					if ((attempt - 1) == 0) {
						System.out
								.println("The System gets closed because the data you have provided is not valid. Please re-confirm it.");
						System.out
								.println("----------------------------------------------------------------------------------------------");
					}
				} else {
					break;
				}
				/**
				 * if user name or password will be wrong attempt will be decreased
				 */
				if (attempt > 0) {
					attempt--;
				}
			} while (attempt >= 1);
		} catch (Exception ex) {

		} finally {
			loginData = null;
			objUserLogInInfo = null;
			objDisplayInfo = null;
		}
	}


	 // getData() will take input of userName and password from the user
	private void getData() {
		Scanner objScanner = null;
		try {
			objScanner = new Scanner(System.in);
			System.out.println("Enter username:");
			username = objScanner.nextLine();
			System.out.println("Enter password:");
			password = objScanner.nextLine();
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			objScanner = null;
		}
	}
}
