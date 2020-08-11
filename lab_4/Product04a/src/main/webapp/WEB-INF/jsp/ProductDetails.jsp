<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
<head>
<title>Save Product</title>
<%--<style type="text/css">    @import url(/css/main.css);</style>--%>
    <link rel="stylesheet" type="text/css" href="<spring:url value="/css/main.css"/>">


</head>
<body>
<div id="global">
    <h4>The product has been saved.</h4>

        <h5>Details:</h5>
        Product Name: ${product.name}<br/>
        Category: ${product.category.name}<br/>
        Description: ${product.description}<br/>
        Price: $${product.price}
    
    <form action="listproducts" method="get">
           <input id="submit" type="submit"  
                value="List products">
	</form>
    
</div>
</body>
</html>