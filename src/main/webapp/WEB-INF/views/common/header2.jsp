<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="icon" href="/resources/img/fav-icon.png" type="image/x-icon"/>
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Elio Edu</title>

    <!-- Icon css link -->
    <link href="/resources/webjars/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="/resources/vendors/line-icon/css/simple-line-icons.css" rel="stylesheet">
    <link href="/resources/vendors/elegant-icon/style.css" rel="stylesheet">
    <!-- Bootstrap -->
    <link href="/resources/webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">

    <!-- Rev slider css -->
    <link href="/resources/vendors/revolution/css/settings.css" rel="stylesheet">
    <link href="/resources/vendors/revolution/css/layers.css" rel="stylesheet">
    <link href="/resources/vendors/revolution/css/navigation.css" rel="stylesheet">

    <!-- Extra plugin css -->
    <link href="/resources/vendors/owl-carousel/owl.carousel.min.css" rel="stylesheet">
    <link href="/resources/webjars/bootstrap-select/1.12.4/css/bootstrap-select.min.css" rel="stylesheet">
    <!-- -->
    <link href="/resources/webjars/jquery-ui/1.12.1/jquery-ui.min.css" rel="stylesheet">
    <link href="/resources/vendors/vertical-slider/css/jQuery.verticalCarousel.css" rel="stylesheet">
    <link href="/resources/vendors/full-page/jquery.fullpage.min.css" rel="stylesheet">
    <link href="/resources/vendors/magnify-popup/magnific-popup.css" rel="stylesheet">
    <!-- -->

    <link href="/resources/css/style.css" rel="stylesheet">
    <link href="/resources/css/responsive.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<!--================Top Header Area =================-->
<div class="header_top_area">
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <div class="top_header_left">
                    <div class="selector">
                        <select class="language_drop" name="countries" id="countries" style="width:300px;">
                            <option value='yt' data-image="/resources/img/icon/flag-1.png" data-imagecss="flag yt"
                                    data-title="English">English
                            </option>
                            <option value='yu' data-image="/resources/img/icon/flag-1.png" data-imagecss="flag yu"
                                    data-title="Bangladesh">Bangla
                            </option>
                            <option value='yt' data-image="/resources/img/icon/flag-1.png" data-imagecss="flag yt"
                                    data-title="English">English
                            </option>
                            <option value='yu' data-image="/resources/img/icon/flag-1.png" data-imagecss="flag yu"
                                    data-title="Bangladesh">Bangla
                            </option>
                        </select>
                    </div>
                    <select class="selectpicker usd_select">
                        <option>USD</option>
                        <option>$</option>
                        <option>$</option>
                    </select>
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search" aria-label="Search">
                        <span class="input-group-btn">
                                <button class="btn btn-secondary" type="button"><i class="icon-magnifier"></i></button>
                                </span>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="top_header_middle">
                    <a href="#"><i class="fa fa-phone"></i> Call Us: <span>+84 987 654 321</span></a>
                    <a href="#"><i class="fa fa-envelope"></i> Email: <span>support@yourdomain.com</span></a>
                    <img src="/resources/img/logo.png" alt="">
                </div>
            </div>
            <div class="col-lg-3">
                <div class="top_right_header">
                    <ul class="header_social">
                        <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                        <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                        <li><a href="#"><i class="fa fa-pinterest"></i></a></li>
                        <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                        <li><a href="#"><i class="fa fa-youtube-play"></i></a></li>
                    </ul>
                    <ul class="top_right">
                        <li class="user"><a href="/user/login"><i class="icon-user icons"></i></a></li>
                        <li class="cart"><a href="#"><i class="icon-handbag icons"></i></a></li>
                        <li class="h_price">
                            <select class="selectpicker">
                                <option>$0.00</option>
                                <option>$0.00</option>
                                <option>$0.00</option>
                            </select>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<!--================End Top Header Area =================-->

<!--================Menu Area =================-->
<header class="shop_header_area">
    <div class="container">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#"><img src="/resources/img/logo.png" alt=""></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav categories">
                    <li class="nav-item">
                        <select class="selectpicker">
                            <option>Categories</option>
                            <option>Categories 2</option>
                            <option>Categories 3</option>
                        </select>
                    </li>
                </ul>
                <ul class="navbar-nav">
                    <li class="nav-item dropdown submenu active">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">
                            Home <i class="fa fa-angle-down" aria-hidden="true"></i>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="nav-item"><a class="nav-link" href="index.html">Home Simple</a></li>
                            <li class="nav-item"><a class="nav-link" href="home-carousel.html">Home Carousel</a></li>
                            <li class="nav-item"><a class="nav-link" href="home-fullwidth.html">Home Full Width</a></li>
                            <li class="nav-item"><a class="nav-link" href="home-parallax.html">Home Parallax</a></li>
                            <li class="nav-item"><a class="nav-link" href="home-sidebar.html">Home Boxed</a></li>
                            <li class="nav-item"><a class="nav-link" href="home-fixed-menu.html">Home Fixed</a></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown submenu">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">
                            Pages <i class="fa fa-angle-down" aria-hidden="true"></i>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="nav-item"><a class="nav-link" href="compare.html">Compare</a></li>
                            <li class="nav-item"><a class="nav-link" href="checkout.html">Checkout Method</a></li>
                            <li class="nav-item"><a class="nav-link" href="register.html">Checkout Register</a></li>
                            <li class="nav-item"><a class="nav-link" href="track.html">Track</a></li>
                            <li class="nav-item"><a class="nav-link" href="login.html">Login</a></li>
                            <li class="nav-item"><a class="nav-link" href="404.html">404</a></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown submenu">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">
                            Shop <i class="fa fa-angle-down" aria-hidden="true"></i>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="nav-item"><a class="nav-link" href="categories-no-sidebar-2column.html">Prodcut
                                No Sidebar</a></li>
                            <li class="nav-item"><a class="nav-link" href="categories-no-sidebar-3column.html">Prodcut
                                Two Column</a></li>
                            <li class="nav-item"><a class="nav-link" href="categories-no-sidebar-4column.html">Product
                                Grid</a></li>
                            <li class="nav-item"><a class="nav-link" href="categories-left-sidebar.html">Categories Left
                                Sidebar</a></li>
                            <li class="nav-item"><a class="nav-link" href="categories-right-sidebar.html">Categories
                                Right Sidebar</a></li>
                            <li class="nav-item"><a class="nav-link" href="categories-grid-left-sidebar.html">Categories
                                Grid Sidebar</a></li>
                            <li class="nav-item"><a class="nav-link" href="product-details.html">Prodcut Details 01</a>
                            </li>
                            <li class="nav-item"><a class="nav-link" href="product-details2.html">Prodcut Details 02</a>
                            </li>
                            <li class="nav-item"><a class="nav-link" href="product-details3.html">Prodcut Details 03</a>
                            </li>
                            <li class="nav-item"><a class="nav-link" href="shopping-cart.html">Shopping Cart 01</a></li>
                            <li class="nav-item"><a class="nav-link" href="shopping-cart2.html">Shopping Cart 02</a>
                            </li>
                            <li class="nav-item"><a class="nav-link" href="empty-cart.html">Empty Cart</a></li>
                        </ul>
                    </li>
                    <li class="nav-item"><a class="nav-link" href="#">Blog</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">lookbook</a></li>
                    <li class="nav-item"><a class="nav-link" href="contact.html">Contact</a></li>
                </ul>
            </div>
        </nav>
    </div>
</header>
<!--================End Menu Area =================-->