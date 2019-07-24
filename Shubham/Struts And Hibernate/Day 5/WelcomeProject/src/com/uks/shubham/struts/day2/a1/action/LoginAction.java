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
import com.uks.shubham.struts.day2.a1.logic.LoginLogic;;

/**
 * @author Shubham
 *
 */
public class LoginAction extends ActionSupport implements SessionAware {

	/**
	 * This class is use for user login action
	 */
	private static final long serialVersionUID = 1L;

	// Creating object
	UserDataAction objFetch = new UserDataAction();
	LoginLogic objLogic = new LoginLogic();
	// Initailizing the objects
	public UserDataBean objuser;
	public LoginBean objbean;
	// Define arraylist of UserDataBean class
	public ArrayList<UserDataBean> list = new ArrayList<UserDataBean>();

	private Map<String, Object> sessionMap;

	String loggedUsername = null, loggedPassword = null;

	// Login check method using session vaiable
	public String login() {

		// check if the userName is already stored in the session
		if (sessionMap.containsKey("username")) {
			loggedUsername = (String) sessionMap.get("username");
			loggedPassword = (String) sessionMap.get("password");
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

	public String logout() {
		// remove userName from the session
		if (sessionMap.containsKey("username")) {
			sessionMap.remove("username");
		}
		return SUCCESS;
	}

	// execute() is the default starting method to be execute first
	public String execute() throws SQLException, IOException {

		try{
		// method for session getting and setting method
		String status = login();

		if (status.equals(SUCCESS)) {
			if (objLogic.validateUser(loggedUsername, loggedPassword, sessionMap)) {

				// returing the list of objects
				if (sessionMap.get("category").equals("admin")) {
					// Calling the method of UserDataAction with parameter of
					// username
					objuser = objFetch.fetchUserData(loggedUsername);
					list = objFetch.fetchAllUserData();
					return "success";
					/*
					 * list = objFetch.fetchAllUserData(); return "success";
					 */
				} else {
					// Calling the method of UserDataAction with parameter of
					// username
					objuser = objFetch.fetchUserData(loggedUsername);
					return "success";
				}
			}
		} else {
			addActionError("Username and password is incorrect");
		}
		// return login if user unable to login into the system
		return "login";
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
	}

	// Getter and Setter method for UserDataBean and LoginBean
	public UserDataBean getObjuser() {
		return objuser;
	}

	public void setObjuser(UserDataBean objuser) {
		this.objuser = objuser;
	}

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
