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
<form action="/advice" method="get">

    <c:set var="count" value="0"/>
    <table>
        <c:forEach items="${advices}" var="advice" >
            <c:choose>
            <c:when test="${count%2==0}">
                <tr style="background: cyan;">
                    <td>${advice}</td>
                </tr>
            </c:when>
                <c:otherwise>
                    <tr style="background: yellow;">
                        <td>${advice}</td>
                    </tr>
                </c:otherwise>
            </c:choose>
            <c:set var="count" value="${count +1}"/>
        </c:forEach>
    </table>
<input type="submit" value="Back">
</form>
</body>
</html>
