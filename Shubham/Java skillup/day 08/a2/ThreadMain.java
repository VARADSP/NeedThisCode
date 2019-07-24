/**
 *
 */
package com.uks.jvs.day08.a2;

/**
 * @author: 	Shubham Bujurge
 * Created Date:16/05/2019 03: 08 PM
 * Assignment:  Day 8
 * Task:  Thread
 *
 */
public class ThreadMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//create thread 1 and call its start
		ThreadDemo1 th1 = new ThreadDemo1();
		th1.start();
		//create thread 2 and call its start
		Thread th2 = new Thread(new ThreadDemo2());
		th2.start();

	}

}
