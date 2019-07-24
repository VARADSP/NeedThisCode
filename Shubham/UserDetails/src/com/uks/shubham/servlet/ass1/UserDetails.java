package com.uks.shubham.servlet.ass1;

/**
 * @author: 	Shubham Bujurge
 * Created Date:13/06/2019 03: 37 PM
 * Assignment:  Day 1
 * Task: 		Jsp & servlet
 *
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserDetails
 */
@WebServlet("/UserDetails")
public class UserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public UserDetails() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// getting the user input data from jsp pages using PrintWriter
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
		// Storing multiple interest in array
		String[] interest = request.getParameterValues("interest");
		String othInterest = request.getParameter("othinterest");

		// Printing all user inputs data on console
		System.out.println();
		System.out.println("================================================\n");
		System.out.println("Personal Details:\n");
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
		// Printing all the Interest one by one
		if (interest != null) {
			System.out.println("Interests are: ");
			for (String inter : interest) {
				System.out.println("\t" + inter);
			}
		}
		System.out.println("Other Interest is: " + othInterest);
		System.out.println("\n================================================");

		// Message prints on web pages for user undastanding
		out.print("Your Details printed on the console, please check the console for result");

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
