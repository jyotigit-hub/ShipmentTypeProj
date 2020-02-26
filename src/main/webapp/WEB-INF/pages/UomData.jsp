<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> UOM ALL DATA </h1>
<c:choose>
<c:when test="${!empty list}">
<table border="2">
<tr>
<td>UomID</td>
<td>Uom Type</td>
<td>Uom Model</td>
<td>Uom Description</td>
<td>DELETE</td>
</tr>
<c:forEach items="${list}" var="ob">
<tr>
<td>${ob.uomID}</td>
<td>${ob.uomType}</td>
<td>${ob.uomModel}</td>
<td>${ob.uomdescription}</td>
<td><a href="delete?uid=${ob.uomID}">delete</a></td>
</tr>
</c:forEach>
   ${msg}
</table>
</c:when>
<c:otherwise>NO RECORD FOUND SORRY BOSS</c:otherwise>
</c:choose>
</body>
</html>