 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <!DOCTYPE HTML>
<html>
<head>
<title>Add Product Form</title>
<%--    <style type="text/css">    @import url(/css/main.css);</style>--%>
    <link rel="stylesheet" type="text/css" href="<spring:url value="/css/main.css"/>">

</head>
<body>

<div id="global">
<form:form modelAttribute="products" action="/product" method="post">
    <fieldset>
        <legend>Add a product</legend>
        <p>
            <label for="category"><spring:message code="field.category"/> </label>
<%-- 		 	<select name="category.id">--%>
<%--		    	<option value="-">  --Select Category-- </option>--%>
<%--		--%>
<%--		  		<c:forEach var="category" items="${categories}">--%>
<%--		    		<option value="${category.id}"> ${category.name}</option>--%>
<%--				</c:forEach>--%>
<%--		    </select>--%>
            <form:select id="category" path="category.id">
                <form:option value="0" label="--Select Category"/>
                <form:options items="${categories}" itemLabel="name" itemValue= "id"/>
            </form:select>
        </p>
         
        <p>
            <label for="name"><spring:message code="field.name"/> </label>
            <input type="text" id="name" name="name" 
                tabindex="1">
        </p>
        <p>
            <label for="description"><spring:message code="field.description"/> </label>
            <input type="text" id="description" value= "${product.description}"
                name="description" tabindex="2">
        </p>
        <p>
            <label for="price"><spring:message code="field.price"/></label>
            <input type="text" id="price" name="price" 
                tabindex="3">
        </p>
        <p id="buttons">
            <input id="reset" type="reset" tabindex="4">
            <input id="submit" type="submit" tabindex="5" 
                value="Add Product">
        </p>
    </fieldset>
</form:form>
</div>
</body>
</html>
