<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguyendeptraivkl
  Date: 14/11/2023
  Time: 08:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Product </title>
</head>
<body>
<form action="/ecommerces?action=searchProduct" method="post">
    <input type="text" placeholder="Enter name...." name="name">
    <button type="submit">Search</button>
</form>
<c:if test="${not empty listProductSearch}">
    <table border="1">
        <tr>
            <td>Name</td>
            <td>Price</td>
            <td>Describes</td>
            <td>image</td>
            <td>Type</td>
            <td>Quantity</td>
        </tr>
        <c:forEach var="product" items="${listProductSearch}">
            <tr>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.describes}</td>
                <td>${product.image}</td>
                <td>${product.type}</td>
                <td>${product.quantity}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
