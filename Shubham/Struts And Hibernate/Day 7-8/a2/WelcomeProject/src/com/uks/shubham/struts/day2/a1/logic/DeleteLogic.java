/**
 *
 */
package com.uks.shubham.struts.day2.a1.logic;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.uks.shubham.struts.common.extra.DbLogic;
import com.uks.shubham.struts.common.util.DbMasterNames;
import com.uks.shubham.struts.common.util.HibernateUtil;

/**
 * @author Shubham
 *
 */
public class DeleteLogic {

	// creating object of database class
	DbLogic objdb = new DbLogic();
	Connection con = null;

	// methods perform delete operation
	public void deleteUser(String[] uname) throws SQLException, IOException {

		Session session = null;
		try {
			HibernateUtil objHibUtil = new HibernateUtil();
			// UserDataBean objuser = new UserDataBean();

			session = objHibUtil.getSession();
			session.beginTransaction();
			try {
				for (int i = 0; i < uname.length; i++) {
					Query query = session
							.createQuery("delete " + DbMasterNames.ITEMS_MASTER + " where userid =:uname ");
					query.setParameter("uname", uname[i]);
					query.executeUpdate();
				}
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
