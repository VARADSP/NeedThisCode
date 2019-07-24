/**
 *
 */
package com.uks.shubham.struts.day2.a1.action;

import java.io.IOException;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;
import com.uks.shubham.struts.day2.a1.bean.UserDataBean;
import com.uks.shubham.struts.day2.a1.logic.EditLogic;

/**
 * @author Shubham
 *
 */
public class EditAction extends ActionSupport {
	/**
	 * This class is use for Edit user action
	 */
	private static final long serialVersionUID = 1L;
	// creating edit logic class
	EditLogic objedit = new EditLogic();
	UserDataBean listbean;

	String uname, pass;

	// Getter and Setter methods for username and password
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	// Getter UserDataBean Getter and setter methods
	public UserDataBean getListbean() {
		return listbean;
	}

	public void setListbean(UserDataBean listbean) {
		this.listbean = listbean;
	}

	// Default execution of te method
	public String execute() throws SQLException, IOException {
		try {
			listbean = objedit.editUser(uname);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}

	}

}
