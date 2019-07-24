<%@taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
	<h2 class="active">Login Page</h2>
	<s:form action="welcome" method="post" namespace="/">
		<s:textfield name="objbean.username" label="Username"
			placeholder="Enter Username" class="form-control" />
		<br />
		<s:textfield name="objbean.password" label="Password"
			placeholder="Enter Password" class="form-control" />
		<br />
		<s:submit class="btn btn-success" align="center"/>
	</s:form>
	<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>
	</s:if>
</body>
</html>