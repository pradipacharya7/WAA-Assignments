<%--
  Created by IntelliJ IDEA.
  User: pradi
  Date: 6/22/2020
  Time: 3:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${greeting}</h1>
<form action="/calculator" method="post">
    <input type = "text" name = "add1" size = "2"  value = " ${calculator.add1}" />+
    <input type = "text" name = "add2" value = "${calculator.add2}" size = "2"/>=<input type = "text" name = "sum" value = "${sum}"  size = "2" readonly/><br/>
    <input type = "text" name = "mult1" value = "${calculator.mult1}" size = "2"/>*
    <input type = "text" name = "mult2" value = "${calculator.mult2}"  size = "2"/>=<input type = "text" name = "product" value = "${product}"   size = "2" readonly/><br/>
    <p><a href="/calculator">Back...</a></p>
    <span id="errMessage" style="color: red;">${errors}</span>

</form>
</body>
</html>
