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
import com.uks.shubham.struts.common.util.Constants;
import com.uks.shubham.struts.day2.a1.bean.LoginBean;
import com.uks.shubham.struts.day2.a1.bean.UserDataBean;
import com.uks.shubham.struts.day2.a1.logic.LoginLogic;

/**
 * @author Shubham
 *
 */
public class WelcomeAction extends ActionSupport implements SessionAware {

	/**
	 * This class is use for welcome user action after login
	 */
	private static final long serialVersionUID = 1L;

	String loggedUsername = null;
	String loggedPassword = null;
	private Map<String, Object> sessionMap;

	// Creating object
	public LoginBean objbean;
	public UserDataBean objuser;
	UserDataAction objFetch = new UserDataAction();
	public LoginLogic objLogic = new LoginLogic();

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
	public String login() {
		loggedUsername = objbean.getUsername();
		loggedPassword = objbean.getPassword();
		// check if the userName is already stored in the session
		if (sessionMap.containsKey("username")) {
			loggedUsername = (String) sessionMap.get("username");
			loggedPassword = (String) sessionMap.get("password");
			return SUCCESS;
		} else if (loggedUsername != null && loggedPassword != null) {
			// sessionMap.put("username", username);
			return SUCCESS;
		}
		else {
			return ERROR;
		}
	}

	// Strting method of the class
	public String execute() throws SQLException, IOException {

		try{
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
				if (objLogic.validateUser(loggedUsername, loggedPassword,sessionMap)) {
					sessionMap.put("username", objbean.getUsername());
					sessionMap.put("password", objbean.getPassword());
					if(sessionMap.get("category").equals("user")){
						// Calling the method of UserDataAction with parameter of
						// username
						objuser = objFetch.fetchUserData(loggedUsername);
						list = objFetch.fetchAllUserData();
						return "user";
					}
					else{
						return "success";
					}
				}
			}
		} else {
			addActionError(Constants.incorrectUnamePass);
		}
		// return login if user unable to login into the system
		addActionError(Constants.incorrectUnamePass);
		return "login";
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
		finally{
			addActionError(" ");
		}
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
