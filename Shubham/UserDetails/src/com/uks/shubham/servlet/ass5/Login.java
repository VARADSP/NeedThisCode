package com.uks.shubham.servlet.ass5;

/**
 * @author: 	Shubham Bujurge
 * Created Date:17/06/2019 08 : 45 AM
 * Assignment:  Day 3
 * Task: 		Jsp & servlet
 *
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uks.shubham.servlet.DatabaseConnection;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Intializing the connection
	Connection con = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());

		// Getting data from user inputs and stored in local variables
		PrintWriter out = response.getWriter();

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

			// executing the query for prapared statment
			ResultSet rs = prepStmt.executeQuery();

			while (rs.next()) {
				if (username.equals(rs.getString(10)) && password.equals(rs.getString(11))) {
					out.println("<html><body>\n" + "<h2>Your Salutation is: " + rs.getString(2) + "</h2>\n"
							+ "<h2>Your First name is: " + rs.getString(3) + "</h2>\n" + "<h2>Your Middle name is: "
							+ rs.getString(4) + "</h2>\n" + "<h2>Your Last is: " + rs.getString(5) + "</h2>\n"
							+ "<h2>Your Gender is: " + rs.getString(6) + "</h2>\n" + "<h2>Your Email id is: "
							+ rs.getString(7) + "</h2>\n" + "<h2>Your Date of birth is: " + rs.getString(8) + "</h2>\n"
							+ "<h2>Your Address is: " + rs.getString(9) + "</h2>\n" + "<h2>Your Username is: "
							+ rs.getString(10) + "</h2>\n" + "<h2>Your Password is: " + rs.getString(11) + "</h2>\n"
							+ "<h2>Your Interest is: " + rs.getString(12) + "</h2>\n" + "<h2>Your Other Interest is: "
							+ rs.getString(13) + "</h2>\n" + "</body></html>\n");

					// printing the information on web page
					out.print("Successfully login user");
				} else {
					// out.println("Enter valid username and password");
					request.getSession().setAttribute("authentication", "authentication");
					response.sendRedirect(request.getContextPath() + "/ass5/Login.jsp");
				}
			}

		} catch (Exception e) {
			out.print("We cant able to process your request");
			System.out.println(e);
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

	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
