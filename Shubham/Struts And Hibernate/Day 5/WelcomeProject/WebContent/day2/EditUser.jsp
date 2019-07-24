<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- <link href="../day3/UserList.css" rel="stylesheet"> -->
<title>Edit User</title>
</head>
<body>
	<div class="container">
		<div class="Editdet">
			<div class="perdet">
				<h3>Personal Details</h3>
			</div>
			<s:form action="updateaction" method="post">
				<table class="table">
					<tr>
						<td><label>Salutation : </label></td>
						<td><select name="listbean.salutation">
								<option value="Mr" <s:if test= 'listbean.salutation == "Mr"'>selected</s:if> >Mr.</option>
								<option value="Miss"  <s:if test= 'listbean.salutation == "Miss"'>selected</s:if>>Miss</option>
								<option value="Mrs"  <s:if test= 'listbean.salutation == "Mrs"'>selected</s:if>>Mrs.</option>
						</select></td>
					</tr>

					<tr>
						<td><label for="fname">FirstName : </label><span>*</span></td>
						<td><input type="text" name="listbean.FirstName" id="fname"
							maxlength="50" required
							value="<s:property value="listbean.FirstName"/>" /></td>
					</tr>
					<tr>
						<td><label for="middle">Middle Initial : </label></td>
						<td><input type="text" name="listbean.MiddleName" id="middle"
							maxlength="1" value="<s:property value="listbean.MiddleName"/>" /></td>
					</tr>
					<tr>
						<td><label for="lname">LastName : </label><span>*</span></td>
						<td><input type="text" name="listbean.LastName" id="lname"
							maxlength="50" required
							value="<s:property value="listbean.LastName"/>" /></td>
					</tr>
					<tr>
						<td><label for="sex">Sex : </label><span>*</span></td>
						<td><input type="radio" name="listbean.Gender" id="sex"
							required value="male"
							<s:if test='listbean.Gender == "male"'>checked</s:if> />male <input
							type="radio" name="listbean.Gender" id="sex" required
							value="female"
							<s:if test='listbean.Gender == "female"'>checked</s:if> />female</td>
					</tr>
					<tr>
						<td><label for="email">Email Id : </label></td>
						<td><input type="email" name="listbean.EmailId" id="email"
							maxlength="50" value="<s:property value="listbean.EmailId"/>" /></td>
					</tr>
					<tr>
						<td><label for="birth">Birth Date : </label><span>*</span></td>
						<td><input type="date" name="listbean.birth" id="birth"
							required value="<s:property value="listbean.birth"/>" /></td>
					</tr>
					<tr>
						<td><label for="add">Address : </label></td>
						<td><textarea maxlength="100" cols=21 rows=3
								name="listbean.Address"><s:property
									value="listbean.Address" /></textarea></td>
					</tr>
					<tr>
						<td><label for="uname">UserName : </label><span>*</span></td>
						<td><input type="text" name="listbean.uname" id="uname"
							maxlength="50" required
							value="<s:property value="listbean.uname"/>" /></td>
					</tr>
					<tr>
						<td><label for="pass">Password : </label><span>*</span></td>
						<td><input type="password" name="listbean.pass" id="pass"
							maxlength="50" required placeholder="Enter your password" /></td>
					</tr>
					<tr>
						<td><label>Category : </label></td>
						<td><select name="listbean.category">
								<option value="user"  <s:if test= 'listbean.category == "user"'>selected</s:if> >User</option>
								<option value="admin"   <s:if test= 'listbean.category == "admin"'>selected</s:if> >Admin</option>
						</select></td>
					</tr>

				</table>
				<table>
					<tr>
						<td><h3>
								Areas of Interest<span>*</span>
							</h3></td>
					</tr>

					<!-- Strat of the check box tr -->
					<tr>
						<td>
							<%
								boolean bool_b1 = true, bool_b2 = true, bool_b3 = true, bool_b4 = true;
							%>
							<s:set var="bool_b1"><%=bool_b1%></s:set> <s:set var="bool_b2"><%=bool_b2%></s:set>
							<s:set var="bool_b3"><%=bool_b3%></s:set> <s:set var="bool_b4"><%=bool_b4%></s:set>
							<s:iterator value="listbean.arrList" status="itstatus"
								var="status">
								<%-- <li><s:property />${status}</li> --%>

								<s:if test="#status == 'web' && #bool_b1 == 'true'">
									<input type="checkbox" name="listbean.interest" id="interest" value="web"
										<s:if test= "#status == 'web'">checked</s:if>> Web Programming <br>
									<s:set var="bool_b1" value="false" />
								</s:if>
								<s:if test="#status == 'database' && #bool_b2 == 'true'">
									<input type="checkbox" name="listbean.interest" id="interest" value="database"
										<s:if test= "#status == 'database'">checked</s:if>> Database Programming <br>
									<s:set var="bool_b2" value="false" />
								</s:if>
								<s:if test="#status == 'swing' && #bool_b3 == 'true'">
									<input type="checkbox" name="listbean.interest" id="interest" value="swing"
										<s:if test= "#status == 'swing'">checked</s:if>> Swing Programming <br>
									<s:set var="bool_b3" value="false" />
								</s:if>
								<s:if test="#status == 'mobile' && #bool_b4 == 'true'">
									<input type="checkbox" name="listbean.interest" id="interest" value="mobile"
										<s:if test= "#status == 'mobile'">checked</s:if>> Mobile Programming <br>
									<s:set var="bool_b4" value="false" />
								</s:if>
							</s:iterator> <!-- Remaning checkbox prints here --> <s:if
								test="#bool_b1 == 'true'">
								<input type="checkbox" name="listbean.interest" id="interest" value="web"> Web Programming <br>
							</s:if> <s:if test="#bool_b2 == 'true'">
								<input type="checkbox" name="listbean.interest" id="interest" value="database"> Database Programming <br>
							</s:if> <s:if test="#bool_b3 == 'true'">
								<input type="checkbox" name="listbean.interest" id="interest" value="swing"> Swing Programming <br>
							</s:if> <s:if test="#bool_b4 == 'true'">
								<input type="checkbox" name="listbean.interest" id="interest" value="mobile"> Mobile Programming <br>
							</s:if>
						</td>
					</tr>
					<!-- End of the check box tr -->
					<tr>
						<td><textarea cols=21 rows=3 name="listbean.othintrest"
								id="othinterest"><s:property
									value="listbean.othintrest" /></textarea></td>
					</tr>
				</table>
				<input type='submit' class="btn btn-success" name="update"
					value="update" />
				<!-- <input type='reset' class="btn btn-success" name="clear"
					value="clear" /> -->
			</s:form>
			<div>
				<p id="demo"></p>
			</div>
		</div>
	</div>

</body>
</html>