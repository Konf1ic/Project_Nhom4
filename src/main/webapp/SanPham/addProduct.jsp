<%--
  Created by IntelliJ IDEA.
  User: chung
  Date: 21/11/2023
  Time: 1:29 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/supplier" method="post">
    Ten : <input type="text" name="name"/>
    Gia Tien:<input type="number" name="price"/>
    Mo ta:<input type="text" name="describes"/>
    Anh :<input type="text" name="image"/>
    Kiểu:<input type="text" name="type"/>
    Số lượng:<input type="number" name="quantity">
    <button name="action" value="them">Them San Pham</button>
</form>
</body>
</html>
