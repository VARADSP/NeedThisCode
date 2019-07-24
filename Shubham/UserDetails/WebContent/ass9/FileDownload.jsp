<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./FileDownload.css">
</head>
<body class="main">
	<%
		File folder = new File("D:/Test/");
		File[] listOfFiles = folder.listFiles();
		List<File> fileList = new ArrayList<File>();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				fileList.add(listOfFiles[i]);
			}
		}
	%>
	<h3>Select File To Download</h3>
	<form action="/UserDetails/FileDownload" method="post">
		<table class="table">
			<tr>
				<th>File List</th>
			</tr>
			<tr>
				<td>Sr. No.</td>
				<td></td>
				<td>File Name</td>
			</tr>
			<%
				if (fileList.size() > 0) {
					int srno;
					for (int i = 0; i < fileList.size(); i++) {
						srno = i + 1;
						out.print("<tr>	<td>" + srno
								+ "</td><td><input type=\"radio\" required=\"required\" name=\"file\" value=\""
								+ fileList.get(i).getName() + "\"></td><td class=\"file\">" + fileList.get(i).getName()
								+ "</td></tr>");
					}
				}
			%>
			<tr>
				<td><input type="submit" name="submit" value="Download"
					class="btn" /></td>
				<td><input type="reset" name="reset" class="btn" /></td>

			</tr>
		</table>
	</form>
</body>
</html>