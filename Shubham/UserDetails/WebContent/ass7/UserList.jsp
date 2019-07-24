<%@ page import="java.util.ArrayList"%>
<%@ page import="com.uks.shubham.servlet.ass7.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<%
			String uname = (String) session.getAttribute("uname");
			if (uname != null) {
				ArrayList<Users> users = new ArrayList<>();
				users = (ArrayList<Users>) request.getAttribute("userList");
				/* System.out.println(request.getAttribute("userList")); */
		%>
		<h2>User List</h2>
		<table class="table">
			<tr>
				<th>Sr. No.</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email Id</th>
				<th>Edit</th>
			</tr>
			<%
				for (int i = 1; i < users.size(); i++) {
			%>
			<tr>
				<td><%=i%></td>
				<td><%=users.get(i).getFname()%></td>
				<td><%=users.get(i).getLname()%></td>
				<td><%=users.get(i).getEmail()%></td>
				<%-- <td><form action="${pageContext.request.contextPath}/UserListInfo" method="post" >
					<% out.print( users.get(i).getUname().toString()); %>
						<input type="hidden" name="uname"
							value="<%=users.get(i).getFname()%>
							<%request.getSession().setAttribute("uname",users.get(i).getUname());%>">
						<button type="submit" class="btn btn-primary" name="Edit_Button_Click"  onclick="myFunction()">Edit</button>
					</form></td> --%>
				<td><input type="hidden" name="uname" id="uname"
					value="<%=users.get(i).getUname()%>"></td>
				<td>
					<button type="submit" class="btn btn-primary"
						name="Edit_Button_Click" id="<%=users.get(i).getUname()%>"
						onclick="myFunction(this.id)">Edit</button>
				</td>
			</tr>
			<%
				}
			%>
		</table>
		<%
			} else {
				//out.print("Please login first");
				request.getRequestDispatcher("Login.jsp").include(request, response);
			}
		%>
	</div>
	<script>
	function myFunction(username){
		//alert(username);
		window.location.href= '/UserDetails/UserListInfo?uname='+username;
		//windows.location.href = request.getContextPath()+"/UserListInfo";
		}
	</script>

</body>
</html>