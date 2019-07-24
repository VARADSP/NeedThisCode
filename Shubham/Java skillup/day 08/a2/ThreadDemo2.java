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
public class ThreadDemo2 implements Runnable{

	//thread start then this method runs
	public void run() {
		System.out.println("From ThreadDemoOne");
		for(int i=1;i<5000;i++){
			if(i%75==0){
				try{
					Thread.sleep(200);	//Thread sleeps for 200ms
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			System.out.println("Thread Two : "+i+1);	//prints the count of thread how many time its run
		}
	}

}
