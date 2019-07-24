<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload File</title>
<script>
	function clearErrorMessage() {
		//alert(getElementById("clear"));
		window.location.href = "/WelcomeProject/day4/upload.jsp";
	}
</script>
</head>
<body class="main">
	<center>

		<h1>File Upload with Struts 2</h1>
		<s:form action="uploadFile" enctype="multipart/form-data"
			method="post">
			<s:file name="fileUpload" class="file" label="Select a file to upload" size="30" />
			<s:submit class="file" value="Upload" />
		</s:form>
		<br/>
		<s:submit value="clear" onclick="clearErrorMessage();"/>
	</center>

	<span style="color: red"><s:actionerror id="clear" /></span>
	<span style="color: red"><s:actionmessage /></span>
</body>
</html>