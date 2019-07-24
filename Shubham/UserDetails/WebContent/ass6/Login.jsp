<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>Login Page</title>
<link rel="stylesheet" href="/UserDetails/ass6/Login.css"></link>
<!-- <script src="Login.js"></script> -->
</head>
<body>
	<div class="main">
		<div class="perdet" align="center">
			<h2>Login Page</h2>
		</div>
		<form action="../EditUserDetails" method="post"
			onsubmit="return check()">
			<table>
				<tr>
					<td><label for="uname">UserName : </label><span>*</span></td>
					<td><input type="text" name="uname" id="uname" maxlength="50"
						required placeholder="Enter your username" /></td>
				</tr>
				<tr>
					<td><label for="pass">Password : </label><span>*</span></td>
					<td><input type="password" name="pass" id="pass"
						maxlength="50" required placeholder="Enter your password" /></td>
				</tr>
			</table>
			<p class="btnSize">
				<button type="submit" name="submit">Submit</button>
				<button type="reset" name="clear">Clear</button>
			</p>
		</form>
		<div>
			<div id="test">
				<%
					String str = (String) request.getSession().getAttribute("authentication");
					if (str != null) {
				%>

				<h5>Enter Valid username and password</h5>
				<%
					}
				%>
			</div>
		</div>
	</div>
</body>
</html>