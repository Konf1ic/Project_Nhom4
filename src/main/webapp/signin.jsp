<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: konflic
  Date: 02/11/2023
  Time: 9:19 SA
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
        }

        * {
            box-sizing: border-box;
        }

        .container {
            position: relative;
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px 0 30px 0;
        }

        input,
        .btn {
            width: 100%;
            padding: 12px;
            border: none;
            border-radius: 4px;
            margin: 5px 0;
            opacity: 0.85;
            display: inline-block;
            font-size: 17px;
            line-height: 20px;
            text-decoration: none;

        }

        input:hover,
        .btn:hover {
            opacity: 1;
        }

        input[type=submit] {
            background-color: #04AA6D;
            color: white;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }

        /* Two-column layout */
        .col {
            float: left;
            width: 50%;
            margin: auto;
            padding: 0 50px;
            margin-top: 6px;
        }

        /* Clear floats after the columns */
        .row:after {
            content: "";
            display: table;
            clear: both;
            margin: auto;
        }

        /* bottom container */
        .bottom-container {
            text-align: center;
            background-color: #666;
            border-radius: 0px 0px 4px 4px;
        }

        /* Responsive layout - when the screen is less than 650px wide, make the two columns stack on top of each other instead of next to each other */
        @media screen and (max-width: 650px) {
            .col {
                width: 100%;
                margin-top: 0;
            }

            /* hide the vertical line */
            .vl {
                display: none;
            }

            /* show the hidden text on small screens */
            .hide-md-lg {
                display: block;
                text-align: center;
            }
        }
    </style>
</head>
<body>
<div class="container">
    <form method="post" action="user?action=login">
        <div class="row">
            <h2 style="text-align:center">Sign in</h2>

            <label for="username"><b>Username</b></label>
            <input type="text" placeholder="Username" name="username" id="username" required>

            <label for="psw"><b>Password</b></label>
            <input type="password" placeholder="Password" name="password" id="psw" required>

            <input type="submit" value="Sign in">
        </div>
    </form>
</div>

<div class="bottom-container">
    <div class="row">
        <div class="col">
            <a href="signup.jsp" style="color:white" class="btn">Sign up</a>
        </div>
        <div class="col">
            <a href="#" style="color:white" class="btn">Forgot password?</a>
        </div>
    </div>
</div>
<c:if test="${not empty message}">
    <script>
        alert("${message}")

    </script>
</c:if>

</body>
</html>