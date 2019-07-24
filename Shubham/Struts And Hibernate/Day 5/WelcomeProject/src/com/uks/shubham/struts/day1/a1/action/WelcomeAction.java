/**
 *
 */
package com.uks.shubham.struts.day1.a1.action;

import com.opensymphony.xwork2.ActionSupport;
import com.uks.shubham.struts.day1.a1.bean.WelcomeBean;
import com.uks.shubham.struts.day1.a1.logic.WelcomeLogic;

/**
 * @author Shubham
 *
 */
public class WelcomeAction extends ActionSupport{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	// Initializing username and message variables
	public WelcomeBean objbean = new WelcomeBean();
	public WelcomeLogic objLogic = new WelcomeLogic();

	// Strting method of the class
	public String execute() {
		String loggedUsername = objbean.getUsername();
		String loggedPassword = objbean.getPassword();
		objLogic.login(loggedUsername,loggedPassword);

		objbean.setMessage("Hello " + loggedUsername);
		String str = loggedUsername;
		if (!str.isEmpty())
			return "success";
		else
			return "error";
	}

	/*public String login(){
		String loggedUsername = objbean.getUsername();
		String loggedPassword = objbean.getPassword();
		return objLogic.login(loggedUsername,loggedPassword);
	}*/
}
