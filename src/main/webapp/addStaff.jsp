<%--
  Created by IntelliJ IDEA.
  User: chung
  Date: 14/11/2023
  Time: 8:21 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        * {
            box-sizing: border-box;
        }

        input[type=text], select, textarea {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            resize: vertical;
        }

        input[type=number], select, textarea {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            resize: vertical;
        }

        label {
            padding: 12px 12px 12px 0;
            display: inline-block;
        }

        input[type=submit] {
            background-color: #04AA6D;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            float: right;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }

        .container {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
        }

        .col-25 {
            float: left;
            width: 25%;
            margin-top: 6px;
        }

        .col-75 {
            float: left;
            width: 75%;
            margin-top: 6px;
        }

        /* Clear floats after the columns */
        .row:after {
            content: "";
            display: table;
            clear: both;
        }

        /* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
        @media screen and (max-width: 600px) {
            .col-25, .col-75, input[type=submit] {
                width: 100%;
                margin-top: 0;
            }
        }
    </style>
</head>
<body>

<h2>Add Staff</h2>

<div class="container">
    <form action="/user?action=add" method="post">

        <div class="row">
            <div class="col-25">
                <label for="uname">Username</label>
            </div>
            <div class="col-75">
                <input type="text" id="uname" name="username" placeholder="Enter Username...">
            </div>
        </div>

        <div class="row">
            <div class="col-25">
                <label for="password">Pass</label>
            </div>
            <div class="col-75">
                <input type="text" id="password" name="password" placeholder="Enter Password...">
            </div>
        </div>

        <div class="row">
            <div class="col-25">
                <label for="email">Email</label>
            </div>
            <div class="col-75">
                <input type="text" id="email" name="email" placeholder="Enter Email...">
            </div>
        </div>

        <div class="row">
            <div class="col-25">
                <label for="name">Name</label>
            </div>
            <div class="col-75">
                <input type="text" id="name" name="name" placeholder="Enter Name...">
            </div>
        </div>

        <div class="row">
            <div class="col-25">
                <label for="age">Age</label>
            </div>
            <div class="col-75">
                <input type="number" id="age" name="age" placeholder="Enter Age...">
            </div>
        </div>

        <div class="row">
            <div class="col-25">
                <label for="phone">Phone</label>
            </div>
            <div class="col-75">
                <input type="number" id="phone" name="phone" placeholder="Enter Phone...">
            </div>
        </div>

        <div class="row">
            <div class="col-25">
                <label for="address">Address</label>
            </div>
            <div class="col-75">
                <input type="text" id="address" name="address" placeholder="Enter Address...">
            </div>
        </div>

        <div class="row">
            <div class="col-25">
                <label for="wage">Salary</label>
            </div>
            <div class="col-75">
                <input type="text" id="wage" name="salary" placeholder="Enter Salary...">
            </div>
        </div>
        <label><b>Role</b></label>
        <select name="position">
            <option value="NhanVien" selected>Staff</option>
        </select>

        <div class="row">
            <input type="hidden" name="action" value="adminAddStaff">
            <input type="submit" value="Add">
        </div>
    </form>
</div>

</body>
</html>
