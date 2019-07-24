<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UserDetails Edit</title>
<link rel="stylesheet" href="Login.css" />
</head>
<body>
	<%
		String uname = (String) session.getAttribute("uname");
		if (uname != null) {
	%>
	<form action="../UpdateUserDetails" method="post" onsubmit="success()">
		<table class="table">
			<tr>
				<td><label>Salutation : </label></td>
				<td><select name="salutation">
						<option value="<%=session.getAttribute("salutation")%>"><%=session.getAttribute("salutation")%></option>
						<option value="Mr">Mr.</option>
						<option value="Miss">Miss</option>
						<option value="Mrs">Mrs.</option>
				</select></td>
			</tr>
			<tr>
				<td><label for="fname">FirstName : </label><span>*</span></td>
				<td><input type="text" name="fname" id="fname" maxlength="50"
					required value="<%=session.getAttribute("fname")%>" /></td>
			</tr>
			<tr>
				<td><label for="middle">Middle Name : </label></td>
				<td><input type="text" name="middle" id="middle" maxlength="50"
					value="<%=session.getAttribute("middle")%>" /></td>
			</tr>
			<tr>
				<td><label for="lname">LastName : </label><span>*</span></td>
				<td><input type="text" name="lname" id="lname" maxlength="50"
					required value="<%=session.getAttribute("lname")%>" /></td>
			</tr>
			<tr>
				<td><label for="sex">Gender : </label><span>*</span></td>
				<%
					String sex = session.getAttribute("sex").toString();
						if (sex.equalsIgnoreCase("male")) {
				%>
				<td><input type="radio" name="sex" id="sex" required checked
					value="male" />male <input type="radio" name="sex" id="sex"
					value="female" />female</td>
				<%
					} else {
				%>
				<td><input type="radio" name="sex" id="sex" checked
					value="male" />male <input type="radio" name="sex" id="sex"
					value="female" />female</td>
				<%
					}
				%>
			</tr>
			<tr>
				<td><label for="email">Email Id : </label></td>
				<td><input type="email" name="email" id="email" maxlength="50"
					value="<%=session.getAttribute("email")%>" /></td>
			</tr>
			<tr>
				<td><label for="birth">Birth Date : </label><span>*</span></td>
				<td><input type="date" name="birth" id="birth" required
					value="<%=session.getAttribute("birth")%>" /></td>
			</tr>
			<tr>
				<td><label for="add">Address : </label></td>
				<td><textarea maxlength="100" cols=21 rows=3 name="address"
						id="address"><%=session.getAttribute("address")%></textarea></td>
			</tr>
			<tr>
				<td><label for="uname">UserName : </label><span>*</span></td>
				<td><input type="text" name="uname" id="uname" maxlength="50"
					readonly required value="<%=session.getAttribute("uname")%>" /></td>
			</tr>
			<tr>
				<td><label for="pass">Password : </label><span>*</span></td>
				<td><input type="password" name="pass" id="pass" maxlength="50"
					required placeholder="Enter your password" /></td>
			</tr>
		</table>
		<table>
			<tr>
				<td><h3>
						Areas of Interest<span>*</span>
					</h3></td>
			</tr>
			<%
				String values = session.getAttribute("interest").toString();
					String[] str = values.split(",");
					boolean a = false, b = false, c = false, d = false;
					for (int i = 0; i < str.length; i++) {
			%>
			<tr>
				<%
					if (str[i].equalsIgnoreCase("Web")) {
								a = true;
				%>
				<td><input type="checkbox" name="interest" id="interest"
					checked value="web"> Web Programming <br></td>
				<%
					}
				%>
			</tr>
			<tr>
				<%
					if (str[i].equalsIgnoreCase("Database")) {
								b = true;
				%>
				<td><input type="checkbox" name="interest" id="interest"
					checked value="Database"> Database Programming <br></td>
				<%
					}
				%>
			</tr>
			<tr>
				<%
					if (str[i].equalsIgnoreCase("Swing")) {
								c = true;
				%>
				<td><input type="checkbox" name="interest" id="interest"
					checked value="Swing"> Swing Programming <br></td>
				<%
					}
				%>
			</tr>
			<tr>
				<%
					if (str[i].equalsIgnoreCase("mobile")) {
								d = true;
				%>
				<td><input type="checkbox" name="interest" id="interest"
					checked value="mobile">Mobile Programming <br></td>
				<%
					}
				%>
			</tr>
			<%
				}
			%>
			<tr>
				<%
					if (a == false) {
				%>
				<td><input type="checkbox" name="interest" id="interest"
					value="web"> Web Programming <br></td>
				<%
					}
				%>
			</tr>
			<tr>
				<%
					if (b == false) {
				%>
				<td><input type="checkbox" name="interest" id="interest"
					value="Database"> Database Programming <br></td>
				<%
					}
				%>
			</tr>
			<tr>
				<%
					if (c == false) {
				%>
				<td><input type="checkbox" name="interest" id="interest"
					value="Swing"> Swing Programming <br></td>
				<%
					}
				%>
			</tr>
			<tr>
				<%
					if (d == false) {
				%>
				<td><input type="checkbox" name="interest" id="interest"
					value="mobile">Mobile Programming <br></td>
				<%
					}
				%>
			</tr>

			<tr>
				<td><h4>Other Interest:</h4></td>
			</tr>
			<tr>
				<td><textarea cols=21 rows=3 name="othinterest"
						id="othinterest"><%=session.getAttribute("othinterest")%></textarea></td>
			</tr>
		</table>
		<button type="submit" name="submit">Submit</button>
		<button type="button" name="clear" value="reset"
			onclick="customReset();">Clear</button>
	</form>
	<%
		} else {
			//out.print("Please login first");
			request.getRequestDispatcher("/ass6/Login.jsp").include(request, response);
		}
	%>
</body>

<script>
	function customReset() {
		document.getElementById("fname").value = "";
		document.getElementById("middle").value = "";
		document.getElementById("lname").value = "";
		document.getElementById("email").value = "";
		document.getElementById("birth").value = "";
		document.getElementById("address").value = "";
		document.getElementById("uname").value = "";
		document.getElementById("pass").value = "";
		document.getElementById("othinterest").value = "";
		document.getElementById("interest").checked = false;
		document.getElementById("sex").checked = false;
	}
</script>
</html>