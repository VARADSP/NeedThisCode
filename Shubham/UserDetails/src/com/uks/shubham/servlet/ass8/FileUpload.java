package com.uks.shubham.servlet.ass8;

/**
 * @author: 	Shubham Bujurge
 * Created Date:18/06/2019 8 : 40 AM
 * Assignment:  Day 4
 * Task: 		Jsp & servlet
 *
 */
import java.util.List;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

/**
 * Servlet implementation class FileUpload
 */
@WebServlet("/FileUpload")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final String UPLOAD_DIRECTORY = "D:/Test";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileUpload() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Getting the request is multipart or not
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				// Getting uploaded file is multipart or not
				List<FileItem> multiFile = new ServletFileUpload(new DiskFileItemFactory())
						.parseRequest(new ServletRequestContext(request));

				// each file is checking and uploading in the location
				for (FileItem item : multiFile) {
					// checks the is file or others something
					if (!item.isFormField()) {
						// Getting the file name
						String name = new File(item.getName()).getName().trim();
						// copy the given file into local server location
						item.write(new File(UPLOAD_DIRECTORY + File.separator + name));
					}
				}
				// file sucessfully uploaded then print the message
				request.setAttribute("messageInfo", "File upload Sucessfully");
			} catch (Exception e) {
				request.setAttribute("messageInfo", "File not upload");
			}
		} else {
			// something is happened then print the error message
			request.setAttribute("message", "Servlet cant handle this request");
		}
		// redirect to the next jsp page
		request.getRequestDispatcher("/ass8/FileOutput.jsp").forward(request, response);
	}

}
