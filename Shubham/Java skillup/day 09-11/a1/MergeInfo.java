/**
 *
 */
package com.uks.jvs.day09to11.a1;

import java.util.ArrayList;
import java.util.List;


/**
 * @author: 	Shubham Bujurge
 * Created Date:17/05/2019 01: 11 PM
 * Assignment:  Day 9-11
 * Task:  Demo Application
 *
 */
public class MergeInfo extends Thread{

	private int userid;
	private long telNumber;
	private double salary;
	private String uname, userRole, address, city;
	public static List<MergeInfo> mergedArray;


	public MergeInfo() {
	}

	//Execution starts from here
	public void run(){
 		UserInfo objUserInfo = null;
		UserLoginInfo objUserLoginInfo = null;

		try{
			objUserLoginInfo = new UserLoginInfo();
			objUserInfo = new UserInfo();
			mergeData(objUserInfo.getUserInfo(),objUserLoginInfo.getUserLogInInfo());
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	//Merge the two file UserInfo and UserLoginInfo into one arrayList and return the List
	@SuppressWarnings("finally")
	private List<MergeInfo> mergeData(List<String> userInfo, List<String> userLogInInfo) {
		String[] userInfoWords;
		String[] userLogInWords;
		MergeInfo objMergeInfo;
		Boolean parsable = true;
		int i = 0, j = 0,k=0;

		try{
			mergedArray = new ArrayList<MergeInfo>();
			for(i = 0; i < userInfo.size(); i++){
				objMergeInfo = new MergeInfo();
				userInfoWords = userInfo.get(i).split(",");


				for(j=0; j< userLogInInfo.size(); j++){
					userLogInWords = userLogInInfo.get(j).split(",");
					if(userInfoWords[0].equals(userLogInWords[0])){
						try{
							Integer.parseInt(userInfoWords[0]);
							Double.parseDouble(userInfoWords[4]);
							Long.parseLong(userInfoWords[5]);

							if(parsable){
								objMergeInfo.setUserId(Integer.parseInt(userInfoWords[0]));
								objMergeInfo.setUName(userInfoWords[1]);
								objMergeInfo.setUserRole(userLogInWords[3]);
								objMergeInfo.setAddress(userInfoWords[2]);
								objMergeInfo.setCity(userInfoWords[3]);
								objMergeInfo.setSalary((Double.parseDouble(userInfoWords[4]) * 1.2));// + (Double.parseDouble(userInfoWords[4])));
								objMergeInfo.setTelNumber(Long.parseLong(userInfoWords[5]));
								mergedArray.add(k, objMergeInfo);
								k++;
							}
						}catch(Exception e){
							System.out.println("Please enter valid data,string can't be converted to number");
							parsable = false;
							break;
						}

					}
				}
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally{
			return mergedArray;
		}
	}

	// get() and set() for userid, telNumber, salary, uname, userRole, address, city
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

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
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
