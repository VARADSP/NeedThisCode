package com.uks.shubham.struts.day2.a1.logic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.uks.shubham.struts.common.util.DbMasterNames;
import com.uks.shubham.struts.common.util.HibernateUtil;
import com.uks.shubham.struts.day2.a1.bean.UserDataBean;

/**
 * Logic for fetching user list from database
 *
 * @author shubham
 *
 */
public class UserListLogic {
	// Initializing the arrayList
	List<UserDataBean> list = new ArrayList<UserDataBean>();

	// Initializing query
	String hQuery = "from " + DbMasterNames.ITEMS_MASTER;

	// according to selection of the data select query genearete and getting the
	// select result
	@SuppressWarnings("unchecked")
	public List<UserDataBean> getUserList(String uname, String category, String fname, String address, String gender,
			String email) throws SQLException, IOException {

		HibernateUtil objHibUtil = new HibernateUtil();
		// UserDataBean objuser = new UserDataBean();

		Session session = objHibUtil.getSession();
		session.beginTransaction();
		try {
			if (uname == null || category == null || fname == null || address == null || gender == null
					|| email == null) {
				System.out.println(hQuery);

				return list;
			} else {
				// if every thing is empty
				if (!uname.equals("") || !category.equals("---") || !fname.equals("") || !address.equals("")
						|| !gender.equals("---") || !email.equals("")) {
					hQuery = hQuery + " WHERE salulation Like '%%'  ";
				}
				// if username is not null
				if (!uname.equals("")) {
					hQuery = hQuery + " AND userid = '" + uname + "'";
				}
				// if category is not null
				if (!category.equals("---")) {
					hQuery = hQuery + " AND category = '" + category + "'";
				}
				// if firstnmae is not null
				if (!fname.equals("")) {
					hQuery = hQuery + " AND firstname = '" + fname + "'";
				}
				// if address is not null
				if (!address.equals("")) {
					hQuery = hQuery + " AND address = '" + address + "'";
				}
				// if gender is not null
				if (!gender.equals("---")) {
					hQuery = hQuery + " AND gender = '" + gender + "'";
				}
				// if email is not null
				if (!email.equals("")) {
					hQuery = hQuery + " AND email = '" + email + "'";
				}

				Query query = session.createQuery(hQuery);
				list = query.list();
				return list;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return list;
	}
}
