<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chung
  Date: 06/11/2023
  Time: 11:29 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Position của người dùng có tên tài khoản ${sessionScope.userSession.username} là: <span style="color: red">${sessionScope.userSession.position}</span> </h1>
</body>
</html>
