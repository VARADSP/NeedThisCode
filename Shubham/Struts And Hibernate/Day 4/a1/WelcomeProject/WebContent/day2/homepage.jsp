<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<title>Homepage</title>
<script>
	function userInfo() {
		//alert(getElementById("clear"));
		window.location.href = "/WelcomeProject/day1/welcomeUser.jsp";
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
<style>
.content {
	max-width: 500px;
	margin: auto;
}
</style>
</head>
<body>
	<div class="content">
		<h2>Please click on Operation Button</h2>
		<h3 align="center">
			<!-- <a href="/WelcomeProject/day1/welcomeUser.jsp">Welcome User</a> -->
			<button type="submit" onclick="userInfo();" class="btn btn-default">User Info</button>
			<%-- <s:submit value="userInfo" align="left" onclick="userInfo();" /> --%>
		</h3>

		<s:form action="userDetails" method="post" namespace="/">
			<h3 align="center">
				<button type="submit" onclick="userDetails();" class="btn btn-default">User Details</button>
				<%-- <s:submit value="userDetails" align="left" onclick="userDetails();" /> --%>
			</h3>
		</s:form>
			<h3 align="center">
				<!-- <input type="submit" name="fileUpload" onclick="fileUpload();" class="btn btn-success"> -->
				<button type="submit"  class="btn btn-default" onclick="fileUpload();">File Upload</button>
				<%-- <s:submit value="fileUpload" align="left" onclick="fileUpload();" /> --%>
			</h3>
	</div>
</body>
</html>