<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="UserDetailsB.css">
<script src="../UserDetailsB.js"></script>
</head>
<body>
	<div class="main">
		<div class="perdet">
			<h2>Personal Details</h2>
		</div>
		<form action="../UserDetailsB" method="post"
			onsubmit="return success()">
			<table>
				<tr>
					<td>Salutation</td>
					<td><select id="sal" name="sal" onchange="gender()">
							<option value="MR">Mr</option>
							<option value="Ms">Ms</option>
					</select></td>
				</tr>
				<tr>
					<td><label for="firstname">First Name:</label><span>*</span></td>
					<td><input type="text" name="firstname" id="firstname"
						maxlength=50 required placeholder="Enter first name" /></td>
				</tr>
				<tr>
					<td><label for="middlename">Middle Name:</label></td>
					<td><input type="text" name="middlename" id="middlename"
						maxlength=50 placeholder="Enter middle name" /></td>
				</tr>
				<tr>
					<td><label for="lastname">Last Name:</label><span>*</span></td>
					<td><input type="text" name="lastname" id="lastname"
						maxlength=50 required placeholder="Enter last name" /></td>
				</tr>
				<tr>
					<td><label for="gender">Sex</label><span>*</span></td>
					<td><input type="radio" name="gender" value="female"
						id="female" required>Female <input type="radio"
						name="gender" value="male" id="male" required>Male</td>
				</tr>
				<tr>
					<td><label for="emailid">Email ID:</label></td>
					<td><input type="email" name="emailid" id="emailid"
						maxlength=50 placeholder="e.g. abc@xyz.com" /></td>
				</tr>
				<tr>
					<td><label for="date">DOB :</label><span>*</span></td>
					<td><input type="date" id="date" name="dob" required></td>
				</tr>
				<tr>
					<td><label for="Address">Address</label></td>
					<td><textarea name="Address" maxlength=100 cols=25 rows=3></textarea></td>
				</tr>
				<tr>
					<td><label for="uname">UserName : </label><span>*</span></td>
					<td><input type="text" name="uname" id="uname" maxlength="50"
						required placeholder="Enter your user name" /></td>
				</tr>
				<tr>
					<td><label for="pass">Password : </label><span>*</span></td>
					<td><input type="password" name="pass" id="pass"
						maxlength="50" required placeholder="Enter your password" /></td>
				</tr>
				<tr>
					<th><h2>
							Areas of Interest<span>*</span>
						</h2></th>
				</tr>
				<tr>
					<td><input type="checkbox" name="interest" id="interest"
						value="web"> Web Programming <br></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="interest" id="interest"
						value="database"> Database Programming <br></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="interest" id="interest"
						value="swing"> Swing Programming <br></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="interest" id="interest"
						value="mobile"> Mobile Programming <br></td>
				</tr>
				<tr>
					<td><label for="interest"></label>
						<h4>Other Interest</h4></td>
				</tr>
				<tr>
					<td><textarea name="othinterest" id="othinterest"
							maxlength=100 cols=30 rows=3></textarea></td>
				</tr>
			</table>
			<p class="btnSize">
				<button type="submit" name="submit">Submit</button>
				<button type="reset" name="clear">Clear</button>
			</p>
		</form>
		<div>
			<p id="test"></p>
		</div>
	</div>
</body>
</html>