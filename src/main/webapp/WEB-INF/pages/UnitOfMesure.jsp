<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: yellow">
<pre></pre>
              <h1> Uom Register Page</h1>
<form:form action="save" method="POST" modelAttribute="shipmentType">
Uom Type ::<form:select path="uomType">
<form:option value="">---select---</form:option>
<form:option value="packing">packing</form:option>
<form:option value=""No Packing>No Packing</form:option>
<form:option value="NA">-----NA------</form:option>
</form:select></br>
Uom model  ::<form:input  path="uomModel"/>
Description::<form:textarea path="uomdescription"/>
<input type="submit" value="register">
  ${msg}
</form:form>
</pre>
</body>
</html>