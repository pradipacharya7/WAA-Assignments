<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pradi
  Date: 6/23/2020
  Time: 7:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Ask for advice about your favorite roast:</h2>
<p />
<form action = "/advice" method="post">
    <select name="roast" <c:if test="${user==null}"> disabled="disabled"</c:if>>
        <option value="-">--Choose Roast--</option>
        <option value="dark">Dark</option>
        <option value="medium">Medium</option>
        <option value="light">Light</option>
    </select>
    <br/><br/>
    <input type="submit" value = "Submit" <c:if test="${user==null}"> disabled="disabled"</c:if> />
</form>
<div id='advice'>

</div>
<p />
Login:
<form action = "/" method = "post">
    Name: <input type = "text" name = "name" size = "9" <c:if test="${user!=null}"> disabled="disabled"</c:if>/><br/>
    Password: <input type = "password" name = "password" size = "9" <c:if test="${user!=null}"> disabled="disabled"</c:if> /><br/>
    <br/>
    <input type="submit" value = "Log In" <c:if test="${user!=null}"> disabled="disabled"</c:if>/>
</form>
</body>
</html>
