<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>Register</title>
<script src="Register.js"></script>
</head>
<body>
	<div class="main container">
		<div class="perdet">
			<h3>Personal Details</h3>
		</div>
		<s:form action="registeraction" method="post"
			onsubmit="return success()">
			<table class="table">
				<tr>
					<td><label>Salutation : </label></td>
					<td><select name="listbean.salutation">
							<option value="Mr">Mr.</option>
							<option value="Miss">Miss</option>
							<option value="Mrs">Mrs.</option>
					</select></td>
				</tr>

				<tr>
					<td><label for="fname">FirstName : </label><span>*</span></td>
					<td><input type="text" name="listbean.FirstName"
						id="FirstName" maxlength="50" required /></td>
				</tr>
				<tr>
					<td><label for="middle">Middle Initial : </label></td>
					<td><input type="text" name="listbean.MiddleName"
						id="MiddleName" maxlength="1" /></td>
				</tr>
				<tr>
					<td><label for="lname">LastName : </label><span>*</span></td>
					<td><input type="text" name="listbean.LastName" id="LastName"
						maxlength="50" required /></td>
				</tr>
				<tr>
					<td><label for="sex">Sex : </label><span>*</span></td>
					<td><input type="radio" name="listbean.Gender" id="Gender"
						value="male" />male <input type="radio" name="listbean.Gender"
						id="Gender" required value="female" checked />female</td>
				</tr>
				<tr>
					<td><label for="email">Email Id : </label></td>
					<td><input type="email" name="listbean.EmailId" id="EmailId"
						maxlength="50" /></td>
				</tr>
				<tr>
					<td><label for="birth">Birth Date : </label><span>*</span></td>
					<td><input type="date" name="listbean.birth" id="birth"
						required /></td>
				</tr>
				<tr>
					<td><label for="add">Address : </label></td>
					<td><textarea maxlength="100" cols=21 rows=3
							name="listbean.Address"></textarea></td>
				</tr>
				<tr>
					<td><label for="uname">UserName : </label><span>*</span></td>
					<td><input type="text" name="listbean.uname" id="uname"
						maxlength="50" required /></td>
				</tr>
				<tr>
					<td><label for="pass">Password : </label><span>*</span></td>
					<td><input type="password" name="listbean.pass" id="pass"
						maxlength="50" required placeholder="Enter your password" /></td>
				</tr>
				<tr>
					<td><label>Category : </label></td>
					<td><select name="listbean.category">
							<option value="user">User</option>
							<option value="admin">Admin</option>
					</select></td>
				</tr>
			</table>
			<table>
				<tr>
					<td><h3>
							Areas of Interest<span>*</span>
						</h3></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="listbean.interest"
						id="interest" value="web"> Web Programming <br></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="listbean.interest"
						id="interest" value="database"> Database Programming <br></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="listbean.interest"
						id="interest" value="swing"> Swing Programming <br></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="listbean.interest"
						id="interest" value="mobile">Mobile Programming <br></td>
				</tr>
				<tr>
					<td><h4>Other Interest:</h4></td>
				</tr>
				<tr>
					<td><textarea cols=21 rows=3 name="listbean.othintrest"
							id="othintrest"></textarea></td>
				</tr>
			</table>
			<input type='submit' class="btn btn-success" name="submit"
				value="Register" />
			<input type='reset' class="btn btn-success" name="clear"
				value="Clear" />
				<br/><br/><br/><br/>
		</s:form>
	</div>
</body>
</html>