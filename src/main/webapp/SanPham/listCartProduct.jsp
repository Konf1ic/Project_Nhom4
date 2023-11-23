<%--
  Created by IntelliJ IDEA.
  User: chung
  Date: 21/11/2023
  Time: 1:27 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/user?action=null">
    <button type="submit">Back</button>
</a>

<c:forEach var="list" items="${list}">
    <div id="chung">
        <div id="chung1">
            <div>
                <input type="hidden" name="id" value="${list.id}"/>
            </div>
            <div id="chung2">
                <img src="${list.image}" height="358" width="300" alt="">
            </div>
            <div><h3>${list.name}</h3></div>

            <div><p>${list.price}</p></div>
            <div><p>${list.describes}</p></div>
            <div><p>${list.type}</p></div>
            <div><p>${list.quantity}</p></div>

            <form action="/user" method="post">
                <input type="hidden" value="deleteCart" name="action">
                <input type="hidden" value="${list.id}" name="id">
                <input type="submit" value="delete">
            </form>
        </div>
    </div>
</c:forEach>


</body>
</html>
