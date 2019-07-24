package com.uks.shubham.servlet.ass9;

/**
 * @author: 	Shubham Bujurge
 * Created Date:18/06/2019 8 : 40 AM
 * Assignment:  Day 4
 * Task: 		Jsp & servlet
 *
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDownload
 */
@WebServlet("/FileDownload")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileDownload() {
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

		// creating writer object
		PrintWriter out = response.getWriter();
		// getting the parameter of file name
		String filename = request.getParameter("file");
		System.out.println("File name is:" + filename);
		// getting the file from location
		String filepath = "D://Test//" + request.getParameter("file");
		// set the content type
		response.setContentType("APPLICATION/OCTET-STREAM");
		// setting the file content with the header and file name
		response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");

		// file input stream with file path
		FileInputStream fis = new FileInputStream(filepath);
		// Getting the file
		int i;
		while ((i = fis.read()) != -1) {
			out.write(i);
		}
		fis.close();
		out.close();
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
