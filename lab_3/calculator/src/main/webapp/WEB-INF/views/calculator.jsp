<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pradi
  Date: 6/22/2020
  Time: 3:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/calculator" method="post">
    <input type = "text" name = "add1" size = "2"  value = "${calc.add1}" />+
    <input type = "text" name = "add2" value = "${calc.add2}" size = "2"/>=<input type = "text" name = "sum" value = ""  size = "2" readonly/><br/>
    <input type = "text" name = "mult1" value = "${calc.mult1}" size = "2"/>*
    <input type = "text" name = "mult2" value = "${calc.mult2}"  size = "2"/>=<input type = "text" name = "product" value = ""   size = "2" readonly/><br/>
    <input type = "submit" value = "Submit"/>
    <span id="errMessage" style="color: red; display: block"><c:forEach items="${errors}" var="error">${error}<br></c:forEach></span>

</form>
</body>
</html>
