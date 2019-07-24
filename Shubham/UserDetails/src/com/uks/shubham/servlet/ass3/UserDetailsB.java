package com.uks.shubham.servlet.ass3;

/**
 * @author: 	Shubham Bujurge
 * Created Date:14/06/2019 01 : 16 PM
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
 * Servlet implementation class UserDetailsB
 */
@WebServlet("/UserDetailsB")
public class UserDetailsB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserDetailsB() {
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

			// Show Data on Console
			System.out.println();
			System.out.println("================================================");
			System.out.println("Salutation is: " + sal);
			System.out.println("First Name is: " + fname);
			System.out.println("Middle Initial is: " + mname);
			System.out.println("Lastname is: " + lname);
			System.out.println("Sex is: " + sex);
			System.out.println("Email Id is: " + email);
			System.out.println("Birth Date is: " + dob);
			System.out.println("Address is: " + address);
			System.out.println("username is: " + uname);
			System.out.println("password is: " + pass);
			// printing info of interest on console
			if (interest != null) {
				System.out.println("Interests are: ");
				for (String inter : interest) {
					System.out.println("\t" + inter);
				}
			}
			System.out.println("Other Interest is: " + othInterest);
			System.out.println("================================================");

			// printing the information on web page
			out.print("Your Details printed on the console, please check the console for result");

		} catch (Exception e) {
			out.print("We cant able to process your request");
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
