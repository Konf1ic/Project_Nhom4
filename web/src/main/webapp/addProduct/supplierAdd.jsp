<%--
  Created by IntelliJ IDEA.
  User: nguyendeptraivkl
  Date: 09/11/2023
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Supplier Add Product</title>
</head>
<body>
<form action="ecommerces?action=supplierAddProduct" method="post">
    Name : <input type="text" name="name"/>
    Price : <input type="number" name="price"/>
    Describes : <input type="text" name="describes"/>
    Image : <input type="text" name="image">
    Type : <input type="text" name="type">
    Quantity : <input type="number" name="quantity">
    <input type="hidden" name="action" value="supplierAdd">
    <button name="action" value="supplierAdd">ADD</button>
</form>
</body>
</html>
