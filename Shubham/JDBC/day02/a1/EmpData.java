/**
 *
 */
package com.uks.shubham.day02.a1;

/**
* @author: 	Shubham Bujurge
 * Created Date:07/06/2019 11: 40 AM
 * Assignment:  Day 2
 * Task: 	Displaying records in Per Page Fashion
 *
 */
public class EmpData {

	String eid,ename,etitle,eaddress,eHomePhone;

	//Setter Methods for id, name, title,address and phone number
	void setEmployeeId(String employeeID){
		eid = employeeID;
	}

	void setName(String name){
		ename = name;
	}

	void setTitle(String title){
		etitle = title;
	}

	void setAddress(String address){
		eaddress = address;
	}

	void setHomePhone(String homePhone){
		eHomePhone = homePhone;
	}

	//Getter Methods for id, name, title,address and phone number
	String getEmployeeId(){
		return eid;
	}

	String getName(){
		return ename;
	}
	String getTitle(){
		return etitle;
	}
	String getAddress(){
		return eaddress;
	}
	String getHomePhone(){
		return eHomePhone;
	}
}
