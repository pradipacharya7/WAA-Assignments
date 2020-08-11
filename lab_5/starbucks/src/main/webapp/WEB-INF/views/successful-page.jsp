<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pradi
  Date: 6/23/2020
  Time: 8:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="<c:url value="/logout" />">Logout</a>
<h2>Login Successful</h2>
    <form action="/advice" method="get">
        <input type="submit" value="Back">
    </form>
</body>
</html>
