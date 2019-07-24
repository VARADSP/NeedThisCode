/**
 *
 */
package com.uks.jvs.day09to11.a1;

/**
 * @author: 	Shubham Bujurge
 * Created Date:17/05/2019 10: 46 AM
 * Assignment:  Day 9-11
 * Task:  Demo Application
 *
 */
public class Loader extends Thread{

	//execution start of Loader
	public void run(){
	ThreadGroup objThreadGroupUser = null;
	Thread thUserInfo, thUserLoginInfo, thMergeInfo;
	UserInfo objUserInfo = null;
	UserLoginInfo objUserLoginInfo = null;
	MergeInfo objMergeInfo = null;

		try{
			objThreadGroupUser = new ThreadGroup("UserInfo");
			objThreadGroupUser.setMaxPriority(10);

			//creating thread to access the userInfo
			objUserInfo = new UserInfo();
			thUserInfo = new Thread(objThreadGroupUser, (Runnable) objUserInfo, "UserInfo");
			thUserInfo.setPriority(MAX_PRIORITY);
			thUserInfo.start();

			//creating thread to access the userLoginINfo
			objUserLoginInfo = new UserLoginInfo();
			thUserLoginInfo = new Thread(objThreadGroupUser, (Runnable) objUserLoginInfo, "UsrLogInInfo");
			thUserLoginInfo.setPriority(MAX_PRIORITY);
			thUserLoginInfo.start();

			//creating the thread for merge info class
			objMergeInfo = new MergeInfo();
			thMergeInfo = new Thread(objThreadGroupUser, (Runnable) objMergeInfo, "MeargeData");
			thMergeInfo.setPriority(MAX_PRIORITY);
			Thread.sleep(1000);
			thMergeInfo.start();

			//joining the threads
			thUserInfo.join();
			thUserLoginInfo.join();
			thMergeInfo.join();
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally{
			objUserInfo = null;
			objUserLoginInfo = null;
			objMergeInfo = null;
		}
	}
}
