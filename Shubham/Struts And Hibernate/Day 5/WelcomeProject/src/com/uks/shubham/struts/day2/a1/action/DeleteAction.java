/**
 *
 */
package com.uks.shubham.struts.day2.a1.action;

import java.io.IOException;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;
import com.uks.shubham.struts.common.util.Constants;
import com.uks.shubham.struts.day2.a1.logic.DeleteLogic;

/**
 * @author Shubham
 *
 */
public class DeleteAction extends ActionSupport {

	/**
	 * This class is use for delete action
	 */
	private static final long serialVersionUID = 1L;

	private String userids;

	public String getUserids() {
		return userids;
	}

	public void setUserids(String userids) {
		this.userids = userids;
	}

	// Creating delete logic object
	DeleteLogic objdelete = new DeleteLogic();

	// execution starts from here
	public String execute() throws SQLException, IOException {

		try {
			// spliting the comma separated array
			String[] idsArray = userids.split(","); // converting in array
			System.out.println(Constants.deleteUser + userids);

			// calling deleteUser method from logic class
			objdelete.deleteUser(idsArray);
			addActionError(Constants.deleteSuccess);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}

	}
}
