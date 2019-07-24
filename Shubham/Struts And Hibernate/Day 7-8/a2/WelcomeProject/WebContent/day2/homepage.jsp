<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>Homepage</title>
<script>
	function userInfo() {
		//alert(getElementById("clear"));
		window.location.href = "/WelcomeProject/day2/Userlist.jsp";
	}
	function userDetails() {
		//alert(getElementById("clear"));
		window.location.href = "/WelcomeProject/day2/success.jsp";
	}
	function fileUpload() {
		//alert(getElementById("clear"));
		window.location.href = "/WelcomeProject/day4/upload.jsp";
	}
</script>
</head>
<body>
	<h3>
		<a href="/WelcomeProject/day2/Userlist.jsp"><s:property value="getText('user.USERLIST')" /></a>
	</h3>
	<%-- <h3>
		<a href="/WelcomeProject/day2/details.jsp"><s:property value="getText('user.USERINFO')" /></a>
	</h3> --%>
	<h3>
		<a href="/WelcomeProject/day4/upload.jsp"><s:property value="getText('user.FILEUPLOAD')" /></a>
	</h3>
	<%-- <h3>
		<s:submit value="userInfo" align="left" onclick="userInfo();" />
	</h3> --%>

	<%-- <s:form action="userDetails" method="post" namespace="/">
		<h3>
			<s:submit value="userDetails" align="left" onclick="userDetails();" />
		</h3>
	</s:form> --%>

	<%-- <h3>
		<s:submit value="fileUpload" align="left" onclick="fileUpload();" />
	</h3> --%>
</body>
</html>