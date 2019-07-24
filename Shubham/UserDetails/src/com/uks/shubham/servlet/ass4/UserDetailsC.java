package com.uks.shubham.servlet.ass4;

/**
 * @author: 	Shubham Bujurge
 * Created Date:14/06/2019 02 : 16 PM
 * Assignment:  Day 1
 * Task: 		Jsp & servlet
 *
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uks.shubham.servlet.DatabaseConnection;

/**
 * Servlet implementation class UserDetailsC
 */
@WebServlet("/UserDetailsC")
public class UserDetailsC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserDetailsC() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Intializing the connection
		Connection con = null;

		// For Japanese letter unicode
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// setting this for activate html page and its necesary tags
		response.setContentType("text/html; charset=utf-8");

		// Getting data from user inputs and stored in local variables
		PrintWriter out = response.getWriter();
		String sal = request.getParameter("sal");
		String fname = request.getParameter("firstname");
		String mname = request.getParameter("middlename");
		String lname = request.getParameter("lastname");
		String sex = request.getParameter("gender");
		String email = request.getParameter("emailid");
		String dob = request.getParameter("dob");
		String address = request.getParameter("Address");
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		// Storing multiple interest in arrays
		String[] interest = request.getParameterValues("interest");
		// Storing interest in local variable
		String allIneterest = "";
		for (int i = 0; i < interest.length; i++) {
			allIneterest += interest[i] + ",".trim();
		}
		String othInterest = request.getParameter("othinterest");

		// connecting to database and returning the con object
		DatabaseConnection dbcon = new DatabaseConnection();
		con = dbcon.connect();

		try {
			// Query fire for insertion operation with column name and values
			PreparedStatement prepStmt = con.prepareStatement(
					"insert into userdetails(salulation,firstname,middleinitial,lastname,gender,email,dob,address,userid,password,areaofinterest,otherinterest) values(?,?,?,?,?,?,?,?,?,?,?,?)");
			// Storing all the variable values into the prepared statment
			prepStmt.setString(1, sal);
			prepStmt.setString(2, fname);
			prepStmt.setString(3, mname);
			prepStmt.setString(4, lname);
			prepStmt.setString(5, sex);
			prepStmt.setString(6, email);
			prepStmt.setString(7, dob);
			prepStmt.setString(8, address);
			prepStmt.setString(9, uname);
			prepStmt.setString(10, pass);
			prepStmt.setString(11, allIneterest);
			prepStmt.setString(12, othInterest);

			// executing the query for prapared statment
			int i = prepStmt.executeUpdate();
			if (i > 0) {
				out.println("You are successfully registered.");
			} else {
				out.println("Can't registered the data into datacase");
			}

			out.println("<html><body>\n" + "<h4>Your Salutation is: " + sal + "</h4>\n" + "<h4>Your First name is: "
					+ fname + "</h4>\n" + "<h4>Your Middle name is: " + mname + "</h4>\n" + "<h4>Your Last is: " + lname
					+ "</h4>\n" + "<h4>Your Gender is: " + sex + "</h4>\n" + "<h4>Your Email id is: " + email
					+ "</h4>\n" + "<h4>Your Date of birth is: " + dob + "</h4>\n" + "<h4>Your Address is: " + address
					+ "</h4>\n" + "<h4>Your Username is: " + uname + "</h4>\n" + "<h4>Your Password is: " + pass
					+ "</h4>\n" + "<h4>Your Interest is: " + allIneterest + "</h4>\n" + "<h4>Your Other Interest is: "
					+ othInterest + "</h4>\n" + "</body></html>\n");

			// printing the information on web page
			out.print("Successfully added data and printed on web page");

		} catch (Exception e) {
			out.print("We cant able to process your request\n");
			out.print("Check your username is already assigned with us");
			System.out.println(e);
		}
		out.close();
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
