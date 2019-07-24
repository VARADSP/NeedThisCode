<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="fileupload.css" />
</head>
<body class="container main">
	<h3>Select File to Upload</h3>
	<form action="../FileUpload" method="post"
		enctype="multipart/form-data">
		<input type="file" class="file" name="file" id="file" /><br /> <input
			type="submit" class="btn btn-success" value="Upload" name="submit" />
		<button type="button" value="Reset" name="Reset"
			onclick="customReset();">Clear</button>
	</form>
</body>
<script>
	function customReset() {
		document.getElementById("file").value = "";
	}
</script>
</html>