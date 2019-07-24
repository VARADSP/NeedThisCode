/**
 *
 */
package com.uks.jvs.day08.a3;

import java.io.IOException;

/**
 * @author: 	Shubham Bujurge
 * Created Date:16/05/2019 04: 00 PM
 * Assignment:  Day 8
 * Task:  Merging Employee Info
 *
 */
public class ThreadFirst extends Thread{

	Thread t;
	EmpInfoMerger objEim;
	String str;

	//Constructor with two arguments
	ThreadFirst(EmpInfoMerger objEmp,String str) {
		this.objEim = objEmp;
		this.str = str;
	}

	//when thread start then its executes
	public void run(){
		synchronized(objEim){
			try {
				if(str.equals("read"))
					objEim.writeToResource();	//Calling method for reading the data
				else
					objEim.writeToFile();	//Calling method for writing the data
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}

