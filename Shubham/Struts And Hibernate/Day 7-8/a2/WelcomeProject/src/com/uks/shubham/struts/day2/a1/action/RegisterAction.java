package com.uks.shubham.struts.day2.a1.action;

import java.io.IOException;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;
import com.uks.shubham.struts.day2.a1.bean.FormBean;
import com.uks.shubham.struts.day2.a1.logic.RegisterLogic;
//import com.struts.dhruvi.day3.logic.UpdateLogic;

/**
 * Action class to register new user in database (by admin only)
 *
 * @author shubham
 *
 */

public class RegisterAction extends ActionSupport {
	/**
	 * This class is use for register action
	 */
	RegisterLogic objregi = new RegisterLogic();

	private static final long serialVersionUID = 1L;

	FormBean formList;

	// Getter and Setter methods
	public FormBean getFormList() {
		return formList;
	}

	public void setFormList(FormBean formList) {
		this.formList = formList;
	}

	// Default execution of class
	public String execute() throws SQLException, IOException {

		objregi.registeruser(formList);
		return SUCCESS;
	}
}
