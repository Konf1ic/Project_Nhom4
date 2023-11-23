<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chung
  Date: 14/11/2023
  Time: 8:26 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
        }

        h2 {
            text-align: center;
        }

    </style>
</head>
<body>
<a href="/adminHome.jsp">
    <button type="submit">Back</button>

</a>

<h2>Admin Search</h2>
<form action="/user?action=search" method="post">
    <input type="text" placeholder="Search by names.." name="username">
    <button type="submit">Search</button>
</form>
<c:if test="${not empty list}">

    <table border="1">
        <tr class="header">
            <td style="width:25%;">UserName</td>
            <td style="width:25%;">Password</td>
            <td style="width:25%;">Email</td>
            <td style="width:25%;">Age</td>
            <td style="width:25%;">Phone_number</td>
            <td style="width:25%;">Address</td>
            <td style="width:25%;">Salary</td>
            <td style="width:25%;">Role</td>
        </tr>
        <c:forEach var="account" items="${list}">
            <tr>
                <td>${account.username}</td>
                <td>${account.password}</td>
                <td>${account.email}</td>
                <td>${account.age}</td>
                <td>${account.phone_number}</td>
                <td>${account.address}</td>
                <td>${account.wage}</td>
                <td>${account.position}</td>
            </tr>
        </c:forEach>
        </tr>
    </table>
</c:if>
</body>
</html>
