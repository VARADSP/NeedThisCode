/**
 *
 */
package com.uks.shubham.struts.a1;

/**
 * @author Shubham
 *
 */
public class WelcomeAction {

	private String message;
	private String username;

	public WelcomeAction(){
	}

	public String execute() {
		setMessage("Hello " + getUsername());
		String str = getUsername();
		if(!str.isEmpty())
			return "success";
		else
			return "error";
	}

	public String getMessage(){
		return message;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getUsername(){
		return username;
	}

	public void setUsername(String username){
		this.username = username;
	}
}
