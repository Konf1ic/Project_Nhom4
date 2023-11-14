<%--
  Created by IntelliJ IDEA.
  User: nguyendeptraivkl
  Date: 13/11/2023
  Time: 09:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <fieldset>
        <legend>Edit Product</legend>
        <table>
            <input type="hidden" name="id" value="${Supplier.id}">
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" value="${Supplier.name}"></td>
            </tr>
            <tr>
                <td>Price :</td>
                <td><input type="number" name="price" value="${Supplier.price}"></td>
            </tr>
            <tr>
                <td>Describes</td>
                <td><input type="text" name="describes" value="${Supplier.describes}"></td>
            </tr>
            <tr>
                <td>Image</td>
                <td><input type="text" name="image" value="${Supplier.image}"></td>
            </tr>
            <tr>
                <td>Type</td>
                <td><input type="text" name="type" value="${Supplier.type}"></td>
            </tr>
            <tr>
                <td>Quantity :</td>
                <td><input type="text" name="quantity" value="${Supplier.quantity}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
