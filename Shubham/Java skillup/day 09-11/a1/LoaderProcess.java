/**
 *
 */
package com.uks.jvs.day09to11.a1;

/**
 * @author: 	Shubham Bujurge
 * Created Date:17/05/2019 10: 18 AM
 * Assignment:  Day 9-11
 * Task:  Demo Application
 *
 */
public class LoaderProcess implements Runnable{
	ReadConfiguration objReadConfiguration = null;
	Thread thLoaderProcess = null;
	//execution start of LoaderProcess
	public void run(){
		try{
			objReadConfiguration = new ReadConfiguration();
			thLoaderProcess = new Thread((Runnable) objReadConfiguration);
			thLoaderProcess.setPriority(10);
			thLoaderProcess.start();
		}catch(Exception e){
			objReadConfiguration = null;
		}
	}
}
