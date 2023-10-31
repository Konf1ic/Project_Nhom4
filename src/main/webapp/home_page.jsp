<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE-edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link rel="stylesheet">
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap');

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
        }

        body {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            background: #ffffff;
        }

        header {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            padding: 20px 100px;
            background: #04AA6D;
            display: flex;
            justify-content: space-between;
            z-index: 99;
        }

        .logo {
            font-size: 2em;
            color: #fff;
            user-select: none;
        }

        .navigation a {
            position: relative;
            font-size: 1.1em;
            color: #fff;
            text-decoration: none;
            font-weight: 500;
            margin-left: 40px;
        }

        .navigation a::after {
            content: '';
            position: absolute;
            left: 0;
            bottom: -6px;
            width: 100%;
            height: 3px;
            background: #fff;
            border-radius: 5px;
            transform-origin: right;
            transform: scaleX(0);
            transition: transform .5s;
        }

        .navigation a:hover::after {
            transform-origin: left;
            transform: scaleX(1);
        }

        .navigation .btnLogin-popup {
            width: 130px;
            height: 50px;
            background: transparent;
            border: 2px solid #fff;
            outline: none;
            border-radius: 6px;
            cursor: pointer;
            font-size: 1.1em;
            color: #fff;
            font-weight: 500;
            margin-left: 40px;
            transition: .5s;
        }

        .navigation .btnLogin-popup:hover {
            background: #fff;
            color: #162938;
        }

        .navigation .btnRegister-popup {
            width: 130px;
            height: 50px;
            background: transparent;
            border: 2px solid #fff;
            outline: none;
            border-radius: 6px;
            cursor: pointer;
            font-size: 1.1em;
            color: #fff;
            font-weight: 500;
            margin-left: 40px;
            transition: .5s;
        }

        .navigation .btnRegister-popup:hover {
            background: #fff;
            color: #162938;
        }

        .wrapper .form-box {
            width: 100%;
            padding: 40px;
        }

        .wrapper .form-box.Login {
            transition: transform .18s ease;
            transform: translateX(0);
        }

        .wrapper.active .form-box.Login {
            transition: none;
            transform: translateX(-400px);
        }

        .wrapper .form-box.Register {
            position: absolute;
            transition: none;
            transform: translateX(400px);
        }

        .wrapper.active .form-box.Register {
            transition: transform .18s ease;
            transform: translateX(0);
        }

        .wrapper .icon-close {
            position: absolute;
            top: 0;
            right: 0;
            width: 45px;
            height: 45px;
            background: #162938;
            font-size: 2em;
            color: #fff;
            display: flex;
            justify-content: center;
            align-items: center;
            border-bottom-left-radius: 20px;
            cursor: pointer;
            z-index: 1;
        }

        .form-box h2 {
            font-size: 2em;
            color: #162938;
            text-align: center;
        }

        .input-box label {
            position: absolute;
            top: 50%;
            left: 5px;
            transform: translateY(-50%);
            font-size: 1em;
            color: #162938;
            font-weight: 500;
            pointer-events: none;
            transition: .5s;
        }

        .input-box input:focus ~ label,
        .input-box input:valid ~ label {
            top: -5px;
        }

        .input-box input {
            width: 100%;
            height: 100%;
            background: transparent;
            border: none;
            outline: none;
            font-size: 1em;
            color: #162938;
            font-weight: 600;
            padding: 0 35px 0 5px;
        }

        .input-box .icon {
            position: absolute;
            right: 8px;
            font-size: 1.2em;
            color: #162938;
            line-height: 57px;

        }

        .remember-forgot {
            font-size: .9em;
            color: #162938;
            font-weight: 500;
            margin: -15px 0 15px;
            display: flex;
            justify-content: space-between;
        }

        .remember-forgot label input {
            accent-color: #162938;
            margin-right: 3px;
        }

        .remember-forgot a {
            color: #162938;
            text-decoration: none;
        }

        .remember-forgot a:hover {
            text-decoration: underline;
        }

        .btn {
            display: inline-block;
            padding: 12px 20px;
            background-color: #04AA6D;
            color: white;
            border: none;
            border-radius: 4px;
            text-align: center;
            text-decoration: none;
            transition: background-color 0.3s;
        }

        .btn:hover {
            background-color: #04AA6D;
        }

        /* Style the "Sign Up" button separately */
        .btn.btnRegister-popup {
            background-color: #04AA6D;
        }

        .btn.btnRegister-popup:hover {
            background-color: #04AA6D;
        }

        .login-register p a {
            color: #04AA6D;
            text-decoration: none;
            font-weight: 600;
        }

        .login-register p a:hover {
            text-decoration: underline;
        }
    </style>
</head>

<body>
<header>
    <h2 class="logo">Logo</h2>
    <nav class="navigation">
        <a href="signin.jsp" class="btn btnLogin-popup">Sign in</a>
        <a href="signup.jsp" class="btn btnRegister-popup">Sign Up</a>
    </nav>
</header>
<div id="content-container"></div>
</body>
</html>
