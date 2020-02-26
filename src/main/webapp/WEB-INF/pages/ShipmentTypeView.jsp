<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="yellow" style="text-align: center;" >
<a href="excel?id=${ob.shipId}">Excel format</a>
<a href="pdf?id=${ob.shipId}">PDF format</a>
<h1>SHOW ONE ONE RECORD</h1>
<table border="2">
<tr>
<th>ID</th><td >${ob.shipId}</td>
</tr>
<tr>
<th>MODE</th><td>${ob.shipMode}</td>
</tr>
<tr>
<th>CODE</th><td>${ob.shipCode}</td>
</tr>
<tr>
<th>ENBALE SHIP</th><td>${ob.enbShip}</td>
</tr>
<tr>
<th>SHIPMENT GRAD</th><td>${ob.shipGrade}</td>
</tr>
<tr>
<th>SHIPMENT NOTE</th><td>${ob.shipDesc}</td>
</tr>

</table>
</body>
</html>