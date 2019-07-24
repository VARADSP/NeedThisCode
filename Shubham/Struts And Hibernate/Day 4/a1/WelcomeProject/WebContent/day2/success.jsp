<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.content {
  max-width: 500px;
  margin: auto;

}
</style>
<body>
	<div class="content">
		<%-- <s:form action="loginSuccess" method="post" namespace="/"> --%>
		<!-- <h1 style="color: #fff">Successfully Login</h1> -->

		<h3 align="right">
			<a href="logout">Logout</a>
		</h3>

		<h2>
			Hello
			<s:property value="objuser.uname" />
		</h2>
		<table>
			<tr><td>First Name:<s:property value="objuser.FirstName"/></td></tr>
			<tr><td>Middle Name:<s:property value="objuser.MiddleName"/></td></tr>
			<tr><td>Last Name:<s:property value="objuser.LastName"/></td></tr>
			<tr><td>Gender:<s:property value="objuser.Gender"/></td></tr>
			<tr><td>Email:<s:property value="objuser.EmailId"/></td></tr>
			<tr><td>Address:<s:property value="objuser.Address"/></td></tr>
		</table>

		<br/>
		<s:if test="objuser.category == 'admin'">
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
		</s:if>
		<%-- </s:form> --%>
	</div>
</body>
</html>