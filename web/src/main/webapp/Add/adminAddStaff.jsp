<%--
  Created by IntelliJ IDEA.
  User: nguyendeptraivkl
  Date: 02/11/2023
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Add New Staff</title>
</head>
<body>
<form action="/ecommerces?action=add" method="post">
    UserName: <input type="text" name="username"/>
    Password:<input type="text" name="password" value="123456@Abc"/>
    Email:<input type="text" name="email"/>
    name:<input type="text" name="name">
    Age:<input type="number" name="age"/>
    Phone_Number: <input type="number" name="phone_number">
    Address: <input type="text" name="address">
    wage <input type="text" name="wage">
    <input type="hidden" name="action" value="adminAddStaff">
    <input type="submit" value="add">
</form>
</body>
</html>
