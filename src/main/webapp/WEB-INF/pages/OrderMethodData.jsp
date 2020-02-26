<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="green">
<c:choose>
<c:when test="${!empty list}">
<table border="2">
<tr>
<td>OrderID</td>
<td>OrderType</td>
<td>ORDER CODE</td>
<td>ORDER METHOD</td>
<td>ORDER ACCEPT</td>
<td>ORDER DESCRIPTION</td>
<td colspan="2">OPERTION</td>
</tr>
<c:forEach items="${list}" var="ob">
<tr>
<td>${ob.ordId}</td>
<td>${ob.ordCode}</td>
<td>${ob.ordType}</td>
<td>${ob.ordMethod}</td>
<td>${ob.ordAccept}</td>
<td>${ob.ordDesc}</td>

<td><a href="delete?oid=${ob.ordId}">delete</a></td>
<td><a href="edit?oid=${ob.ordId}">EDIT</a></td>
</tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>NO DATA FOUND</c:otherwise>
</c:choose>

</body>
</html>