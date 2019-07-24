/**
 *
 */
package com.uks.shubham.struts.day1.a1;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Shubham
 *
 */
public class WelcomeAction extends ActionSupport implements SessionAware {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	// Initializing username and message variables
	private String message;
	private String username;
	private Map<String, Object> sessionMap;

	@SuppressWarnings("unused")
	public String login() {
		String loggedUserName = null;
		// check if the userName is already stored in the session
		if (sessionMap.containsKey("username")) {
			loggedUserName = (String) sessionMap.get("username");
			return SUCCESS;
		}
		if (loggedUserName != null) {
			// sessionMap.put("username", username);
			return SUCCESS;
		}
		if (!username.isEmpty()) {
			sessionMap.put("username", username);

			return SUCCESS; // return welcome page
		} else {
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

	public WelcomeAction() {
	}

	// Strting method of the class
	public String execute() {
		setMessage("Hello " + getUsername());
		String str = getUsername();
		if (!str.isEmpty())
			return "success";
		else
			return "error";
	}

	// Getter and Setter methods
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}
