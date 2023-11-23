<%--
  Created by IntelliJ IDEA.
  User: chung
  Date: 22/11/2023
  Time: 9:36 SA
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
<form action="/supplier" method="post" >

    <h1 align="center">Cửa hàng</h1>
    <button name="action" value="them"> Them San Pham</button>


    <c:forEach var="list1" items="${lists1}">
        <div id="chung">
            <div id="chung1">
                <div>
                    <input type="hidden" name="id" value="${list1.id}"/>
                    <input type="hidden" name="name" value="${list1.name}"/>
                    <input type="hidden" name="price" value="${list1.price}"/>
                    <input type="hidden" name="describes" value="${list1.describes}"/>
                    <input type="hidden" name="image" value="${list1.image}"/>
                    <input type="hidden" name="type" value="${list1.type}"/>
                    <input type="hidden" name="quantity" value="${list1.quantity}"/>

                </div>

                <div id="chung2">
                    <img src="${list1.image}" height="358" width="300" alt="">
                </div>
                <div><h3>${list1.name}</h3></div>

                <div><p>${list1.price}</p></div>
                <div><p>${list1.describes}</p></div>
                <div><p>${list1.type}</p></div>
                <div><p>${list1.quantity}</p></div>


            </div>
            <div>
                <div>
                    <div><p>Tặng bảo hành Premium </p></div>
                </div>
            </div>

            <div>
<%--                                    <a href="/user?action=delete&id=${list.id}">Delete</a>--%>

            </div>
        </div>
    </c:forEach>
</form>

</body>
</html>

