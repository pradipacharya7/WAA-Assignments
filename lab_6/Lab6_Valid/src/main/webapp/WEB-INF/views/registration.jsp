<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>

<h1>Registration Form</h1><br />

<form:form modelAttribute="student" action="/registration" method="post">
    <span style="display: block;">
    <form:errors path="*" cssStyle="color : red;" />
</span>
    <label> ID  </label>
    <form:input  path="id" id="firstname"/><br>
    <span style="display: block;">
    <form:errors path="id" cssStyle="color: red;"></form:errors>
    </span>
    <label> Firstname  </label>
    <form:input  path="firstName" id="firstname"/><br>
    <span style="display: block;">
    <form:errors path="firstName" cssStyle="color: red;"></form:errors>
    </span>
    <label> Lastname  </label>
    <form:input  path="lastName"/><br>
    <span style="display: block;">
    <form:errors path="lastName" cssStyle="color: red;"></form:errors>
    </span>
    <label> email  </label>
    <form:input  path="email"/><br>
    <span style="display: block;">
    <form:errors path="email" cssStyle="color: red;"></form:errors>
    </span>
    <label> Gender  </label>
    <input type="checkbox" name="gender">Male<input type="checkbox" name="gender">Female<br>
    <label>DOB</label>
    <form:input  path="birthday"/><br>
    <span style="display: block;">
    <form:errors path="birthday" cssStyle="color: red;"></form:errors>
    </span>
    <label> Phone </label><br>
    <label> Phone Area </label>
<form:input  path="phone.area"/>
    <span style="display: block;">
    <form:errors path="phone.area" cssStyle="color: red;"></form:errors>
    </span>
    <label> Phone Prefix </label>
<form:input  path="phone.prefix"/>
    <span style="display: block;">
    <form:errors path="phone.prefix" cssStyle="color: red;"></form:errors>
    </span>
    <label> Phone Number </label>
<form:input  path="phone.number"/>
    <span style="display: block;">
    <form:errors path="phone.number" cssStyle="color: red;"></form:errors>
    </span>
    <input type="submit" value="register">
</form:form>
</body>
</html>