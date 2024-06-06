<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Helo</title>

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

        <!-- Css Styles -->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
        <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <style>
            .checkout__order {
                background-color: #f2f2f2;
                border: 1px solid #ccc;
                border-radius: 5px;
                padding: 20px;
                text-align: center;
            }

            .checkout__order-title {
                font-size: 20px;
                margin-bottom: 10px;
            }

            .checkout__order-products {
                font-weight: bold;
                margin-bottom: 10px;
            }

            .checkout__order-list {
                list-style-type: none;
                padding: 0;
            }

            .checkout__order-item {
                display: flex;
                justify-content: space-between;
                margin-bottom: 5px;
            }

            .checkout__order-item-name {
                flex: 1;
                white-space: nowrap;
                overflow: hidden;
                text-overflow: ellipsis;
            }

            .checkout__order-item-price {
                flex: 0 0 80px;
                text-align: right;
            }

            .checkout__order-total {
                font-weight: bold;
                margin-top: 10px;
            }

            .site-btn {
                background-color: red;
                color: white;
                padding: 10px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                margin-top: 10px;
            }
        </style>
    </head>

    <body>
        <jsp:include page="panner.jsp"></jsp:include>

            <!-- Breadcrumb Section Begin -->
            <section class="breadcrumb-section set-bg" data-setbg="img/breadcrumb.jpg">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 text-center">
                            <div class="breadcrumb__text">
                                <h2>Checkout</h2>
                                <div class="breadcrumb__option">
                                    <a href="content">Home</a>
                                    <span>Checkout</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Breadcrumb Section End -->

            <!-- Checkout Section Begin -->
            <section class="checkout spad">
                <div class="container">
                    <div class="row">
                        <!-- Phần nhập thông tin người mua bên trái -->
                        <div class="col-lg-6">
                            <form action="checkout" method="get">
                                <div class="checkout__input">
                                    <p> Name<span>*</span></p>
                                    <input placeholder="Fullname" type="text" name="name" required>
                                </div>
                                <div class="checkout__input">
                                    <p>Address<span>*</span></p>
                                    <input name="address" type="text" required placeholder="Street Address" class="checkout__input__add">
                                </div>
                                <div class="checkout__input">
                                    <p>Phone<span>*</span></p>
                                    <input placeholder="Phone" type="number" name="phone" required>
                                </div>
                        </div>
                        <!-- Phần Your Order bên phải -->
                        <div class="col-lg-6">
                            <div class="checkout__order">
                                <h4 class="checkout__order-title">Your Order</h4>
                                <div class="checkout__order-products">Products <span>Total</span></div>
                                <ul class="checkout__order-list">
                                <c:forEach items="${cart}" var="p">
                                    <li class="checkout__order-item">
                                        <input type="hidden" name="productID" value="${p.getID()}">
                                        <input type="text" value="${p.getName()}" readonly class="checkout__order-item-name">
                                        <input type="text" name="quantity" value="${p.getQuantity()} x ${p.getPrice()}_VND" readonly class="checkout__order-item-price">
                                    </li>
                                </c:forEach>
                            </ul>
                            <div class="checkout__order-total">Total <span>${total} VND</span></div>
                            <button type="submit" class="site-btn">PLACE ORDER</button>
                        </div>
                        </form>
                    </div>
                </div>
            </div>

        </section>
        <!-- Checkout Section End -->

        <jsp:include page="footer.jsp"></jsp:include>

        <!-- Js Plugins -->
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.nice-select.min.js"></script>
        <script src="js/jquery-ui.min.js"></script>
        <script src="js/jquery.slicknav.js"></script>
        <script src="js/mixitup.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
