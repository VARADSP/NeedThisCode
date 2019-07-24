<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="style.css" />
<title>User Details</title>
</head>
<body>
	<div class="well user">
		<h1 style="color: #fff">User Details</h1>
		<table class="userdet table">
			<tr>
				<td>Salutation: <s:property value="listbean.salutation" /></td>
			</tr>
			<tr>
				<td>First Name: <s:property value="listbean.FirstName" /></td>
			</tr>
			<tr>
				<td>Middle Name: <s:property value="listbean.MiddleName" /></td>
			</tr>
			<tr>
				<td>Last Name: <s:property value="listbean.LastName" /></td>
			</tr>
			<tr>
				<td>Gender: <s:property value="listbean.Gender" /></td>
			</tr>
			<tr>
				<td>Email: <s:property value="listbean.EmailId" /></td>
			</tr>
			<tr>
				<td>Date Of Birth: <s:property value="listbean.birth" /></td>
			</tr>
			<tr>
				<td>Address: <s:property value="listbean.Address" /></td>
			</tr>
			<tr>
				<td>User Name: <s:property value="listbean.userid" /></td>
			</tr>
			<tr>
				<td>Password: <s:property value="listbean.password" /></td>
			</tr>
			<tr>
				<td>Interest: <s:property value="listbean.areaofinterest" /></td>
			</tr>
			<tr>
				<td>Other Interest: <s:property value="listbean.otherinterest" /></td>
			</tr>
			<tr>
				<td>Category: <s:property value="listbean.category" /></td>
			</tr>
		</table>
		<a
			href="Struts2/editaction.action?uname=<s:property value="listbean.userid"/>"
			class="btn btn-success">Edit</a>
	</div>
</body>
</html>