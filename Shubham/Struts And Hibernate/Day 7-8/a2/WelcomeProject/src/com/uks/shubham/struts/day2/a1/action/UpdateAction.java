/**
 *
 */
package com.uks.shubham.struts.day2.a1.action;

import java.io.IOException;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;
import com.uks.shubham.struts.common.util.Constants;
import com.uks.shubham.struts.day2.a1.bean.UserDataBean;
import com.uks.shubham.struts.day2.a1.logic.UpdateLogic;

/**
 * @author Shubham
 *
 */
public class UpdateAction extends ActionSupport {
	/**
	 * This class is use for update action
	 */
	private static final long serialVersionUID = 1L;

	String message, uname;

	// Setter methods for username
	public void setUname(String uname) {
		this.uname = uname;
	}

	UpdateLogic objlogic = new UpdateLogic();
	public UserDataBean listbean;

	// Getter and Setter methods for UserDataBean
	public UserDataBean getListbean() {
		return listbean;
	}

	public void setListbean(UserDataBean listbean) {
		this.listbean = listbean;
	}

	// Default execution method for class
	public String execute() throws SQLException, IOException {
		try {
			// calling method updateuser with parameter as object and return
			// message
			message = objlogic.updateuser(listbean);
			if (message == Constants.updateRecordSucc) {
				// if records updated then return success and print message
				addActionError("Record is updatted");
				return SUCCESS;
			} else {
				// if records not updated then return error and error print
				// message
				addActionError(Constants.updateRecordUnSucc);
				return ERROR;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
}
