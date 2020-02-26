<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> Document Upload</h1>

<form action="upload" method="POST" enctype="multipart/form-data">
<pre>
id::<input type="text" name="fileId">
DOCS::<input type="file" name="fileob">
<input type="submit" value="Upload">
   ${msg}
</pre>
</form>

</body>
</html>