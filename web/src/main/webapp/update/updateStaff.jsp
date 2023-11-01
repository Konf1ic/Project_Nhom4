<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguyendeptraivkl
  Date: 31/10/2023
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Form edit</h1>
<button><a href="/ecommerces?action=edit">Back to list</a></button>
<form method="post">
    <div style="text-align: center">
        <input type="hidden" name="id" value="<c:out value='${staff.id}' />">
        Name : <input type="text" name="name" value="<c:out value='${staff.name}' />">
        Password : <input type="text" name="password" value="<c:out value='${staff.password}' />">
        Email : <input type="text" name="email" value="<c:out value='${staff.email}' />">
        Age : <input type="text" name="age" value="<c:out value='${staff.age}' />">
        Phone_number : <input type="text" name="phone_number" value="<c:out value='${staff.phone_number}' />">
        Address : <input type="text" name="address" value="<c:out value='${staff.address}' />">
        Wage :  <input type="number" name="wage" value="<c:out value='${staff.wage}' />">
        <button type="submit">Update</button>
    </div>
</form>
</body>
</html>