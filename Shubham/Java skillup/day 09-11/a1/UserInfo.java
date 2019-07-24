/**
 *
 */
package com.uks.jvs.day09to11.a1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: 	Shubham Bujurge
 * Created Date:17/05/2019 01: 21 PM
 * Assignment:  Day 9-11
 * Task:  Demo Application
 *
 */
public class UserInfo extends Thread{
	private int userid;
	private long telNumber;
	private double salary;
	private String uname,  address, city;

	//Constructor
	public UserInfo() {
	}

	//Execution start from
	public void run(){
		getUserInfo();
	}

	//Getting the UserInfo list and returns the List
	synchronized List<String> getUserInfo() {
		FileInputStream objFileInputStream = null;
		BufferedReader objBufferedReader = null;
		File objFile = null;
		String strLine;
		ReadConfiguration objReadConfiguration = null;
		List<String> userInfoList = null;
		int i = 0;

		try{
			userInfoList = new ArrayList<>();
			objReadConfiguration = new ReadConfiguration();

			objFile = new File(objReadConfiguration.getUserInfoFile());

			if(objFile.exists()){
				objFileInputStream = new FileInputStream(objFile);
				objBufferedReader = new BufferedReader(new InputStreamReader(objFileInputStream));
				if(objFile.isFile()){
					while((strLine = objBufferedReader.readLine()) != null){
						if(!strLine.equals(null)){
							userInfoList.add(i,strLine);
						}
						else{
							System.out.println("File doesnt contain any data");
						}
					}
				}else{
					System.out.println("Enter only file path");
				}
			}else{
				System.out.println("File doesnt found the file information");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try {
				if (objFileInputStream != null)
					objFileInputStream.close();
				if (objBufferedReader != null)
					objBufferedReader.close();
				objFile = null;
				objReadConfiguration = null;
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}
		return userInfoList;
	}

	public int getUserId() {
		return userid;
	}

	public void setUserId(int userId) {
		this.userid = userId;
	}

	public String getUName() {
		return uname;
	}

	public void setUName(String uname) {
		this.uname = uname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public long getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(long telNumber) {
		this.telNumber = telNumber;
	}



}
