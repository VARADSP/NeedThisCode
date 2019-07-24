/**
 *
 */
package com.uks.jvs.day09to11.a1;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author: 	Shubham Bujurge
 * Created Date:20/05/2019 09: 21 AM
 * Assignment:  Day 9-11
 * Task:  Demo Application
 *
 */
public class ReadConfiguration implements Runnable{

	//Execution starts from here
	public void run(){
		Loader objLoader = null;
		Thread thReadConf;
		try{
			objLoader = new Loader();
			thReadConf = new Thread(objLoader,"ReadConf");
			thReadConf.setPriority(10);
			thReadConf.start();

		}catch(Exception e){
			System.out.println(e);
		}
		finally{
			objLoader = null;
		}
	}

	//for getting the user file information path from userDetails.properties file
	public String getUserInfoFile(){
		String getUserInfoFile = null;
		File objFile = null;
		InputStream objInputStream = null;
		Properties objProperties = null;

		try{
			objFile = new File("D:\\JVS_WS\\JVSProject\\src\\com\\uks\\jvs\\day09to11\\a1\\userDetails.properties");
			//System.out.println(objFile.getName());
			//Verify about the given files
			if(objFile.isFile() && objFile.exists()){
				objProperties = new Properties();
				objInputStream = new FileInputStream(objFile);
				//load the file data
				objProperties.load(objInputStream);
				getUserInfoFile = objProperties.getProperty("userInfo");
			}
			else {
				System.out.println("File not found.");
				System.exit(0);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally{
			objFile = null;
			objInputStream = null;
			 objProperties = null;
		}
		return getUserInfoFile;
	}

	//for getting the user file information path from userDetails.properties file
	public String getUserLogInInfo(){
		String userLogInInfoFilePath = null;
		File objFile = null;
		InputStream objInputStream = null;
		Properties objProperties = null;

		try{
			objFile = new File("D:\\JVS_WS\\JVSProject\\src\\com\\uks\\jvs\\day09to11\\a1\\userDetails.properties");
			//System.out.println(objFile.getName());
			//Verify about the given files
			if(objFile.isFile() && objFile.exists()){
				objProperties = new Properties();
				objInputStream = new FileInputStream(objFile);
				//load the file data
				objProperties.load(objInputStream);
				userLogInInfoFilePath = objProperties.getProperty("userLoginInfo");
			}
			else {
				System.out.println("File not found.");
				System.exit(0);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally{
			objFile = null;
			objInputStream = null;
			 objProperties = null;
		}
		return userLogInInfoFilePath;
	}
}
