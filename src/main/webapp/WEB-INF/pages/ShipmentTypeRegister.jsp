<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="yellow" style="color: blue;text-align: center">
<h3>Welcome To ShipmentType Register Page</h3>

<pre>
<form:form action="save" method="post" modelAttribute="shipmentType">
ShipmentMode:::
<form:select path="shipMode">
<form:option value="">---select----</form:option>
<form:option value="AIR">AIR</form:option>
<form:option value="Truck">Truck</form:option>
<form:option value="SHIP">SHIP</form:option>
<form:option value="TRAIN">TRAIN</form:option>
</form:select>
ShipmentCode::
<form:input path="shipCode"/>
ShipmentEnable::
<form:select path="enbShip">

<form:option value="">--select---</form:option>
<form:option value="YES">YES</form:option>
<form:option value="NO">NO</form:option>
</form:select>
ShipmentGrade::
<form:radiobutton path="shipGrade" value="A"/>A
<form:radiobutton path="shipGrade" value="B"/>B
<form:radiobutton path="shipGrade" value="C"/>c
ShipmentDescription::
<form:textarea path="shipDesc"/>
<input type="submit" value="Register">
</form:form>
${msg}          

</pre>
</body>
</html>