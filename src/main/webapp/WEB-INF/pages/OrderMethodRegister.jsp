<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="green" style="text-align: center;color: red">
<form:form action="save" method="POST" modelAttribute="orderMethod">
<pre>
                 <h1> ORDER METHOD</h1>
Order Type::<form:radiobutton  path="ordType"  value="SALE"/>SALE
            <form:radiobutton  path="ordType"  value="PURCHES"/>PURCHES
OrderCode:::<form:input path="ordCode"/>
OrderMethod:<form:select path="ordMethod">
            <form:option value=" ">--select----</form:option>
            <form:option value="FIFO">FIFO</form:option>
            <form:option value="LIFO">LIFO</form:option>
            <form:option value="FCFO">FCFO</form:option>
            <form:option value="FEFO">FEFO</form:option>
           </form:select>
OrderAccept<form:checkbox path="ordAccept" value="Multi-Model"/>Multi-Model
           <form:checkbox path="ordAccept" value="Accept-Return"/> Accept-Return 
Description<form:textarea path="ordDesc"/>
                                               <input type="submit" value="CreateOrderMethod">                                 
  </pre>          
</form:form>
</body>
</html>