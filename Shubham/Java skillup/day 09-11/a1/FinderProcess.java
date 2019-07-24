/**
 *
 */
package com.uks.jvs.day09to11.a1;

/**
 * @author: 	Shubham Bujurge
 * Created Date:20/05/2019 04: 44 PM
 * Assignment:  Day 9-11
 * Task:  Demo Application
 *
 */
public class FinderProcess implements Runnable{

	//execution start of FinderProcess
	public void run(){
		LogInAuthentication objLogInAuthentication = null;
		Thread thLoaderProcess = null;
		try {
			objLogInAuthentication = new LogInAuthentication();
			//create thread of LogInAuthentication to continue LoaderProcess
			thLoaderProcess = new Thread(objLogInAuthentication);
			thLoaderProcess.setPriority(10);
			thLoaderProcess.start();
		} catch (Exception ex) {
			objLogInAuthentication = null;
		}
	}

}
