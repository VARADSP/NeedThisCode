<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
				<s:textfield name="objuser.userid" placeholder="Enter Username"
					class="form-control" />
			</div>
			<br />
			<div>
				<s:label>Enter Password</s:label>
				<s:password name="objuser.password" placeholder="Enter Password"
					class="form-control" />
			</div>
			<br />
			<input type="submit" class="btn btn-success" />
			<input type="reset" class="btn btn-success"
				onclick="clearErrorMessage();" />
		</s:form>

		<s:if test="hasActionErrors()">
			<div class="errors">
				<span style="color: red"><s:actionerror id="clear" /></span> <span
					style="color: red"><s:actionmessage /></span>
			</div>
		</s:if>
	</div>
</body>
</html>