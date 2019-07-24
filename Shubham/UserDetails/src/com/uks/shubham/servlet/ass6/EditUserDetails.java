package com.uks.shubham.servlet.ass6;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uks.shubham.servlet.DatabaseConnection;

/**
 * Servlet implementation class EditUserDetails
 */
@WebServlet("/EditUserDetails")
public class EditUserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditUserDetails() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		// Intializing the connection
		Connection con = null;
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");

		// connecting to database and returning the con object
		DatabaseConnection dbcon = new DatabaseConnection();
		con = dbcon.connect();

		try {

			request.getSession().setAttribute("authentication", null);
			// Query fire for insertion operation with column name and values
			PreparedStatement prepStmt = con.prepareStatement("SELECT * from userdetails where userid =?");

			prepStmt.setString(1, username);

			int login = 0;
			// executing the query for prapared statment
			ResultSet rs = prepStmt.executeQuery();

			while (rs.next()) {
				if (username.equals(rs.getString(10)) && password.equals(rs.getString(11))) {
					login = 1;
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
					// System.out.println(rs.getString("areaofinterest"));
					RequestDispatcher rd = request.getRequestDispatcher("/ass6/UserEdit.jsp");
					rd.forward(request, response);
					RequestDispatcher rde = request.getRequestDispatcher("/ass6/EditUser.jsp");
					rde.forward(request, response);

				} else {
					login = 0;
				}
			}

			// Display error message if password is incorrect
			if (login == 0) {
				/*
				 * RequestDispatcher rdl =
				 * request.getRequestDispatcher("/ass6/Login.jsp");
				 * rdl.forward(request, response);
				 */
				response.getWriter().println("<script language='javascript'>window.alert('Your Message');");
				request.getSession().setAttribute("authentication", "authentication");
				response.sendRedirect(request.getContextPath() + "/ass6/Login.jsp");
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
