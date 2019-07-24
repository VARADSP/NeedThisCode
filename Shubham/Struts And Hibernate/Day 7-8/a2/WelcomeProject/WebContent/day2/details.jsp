<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="style.css" />
<title>User Details</title>
</head>
<body>
	<div class="well user">
		<h1 style="color: #fff">User Details</h1>
		<s:form action="userInfoOnly" method="post" namespace="/">
			<h3>
				Welcome <i>${sessionScope.username}</i>, you have logged in
				successfully!
			</h3>
			<table class="userdet table">
				<tr>
					<td>Salutation: <s:property value="objuser.salutation" /></td>
				</tr>
				<tr>
					<td>First Name: <s:property value="objuser.FirstName" /></td>
				</tr>
				<tr>
					<td>Middle Name: <s:property value="objuser.MiddleName" /></td>
				</tr>
				<tr>
					<td>Last Name: <s:property value="objuser.LastName" /></td>
				</tr>
				<tr>
					<td>Gender: <s:property value="objuser.Gender" /></td>
				</tr>
				<tr>
					<td>Email: <s:property value="objuser.EmailId" /></td>
				</tr>
				<tr>
					<td>Date Of Birth: <s:property value="objuser.dob" /></td>
				</tr>
				<tr>
					<td>Address: <s:property value="objuser.Address" /></td>
				</tr>
				<tr>
					<td>User Name: <s:property value="objuser.userid" /></td>
				</tr>
				<tr>
					<td>Password: <s:property value="objuser.password" /></td>
				</tr>
				<tr>
					<td>Interest: <s:property value="objuser.areaofinterest" /></td>
				</tr>
				<tr>
					<td>Other Interest: <s:property value="objuser.otherinterest" /></td>
				</tr>
				<tr>
					<td>Category: <s:property value="objuser.category" /></td>
				</tr>
			</table>
		</s:form>
		<a
			href="Struts2/editaction.action?uname=<s:property value="objuser.userid"/>"
			class="btn btn-success">Edit</a>
	</div>
</body>
</html>