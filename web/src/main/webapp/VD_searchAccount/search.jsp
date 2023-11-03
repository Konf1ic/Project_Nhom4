<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguyendeptraivkl
  Date: 31/10/2023
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<form action="/ecommerces?action=search" method="post">
  <input type="text" placeholder="Enter name..." name="username">
  <button type="submit">Search</button>
</form>


<c:if test="${not empty list}">
  <table border="1">
    <tr>
      <td>Username</td>
      <td>password</td>
      <td>email</td>
      <td>age</td>
      <td>phone_number</td>
      <td>address</td>
      <td>wage</td>
      <td>position</td>
    </tr>
    <c:forEach var="account" items="${list}">
      <tr>
        <td>${account.name}</td>
        <td>${account.password}</td>
        <td>${account.email}</td>
        <td>${account.age}</td>
        <td>${account.phone_number}</td>
        <td>${account.address}</td>
        <td>${account.wage}</td>
        <td>${account.position}</td>
      </tr>
    </c:forEach>
  </table>
</c:if>
</body>
</html>