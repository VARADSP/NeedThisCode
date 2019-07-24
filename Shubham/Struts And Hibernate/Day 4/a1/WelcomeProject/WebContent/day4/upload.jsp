<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload File</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script>
	function clearErrorMessage() {
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
<body class="main">
	<div class="content">
		<h1>File Upload with Struts 2</h1>
		<s:form action="uploadFile" enctype="multipart/form-data"
			method="post" namespace="/" theme="simple">
			<div class="content">
				<br />
				<s:file name="fileUpload" class="file"
					label="Select a file to upload" size="30"></s:file>
				<br />
			</div>
			<%-- <s:submit class="file" value="Upload" /> --%>
			<div class="content">
				<button class="btn btn-default" type="submit">File Upload</button>
				<button class="btn btn-default" type="reset"
					onclick="clearErrorMessage();">Clear</button>
			</div>
		</s:form>
		<span style="color: red"><s:actionerror id="clear" /></span> <span
			style="color: red"><s:actionmessage /></span>
	</div>
</body>
</html>