/**
 *
 */
package com.uks.shubham.core.day4;

/**
 * @author: 	Shubham Bujurge
 * Created Date:08/05/2019 08: 46 AM
 * Assignment:  Day 3
 * Task: 		System Properties in java
 *
 */
public class SystemProperties {

	void getParameter(String[] args){
		String cmd = args[0];
		if(cmd.equalsIgnoreCase("uname")){
			getUsername();
		}
		else if(cmd.equalsIgnoreCase("osname")){
			getOsname();
		}
		else if(cmd.equalsIgnoreCase("udir")){
			getUserDir();
		}
		else if(cmd.equalsIgnoreCase("all")){
			//Getting all the information
			getUsername();
			getOsname();
			getUserDir();
		}
		else{}
	}
	//This Function is for getting username
	void getUsername(){
		String username = System.getProperty("user.name");
		System.out.println(username);
	}

	//This Function is for getting osname
	void getOsname(){
		String osname = System.getProperty("os.name");
		System.out.println(osname);
	}

	//This Function is for getting user directory
	void getUserDir(){
		String userDirect = System.getProperty("user.dir");
		System.out.println(userDirect);
	}

}
