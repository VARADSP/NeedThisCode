package com.uks.shubham.servlet.ass6;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uks.shubham.servlet.DatabaseConnection;

/**
 * Servlet implementation class UpdateUserDetails
 */
@WebServlet("/UpdateUserDetails")
public class UpdateUserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUserDetails() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());

		// For Japanese letter unicode
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		String salutation = request.getParameter("salutation");
		String fname = request.getParameter("fname");
		String middle = request.getParameter("middle");
		String lname = request.getParameter("lname");
		String sex = request.getParameter("sex");
		String email = request.getParameter("email");
		String birth = request.getParameter("birth");
		String address = request.getParameter("address");
		String unamee = request.getParameter("uname");
		String pass = request.getParameter("pass");
		String interest[] = request.getParameterValues("interest");
		String areaOfint = "";
		for (int i = 0; i < interest.length; i++) {
			areaOfint += interest[i] + ",".trim();
		}
		String othinterest = request.getParameter("othinterest");

		// connecting to database and returning the con object
		DatabaseConnection dbcon = new DatabaseConnection();
		con = dbcon.connect();
		// Update data in database by using data from form input in browser
		try {
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("uname");
			if (session != null) {
				String query = "UPDATE northwind_shubam.userdetails SET salulation=?,firstname=?,middleinitial=?,lastname=?,gender=?,email=?,dob=?,address=?,userid=?,password=?,areaofinterest=?,otherinterest=? WHERE userid=?";
				PreparedStatement pst = con.prepareStatement(query);
				pst.setString(1, salutation);
				pst.setString(2, fname);
				pst.setString(3, middle);
				pst.setString(4, lname);
				pst.setString(5, sex);
				pst.setString(6, email);
				pst.setString(7, birth);
				pst.setString(8, address);
				pst.setString(9, unamee);
				pst.setString(10, pass);
				pst.setString(11, areaOfint);
				pst.setString(12, othinterest);
				pst.setString(13, username);
				int i = pst.executeUpdate();
				if (i != 0) {
					out.println("<br>Record has been updated");
				} else {
					out.println("failed to insert the data");
				}
			} else {
				out.print("Please login first");
				request.getRequestDispatcher("Login.jsp").include(request, response);
			}
		} catch (SQLException e) {
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

	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
