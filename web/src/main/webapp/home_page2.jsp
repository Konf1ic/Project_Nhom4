<%--
  Created by IntelliJ IDEA.
  User: chung
  Date: 06/11/2023
  Time: 1:28 CH
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
            flex-direction: column;
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

        .topnav {
            display: flex;
        }

        .search-container {
            margin-left: auto;
            display: flex;
        }

        .search-container input[type="text"] {
            padding: 6px;
            font-size: 17px;
            border: none;
            border-radius: 5px;
            width: 400px;
        }

        .search-container button {
            padding: 6px;
            background: #04AA6D;
            color: white;
            border: none;
            border-radius: 0 5px 5px 0;
            cursor: pointer;
        }

        .search-container button:hover {
            background: #c2c2c2;
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

        .navigation .btnSetting-popup {
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

        .navigation .btnSetting-popup:hover {
            background: #fff;
            color: #162938;
        }

        * {
            box-sizing: border-box
        }

        body {
            font-family: Verdana, sans-serif;
            margin: 0
        }

        .mySlides {
            display: none
        }

        img {
            vertical-align: middle;
        }

        /* Slideshow container */
        .slideshow-container {
            max-width: 100%;
            position: relative;
            margin: auto;
        }

        /* Next & previous buttons */
        .prev, .next {
            cursor: pointer;
            position: absolute;
            top: 50%;
            width: auto;
            padding: 16px;
            margin-top: -22px;
            color: white;
            font-weight: bold;
            font-size: 18px;
            transition: 0.6s ease;
            border-radius: 0 3px 3px 0;
            user-select: none;
        }

        /* Position the "next button" to the right */
        .next {
            right: 0;
            border-radius: 3px 0 0 3px;
        }

        /* On hover, add a black background color with a little bit see-through */
        .prev:hover, .next:hover {
            background-color: rgba(0, 0, 0, 0.8);
        }

        /* Caption text */
        .text {
            color: #f2f2f2;
            font-size: 15px;
            padding: 8px 12px;
            position: absolute;
            bottom: 8px;
            width: 100%;
            text-align: center;
        }

        /* Number text (1/3 etc) */
        .numbertext {
            color: #f2f2f2;
            font-size: 12px;
            padding: 8px 12px;
            position: absolute;
            top: 0;
        }

        /* The dots/bullets/indicators */
        .dot {
            cursor: pointer;
            height: 15px;
            width: 15px;
            margin: 0 2px;
            background-color: #bbb;
            border-radius: 50%;
            display: inline-block;
            transition: background-color 0.6s ease;
        }

        .active, .dot:hover {
            background-color: #717171;
        }

        /* Fading animation */
        .fade {
            animation-name: fade;
            animation-duration: 1.5s;
        }

        @keyframes fade {
            from {
                opacity: .4
            }
            to {
                opacity: 1
            }
        }

        /* On smaller screens, decrease text size */
        @media only screen and (max-width: 300px) {
            .prev, .next, .text {
                font-size: 11px
            }
        }

        #background-content {
            width: 100%;
            height: 1000px;
        }

        #head {
            width: 100%;
            height: 88px;
        }

    </style>
</head>
<body>
<div id="head">
    <header>
        <h2 class="logo">BunBun</h2>
        <div class="topnav">
            <div class="search-container">
                <form action="">
                    <input type="text" placeholder="Search..." name="search">
                    <button type="submit"><i class="fa fa-search"></i></button>
                </form>
            </div>
            <nav class="navigation">
                <a href="#" class="btn btnSetting-popup">Setting</a>
            </nav>
        </div>
    </header>
</div>

<div id="background-content">
    <div id="content-container">
        <div class="slideshow-container">

            <div class="mySlides fade">
                <div class="numbertext">1 / 3</div>
                <img src="Pic/1.jpg" style="width:100%;height: 300px">
                <div class="text">Caption Text</div>
            </div>

            <div class="mySlides fade">
                <div class="numbertext">2 / 3</div>
                <img src="Pic/2.jpg" style="width:100%;height: 300px">
                <div class="text">Caption Two</div>
            </div>

            <div class="mySlides fade">
                <div class="numbertext">3 / 3</div>
                <img src="Pic/3.jpg" style="width:100%;height: 300px">
                <div class="text">Caption Three</div>
            </div>

            <a class="prev" onclick="plusSlides(-1)"><</a>
            <a class="next" onclick="plusSlides(1)">></a>

        </div>
        <br>

        <div style="text-align:center">
            <span class="dot" onclick="currentSlide(1)"></span>
            <span class="dot" onclick="currentSlide(2)"></span>
            <span class="dot" onclick="currentSlide(3)"></span>
        </div>

    </div>
</div>
<script>
    let slideIndex = 1;
    showSlides(slideIndex);

    function plusSlides(n) {
        showSlides(slideIndex += n);
    }

    function currentSlide(n) {
        showSlides(slideIndex = n);
    }

    function showSlides(n) {
        let i;
        let slides = document.getElementsByClassName("mySlides");
        let dots = document.getElementsByClassName("dot");
        if (n > slides.length) {
            slideIndex = 1
        }
        if (n < 1) {
            slideIndex = slides.length
        }
        for (i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
        }
        for (i = 0; i < dots.length; i++) {
            dots[i].className = dots[i].className.replace(" active", "");
        }
        slides[slideIndex - 1].style.display = "block";
        dots[slideIndex - 1].className += " active";
    }
</script>

</body>
</html>