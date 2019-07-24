package com.uks.shubham.servlet.ass10;

/**
 * @author: 	Shubham Bujurge
 * Created Date:18/06/2019 8 : 40 AM
 * Assignment:  Day 4
 * Task: 		Jsp & servlet
 *
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CSVFileDownload
 */
@WebServlet("/CSVFileDownload")
public class CSVFileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CSVFileDownload() {
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
		response.setContentType("application/csv");
		response.setHeader("content-disposition", "filename=Report.csv");
		OutputStream out = response.getOutputStream();
		Connection con = null;
		Properties prop;
		// connection with database
		try {
			// Intializing the connection from propery file
			String path = "D:\\JVS_WS\\UserDetails\\src\\settings.properties";
			FileInputStream reader = new FileInputStream(path);
			File file = new File(path);
			if (!file.exists()) {
				System.out.println("Invalid path");
			}
			prop = new Properties();
			prop.load(reader);
			String user = prop.getProperty("Username");
			String pass = prop.getProperty("Password");
			String url = prop.getProperty("URL");
			String driverClass = prop.getProperty("DBname");

			// Finding the Driver class
			Class.forName(driverClass);
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("......................");

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		try {
			// Fire Query and getting all the information
			String query = "SELECT * from userdetails";
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(query);
			String output = "ID,Salutaion,First_Name,Middle_innitial,Last_Name,Sex,Email_id,Birth_date,Address,User_Name,Password,Interest,Other_interest";
			out.write(output.getBytes());
			// Writing the data into the CSV file with all the column values
			while (rs.next()) {
				output = "\n" + rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3) + "," + rs.getString(4)
						+ "," + rs.getString(5) + "," + rs.getString(6) + "," + rs.getString(7) + "," + rs.getString(8)
						+ "," + rs.getString(9) + "," + rs.getString(10) + "," + rs.getString(11) + ","
						+ rs.getString(12) + "," + rs.getString(13);
				out.write(output.getBytes());
			}
		} catch (Exception e) {
			e.printStackTrace();
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

}
