/**
 *
 */
package com.uks.shubham.struts.day2.a1.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.uks.shubham.struts.day2.a1.bean.LoginBean;
import com.uks.shubham.struts.day2.a1.bean.UserDataBean;

/**
 * @author Shubham
 *
 */
public class WelcomeAction extends ActionSupport implements SessionAware {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> sessionMap;

	// Creating object
	public LoginBean objbean;

	// Define arraylist of UserDataBean class
	public ArrayList<UserDataBean> list = new ArrayList<UserDataBean>();

	public String logout() {
		// remove userName from the session
		if (sessionMap.containsKey("username")) {
			sessionMap.remove("username");
		}
		return SUCCESS;
	}

	// Login check method using session vaiable
	@SuppressWarnings("unused")
	public String login() {
		String loggedUsername = null, loggedPassword = null;
		// check if the userName is already stored in the session
		if (sessionMap.containsKey("username")) {
			loggedUsername = (String) sessionMap.get("username");
			return SUCCESS;
		}
		if (loggedUsername != null && loggedPassword != null) {
			// sessionMap.put("username", username);
			return SUCCESS;
		}
		if (!objbean.getPassword().isEmpty() && !objbean.getUsername().isEmpty()) {
			sessionMap.put("username", objbean.getUsername());
			sessionMap.put("password", objbean.getPassword());

			return SUCCESS; // return welcome page
		} else {
			return ERROR;
		}
	}

	// String method of the class
	public String execute() throws SQLException, IOException {
		// method for session getting and setting method
		String status = login();

		if (status.equals(SUCCESS)) {
			// checking username and password
			if (objbean.getPassword().length() == 0 && objbean.getUsername().length() == 0) {
				addActionError("Please Enter Username and password");
			} else if (objbean.getPassword().length() == 0) {
				addActionError("Password is required");
			} else if (objbean.getUsername().length() == 0) {
				addActionError("Username is required");
			} else if (!objbean.getUsername().isEmpty() && !objbean.getPassword().isEmpty()) {

				return "success";
			}
		} else {
			addActionError("Username and password is incorrect");
		}
		// return login if user unable to login into the system
		return "login";
	}

	// Getter and Setter method for UserDataBean and LoginBean
	public LoginBean getObjbean() {
		return objbean;
	}

	public void setObjbean(LoginBean objbean) {
		this.objbean = objbean;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}
