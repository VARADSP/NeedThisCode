/**
 *
 */
package com.uks.jvs.day08.a3;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author: 	Shubham Bujurge
 * Created Date:16/05/2019 03: 50 PM
 * Assignment:  Day 8
 * Task:  Merging Employee Info
 *
 *
 */
public class MainThread {

	/**
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {

		//Creating Employee objects with file nad mode parameters
		EmpInfoMerger objEmpInfoMerger1 = new EmpInfoMerger("D:\\JVS_WS\\JVSProject\\src\\com\\uks\\jvs\\day08\\a3\\emp_name.txt","read");
		EmpInfoMerger objEmpInfoMerger2 = new EmpInfoMerger("D:\\JVS_WS\\JVSProject\\src\\com\\uks\\jvs\\day08\\a3\\emp_add.txt","read");
		EmpInfoMerger objEmpInfoMerger3 = new EmpInfoMerger("D:\\JVS_WS\\JVSProject\\src\\com\\uks\\jvs\\day08\\a3\\emp_details.txt","write");

		//Creating objects of threads
		ThreadFirst th1 = new ThreadFirst(objEmpInfoMerger1,"read");
		ThreadFirst th2 = new ThreadFirst(objEmpInfoMerger2,"read");



		//Threads starts
		th1.start();
		Thread.sleep(100);	//waiting for thread 1
		th2.start();
		Thread.sleep(100);	//waiting for thread 1
		Thread.yield();		//skip for now
		Thread.sleep(1000);
		//Thread third is calling
		ThreadFirst th3 = new ThreadFirst(objEmpInfoMerger3,"write");
		th3.start();
		try{
			th1.join();		//Give the chance to remaining thread
			th2.join();		//Give the chance to remaining thread

		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
