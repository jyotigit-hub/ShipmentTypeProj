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
<a href="excel"> ExcelFormat</a>
<a href="pdf"> pdfFormat</a>
<c:choose>
<c:when test="${!empty list}">
<table style="color: red;" border=2>
<tr><td>shipId</td>
<td>shipMode</td>
<td>shipCode</td>
<td>enbShip</td>
<td>shipGrade</td>
<td>shipDesc</td>
<td colspan="3">shipmentOpertion</td></tr>
<c:forEach items="${list}" var="ob">
<tr>
<td>${ob.shipId}</td>
<td>${ob.shipMode}</td>
<td>${ob.shipCode}</td>
<td>${ob.enbShip}</td>
<td>${ob.shipGrade}</td>
<td>${ob.shipDesc}</td>
<td><a href="delete?sid=${ob.shipId}">Delete</a></td>
<td><a href="edit?sid=${ob.shipId}">Edit</a></td>
<td><a href="view?sid=${ob.shipId}">VIEW</a></td>
</tr>
</c:forEach>
</table>
 ${msg}
</c:when>
<c:otherwise> No Data Found</c:otherwise>
</c:choose>
</body>
</html>