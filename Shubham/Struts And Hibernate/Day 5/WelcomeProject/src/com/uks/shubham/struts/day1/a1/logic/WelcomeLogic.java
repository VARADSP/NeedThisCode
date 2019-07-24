/**
 *
 */
package com.uks.shubham.struts.day1.a1.logic;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.uks.shubham.struts.day1.a1.bean.WelcomeBean;

/**
 * @author Shubham
 *
 */
public class WelcomeLogic extends ActionSupport implements SessionAware {

	/**
	 * Checking username and password both are entered correctly then return the success
	 */
	private static final long serialVersionUID = 1L;
	// Initializing username and message variables
	public WelcomeBean objbean = new WelcomeBean();
	private Map<String, Object> sessionMap;

	public String login(String loggedUsername,String loggedPassword) {

		try{
		// check if the userName is already stored in the session
		if (!loggedUsername.isEmpty() && !loggedPassword.isEmpty()) {
			return SUCCESS;
		}
		else {
			return ERROR;
		}
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
	}

	public String logout() {
		// remove userName from the session
		if (sessionMap.containsKey("username")) {
			sessionMap.remove("username");
		}
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}
