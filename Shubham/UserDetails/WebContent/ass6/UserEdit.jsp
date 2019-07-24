<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UserDetails Edit</title>
<link rel="stylesheet" href="login.css" />
</head>
<body>
	<%
		String uname = (String) session.getAttribute("uname");
		if (uname != null) {
	%>
	<h2>
		Hey
		<%=session.getAttribute("uname")%>
	</h2>
	<table class="table">
		<tr>
			<th colspan="2">User Details</th>
		</tr>
		<tr>
			<td>Salutation:</td>
			<td><%=session.getAttribute("salutation")%></td>
		</tr>
		<tr>
			<td>First Name:</td>
			<td><%=session.getAttribute("fname")%></td>
		</tr>
		<tr>
			<td>Middle Initial:</td>
			<td><%=session.getAttribute("middle")%></td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td><%=session.getAttribute("lname")%></td>
		</tr>
		<tr>
			<td>Sex:</td>
			<td><%=session.getAttribute("sex")%></td>
		</tr>
		<tr>
			<td>Email Id:</td>
			<td><%=session.getAttribute("email")%></td>
		</tr>
		<tr>
			<td>Birth Date:</td>
			<td><%=session.getAttribute("birth")%></td>
		</tr>
		<tr>
			<td>Address:</td>
			<td><%=session.getAttribute("address")%></td>
		</tr>
		<tr>
			<td>Interest:</td>
			<td><%=session.getAttribute("interest")%></td>
		</tr>
		<tr>
			<td>Other Interest:</td>
			<td><%=session.getAttribute("othinterest")%></td>
		</tr>
		<tr>
			<td colspan="2 "><form action="/UserDetails/ass6/EditUser.jsp">
					<button type="submit" class="btn btn-info">Edit</button>
				</form></td>
		</tr>
	</table>
	<%
		} else {
			out.print("Please login first");
			request.getRequestDispatcher("Login.jsp").include(request, response);
		}
	%>
</body>
</html>