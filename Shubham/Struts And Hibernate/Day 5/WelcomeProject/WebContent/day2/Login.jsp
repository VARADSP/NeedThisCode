<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/struts-bootstrap-tags" prefix="sb"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>Login Page</title>
<link type="stylesheet" href="Login.css">
<script>
	function clearErrorMessage() {
		//alert(getElementById("clear"));
		window.location.href = "/WelcomeProject/day2/Login.jsp";
	}
</script>
<style>
.content {
  max-width: 500px;
  margin: auto;
}
</style>
</head>
<body>
	<div class="content">
	<h2 class="active">Login Page</h2>
	<s:form action="login" method="post" namespace="/" theme="simple">
		<div>
			<s:label>Enter Username</s:label>
			<s:textfield name="objbean.username"
				placeholder="Enter Username" class="form-control" />
		</div>
		<br/>
		<div>
			<s:label>Enter Password</s:label>
			<s:password  name="objbean.password"
			placeholder="Enter Password" class="form-control" />
		</div>
		<br />
		<input type="submit" class="btn btn-success"/>
		<input type="reset" class="btn btn-success" onclick="clearErrorMessage();" />
		<%-- <s:submit class="btn btn-success" />
		<s:reset value="Reset" onclick="clearErrorMessage();" /> --%>

	<%--
		<s:textfield name="objbean.username" label="Username"
			placeholder="Enter Username" />
		<br />
		<s:textfield name="objbean.password" label="Password"
			placeholder="Enter Password" />
		<s:submit class="btn btn-success" align="center" /> --%>

	</s:form>

	<%-- <div
		style="position: absolute; bottom: 10px; left: 30px; top: 139px; z-index: 100;">
		<s:submit value="clear" align="left" onclick="clearErrorMessage();" />
	</div> --%>
	<s:if test="hasActionErrors()">
		<div class="errors">
			<span style="color: red"><s:actionerror id="clear" /></span> <span
				style="color: red"><s:actionmessage /></span>
		</div>
	</s:if>
	</div>
</body>
</html>