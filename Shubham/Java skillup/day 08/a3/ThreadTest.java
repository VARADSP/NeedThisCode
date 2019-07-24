/**
 *
 */
package com.uks.jvs.day08.a3;

import java.io.IOException;

/**
 * @author: 	Shubham Bujurge
 * Created Date:16/05/2019 04: 09 PM
 * Assignment:  Day 8
 * Task:  Merging Employee Info
 *
 */
class ThreadSecond extends Thread {

	Thread t;
	EmpInfoMerger objEim;

	//constructor with parameter
	ThreadSecond(EmpInfoMerger objEim2) {
		this.objEim = objEim2;
	}

	//when thread start then its executes
	public void Run(){
		synchronized(objEim){
			try {
				objEim.writeToFile();	//Calling write to file method
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
