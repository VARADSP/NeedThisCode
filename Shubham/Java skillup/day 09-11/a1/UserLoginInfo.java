/**
 *
 */
package com.uks.jvs.day09to11.a1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: 	Shubham Bujurge
 * Created Date:17/05/2019 11: 36 AM
 * Assignment:  Day 9-11
 * Task:  Demo Application
 *
 */
public class UserLoginInfo extends Thread{

	int userId;
	String username,password,userRole;

	public void run(){
		try{
			getUserLogInInfo();
		}
		catch(Exception e){
			e.getStackTrace();
		}
	}

	//Getting the records from file and add these records to list
	public synchronized List<String> getUserLogInInfo() throws IOException {
		String strLine;
		FileInputStream objFileInputStream = null;
		BufferedReader objBufferedReader = null;
		File objFile = null;
		ReadConfiguration objReadConfiguration = null;
		List<String> userLogInInfoList = null;
		int i =0;
		try{
			userLogInInfoList = new ArrayList<>();
			objReadConfiguration = new ReadConfiguration();
			objFile = new File(objReadConfiguration.getUserLogInInfo());

			//validate the file
			if(objFile.exists()){
				if(objFile.isFile()){
					objFileInputStream = new FileInputStream(objFile);
					objBufferedReader = new BufferedReader(new InputStreamReader(objFileInputStream));

					while((strLine = objBufferedReader.readLine()) != null){

						if(!(strLine.equals(null))){
							userLogInInfoList.add(i,strLine);
							i++;
						}
						else
							System.out.println("File is doesnt contain any data");
					}
				}
				else{
					System.out.println("Enter only file path");
				}
			}
			else{
				System.out.println("File Doesnt found");
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			if(objFileInputStream != null)
				objFileInputStream.close();
			if(objBufferedReader != null)
				objBufferedReader.close();
			objReadConfiguration = null;
			objFile = null;
		}
		return userLogInInfoList;
	}

	//Getting the UserLoginInfo list and returns the List
	public List<UserLoginInfo> loginInfo(){
		int i = 0, j = 0;
		String[]  userLogInWords;
		UserLoginInfo objUserLogInInfo = null;
		List<String> data;
		UserLoginInfo objUserLogIn = null;
		boolean parsable = true;
		List<UserLoginInfo> loginDetails = null;
		try{
			objUserLogIn = new UserLoginInfo();
			loginDetails = new ArrayList<>();
			data = new ArrayList<>();

			// get data from shared variable to local variable
			data = objUserLogIn.getUserLogInInfo();

			for(i = 0; i < data.size(); i++){
				userLogInWords = data.get(i).split(",");

				try{
					Integer.parseInt(userLogInWords[0]);
				}
				catch(Exception e){
					System.out.println("Please enter proper data, userid is not a number");
					parsable = false;
					break;
				}

				if(parsable){
					objUserLogInInfo = new UserLoginInfo();
					//getting all the data fields
					objUserLogInInfo.setUserId(Integer.parseInt(userLogInWords[0]));
					objUserLogInInfo.setUserName(userLogInWords[1]);
					objUserLogInInfo.setPassword(userLogInWords[2]);
					loginDetails.add(j, objUserLogInInfo);
					j++;
				}
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			objUserLogInInfo = null;
		}
		return loginDetails;
	}

	//Get and Set methods for getting & setting the values
	public String getUsername() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
