<%--
  Created by IntelliJ IDEA.
  User: chung
  Date: 21/11/2023
  Time: 1:25 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        #chung {
            width: 500px;
            height: 600px;
            text-align: center;
            margin: 0 auto;
            border-bottom: 50px #ff0101;
        }

        #chung1 {
            width: 300px;
            text-align: center;
            margin: 10px auto;
        }

        #chung2 </style>
</head>
<body>
<form action="/user">

    <h1 align="center">Cửa hàng</h1>
    <button type="submit" name="action" value="list"> gio hang</button>
<%--    <button name="action" value="them"> Them San Pham</button>--%>


    <c:forEach var="list" items="${lists}">
        <div id="chung">
            <div id="chung1">
                <div>
                    <input type="hidden" name="id" value="${list.id}"/>
                    <input type="hidden" name="name" value="${list.name}"/>
                    <input type="hidden" name="price" value="${list.price}"/>
                    <input type="hidden" name="describes" value="${list.describes}"/>
                    <input type="hidden" name="image" value="${list.image}"/>
                    <input type="hidden" name="image" value="${list.type}"/>
                    <input type="hidden" name="image" value="${list.quantity}"/>

                </div>

                <div id="chung2">
                    <img src="${list.image}" height="358" width="300" alt="">
                </div>
                <div><h3>${list.name}</h3></div>

                <div><p>${list.price}</p></div>
                <div><p>${list.describes}</p></div>
                <div><p>${list.type}</p></div>
                <div><p>${list.quantity}</p></div>


            </div>
            <div>
                <div>
                    <div><p>Tặng bảo hành Premium </p></div>
                </div>
            </div>

            <div>
                <a href="/user?action=add&id=${list.id}&name=${list.name}&price=${list.price}&describes=${list.describes}&image=${list.image}&type=${list.type}&quantity=${list.quantity}">
                    <p>Add</p>
                </a>
<%--                <a href="/user?action=delete&id=${list.id}">Delete</a>--%>

            </div>
        </div>
    </c:forEach>
</form>

</body>
</html>
