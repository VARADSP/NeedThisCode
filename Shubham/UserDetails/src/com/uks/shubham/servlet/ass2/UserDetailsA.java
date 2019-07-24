package com.uks.shubham.servlet.ass2;

/**
 * @author: 	Shubham Bujurge
 * Created Date:14/06/2019 10 : 00 AM
 * Assignment:  Day 1
 * Task: 		Jsp & servlet
 *
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserDetailsA
 */
@WebServlet("/UserDetailsA")
public class UserDetailsA extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Intializing the connection
	Connection con = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserDetailsA() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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

		try {
			// Getting database url,bb,name and pass from properties file
			FileInputStream fis = new FileInputStream("D:\\JVS_WS\\UserDetails\\src\\settings.properties");
			// Created ResourceBundle with parameter fileInputStream
			ResourceBundle myBundle = new PropertyResourceBundle(fis);
			// Storing the DB info into local variables
			String dbname = myBundle.getString("DBname");
			String url = myBundle.getString("URL");
			String db_user = myBundle.getString("Username");
			String db_pass = myBundle.getString("Password");
			// Intializing the dbname
			Class.forName(dbname);
			// establishmenting the connection
			con = DriverManager.getConnection(url, db_user, db_pass);
			System.out.println("Database Connecting.....");

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			// Query fire for insertion operation with column name and values
			PreparedStatement prepStmt = con.prepareStatement(
					"insert into userdetails(salulation,firstname,middleinitial,lastname,gender,email,dob,address,userid,password,areaofinterest,otherinterest) values(?,?,?,?,?,?,?,?,?,?,?,?)");
			// Set all variable values in prepared statment
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

			// executing the query
			int i = prepStmt.executeUpdate();
			if (i > 0) {
				out.println("You are successfully registered");
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
			// printing the interest info on console
			if (interest != null) {
				System.out.println("Interests are: ");
				for (String inter : interest) {
					System.out.println("\t" + inter);
				}
			}
			System.out.println("Other Interest is: " + othInterest);
			System.out.println("================================================");

			// printing the info on the webpage
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

	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
