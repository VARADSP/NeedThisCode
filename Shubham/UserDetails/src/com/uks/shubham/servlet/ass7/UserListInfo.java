package com.uks.shubham.servlet.ass7;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uks.shubham.servlet.DatabaseConnection;

/**
 * Servlet implementation class UserListInfo
 */
@WebServlet("/UserListInfo")
public class UserListInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserListInfo() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		String username = request.getParameter("uname");
		// String password = request.getParameter("pass");

		// Database Connection
		// connecting to database and returning the con object
		DatabaseConnection dbcon = new DatabaseConnection();
		con = dbcon.connect();

		// Fetching data from database
		try {
			PreparedStatement prepStmt = con.prepareStatement("SELECT * from userdetails where userid =?");

			prepStmt.setString(1, username);

			// executing the query for prapared statment
			ResultSet rs = prepStmt.executeQuery();

			while (rs.next()) {
				if (username.equals(rs.getString(10))) {
					HttpSession session = request.getSession();
					session.setAttribute("uname", username);
					session.setAttribute("salutation", rs.getString("salulation"));
					session.setAttribute("fname", rs.getString("firstname"));
					session.setAttribute("middle", rs.getString("middleinitial"));
					session.setAttribute("lname", rs.getString("lastname"));
					session.setAttribute("sex", rs.getString("gender"));
					session.setAttribute("email", rs.getString("email"));
					session.setAttribute("birth", rs.getString("dob"));
					session.setAttribute("address", rs.getString("address"));
					session.setAttribute("interest", rs.getString("areaofinterest"));
					session.setAttribute("othinterest", rs.getString("otherinterest"));

					response.sendRedirect(request.getContextPath() + "/ass7/EditUser.jsp");
					/*
					 * RequestDispatcher rde=
					 * request.getRequestDispatcher("/ass7/EditUser.jsp");
					 * rde.forward(request, response);
					 */
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
