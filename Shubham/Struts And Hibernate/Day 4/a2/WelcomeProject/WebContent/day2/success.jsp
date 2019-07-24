<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="well">
		<s:form action="userDetails" method="post" namespace="/">
		<!-- <h1 style="color: #fff">Successfully Login</h1> -->
		<h3>Welcome <i>${sessionScope.username}</i>, you have logged in successfully!</h3>
		<h3><a href="logout">Logout</a></h3>

		<table>
			<tr><td>First Name:<s:property value="objuser.FirstName"/></td></tr>
			<tr><td>Middle Name:<s:property value="objuser.MiddleName"/></td></tr>
			<tr><td>Last Name:<s:property value="objuser.LastName"/></td></tr>
			<tr><td>Gender:<s:property value="objuser.Gender"/></td></tr>
			<tr><td>Email:<s:property value="objuser.EmailId"/></td></tr>
			<tr><td>Address:<s:property value="objuser.Address"/></td></tr>
		</table>

		<br/>

		<h2>All User Details</h2>
		<table>
			<tr>
				<td><h4>First Name</h4></td>
				<td><h4>Middle Name</h4></td>
				<td><h4>Last name</h4></td>
				<td><h4>Gender</h4></td>
				<td><h4>Email</h4></td>
				<td><h4>Address</h4></td>
			</tr>

			<s:iterator value="list">
			<tr>
				<td><s:property value="FirstName" /></td>
				<td><s:property value="MiddleName" /></td>
				<td><s:property value="LastName" /></td>
				<td><s:property value="Gender" /></td>
				<td><s:property value="EmailId" /></td>
				<td><s:property value="Address" /></td>
			</tr>
			</s:iterator>
		</table>
		</s:form>
	</div>
</body>
</html>