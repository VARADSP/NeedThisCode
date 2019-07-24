/**
 *
 */
package com.uks.jvs.day09to11.a1;

import java.io.FileNotFoundException;

/**
 * @author: 	Shubham Bujurge
 * Created Date:17/05/2019 10: 15 AMs
 * Assignment:  Day 9-11
 * Task:  Demo Application
 *
 */
public class UserInteraction extends Thread{

	public static void main(String[] args) throws FileNotFoundException, InterruptedException{
		ThreadGroup objThreadGroup = null;
		LoaderProcess objLoaderProcess = null;
		FinderProcess objFinderProcess = null;
		Thread thLProcess, thUserAuth;

		try{
			System.out.println("Welcome to User Interaction Program");
			objThreadGroup = new ThreadGroup("UserInterection");
			objLoaderProcess = new LoaderProcess();
			thLProcess = new Thread(objThreadGroup, objLoaderProcess,"LProcess");
			thLProcess.setPriority(MAX_PRIORITY);
			thLProcess.start();

			objFinderProcess = new FinderProcess();
			thUserAuth = new Thread(objThreadGroup, objFinderProcess,"UserAuthenticate");
			thUserAuth.setPriority(MAX_PRIORITY);
			thUserAuth.start();

		}catch(Exception e){
			System.out.println(e);
		}finally{
			objLoaderProcess = null;
			objFinderProcess = null;
		}
	}
}
