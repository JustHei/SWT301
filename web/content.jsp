<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">

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
        <title>Home Page</title>
        <style>
            .featured__item__pic__hover li:nth-child(2) a i {
                /* CSS properties */
                /* Ví dụ: */
                display: none;
            }

            .featured__item__pic__hover li:nth-child(2) a::after {
                content: "Buy";
                /* CSS properties */
                /* Ví dụ: */
                /* ... */
            }
            .featured__item__text h6 a {
                font-weight: bold;
                text-decoration: none;
            }

            .featured__item__text h6 a:hover {
                text-decoration: underline;
            }

            .featured__item__text .price {
                font-weight: normal;
            }
        </style>
    </head>
    <body>


        <jsp:include page="panner.jsp"></jsp:include>
            <!-- Hero Section Begin -->
            <section class="hero">
                <div class="container">
                    <div class="row">
                    <jsp:include page="menu.jsp"></jsp:include>

                        <div class="col-lg-9">
                        <%
               String mess = (String) request.getAttribute("mess");
               if (mess != null) {
                        %>
                        <p style="color: red" id="message">${mess}</p>
                        <%
                            }
                        %>

                        
                        <div class="hero__search">
                  r          <div class="hero__search__form">
                                <form action="content" method="post">
                                    <input type="text" name="txt" placeholder="What do yo u need?">
                                    <button type="submit" class="site-btn">SEARCH</button>
                                </form>
                            </div>
                            <div class="hero__search__phone">
                                <div class="hero__search__phone__icon">
                                    <i class="fa fa-phone"></i>
                                </div>
                                <div class="hero__search__phone__text">
                                    <h5>+66 77 1508</h5>
                                    <span>support 24/7 time</span>
                                </div>
                            </div>
                        </div>  

                        <!-- Featured Section Begin -->
                        <section class="featured spad">
                            <div class="container">
                                <div class="row featured__filter">
                                    <c:forEach items="${listP}" var="p"> 
                                        <div class="col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat">
                                            <div class="featured__item">
                                                <div class="featured__item__pic set-bg" data-setbg="${p.getImage()}">
                                                    <ul class="featured__item__pic__hover">
                                                        <li><a href="cart?productID=${p.getID()}"><i class="fa fa-shopping-cart"></i></a></li>
                                                    </ul>   
                                                </div>  
                                                <div class="featured__item__text">
                                                    <h6>
                                                        <a href="productdetail?ID=${p.getID()}" onmouseover="changeStyle(this, true)" onmouseout="changeStyle(this, false)">
                                                            ${p.getName()}
                                                        </a>
                                                    </h6>
                                                    <h5 class="price">${p.getPrice()} VND</h5>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>

                                </div>
                            </div>
                        </section>
                        <!-- Featured Section End -->

                    </div>
                </div>
            </div>
        </section>
        <!-- Hero Section End -->







        <jsp:include page="footer.jsp"></jsp:include>



        <!-- Js Plugins -->
        <script>
            function changeStyle(element, isHovered) {
                if (isHovered) {
                    element.style.fontWeight = "bold"; // In đậm
                    element.style.textDecoration = "underline"; // Gạch chân
                } else {
                    element.style.fontWeight = "normal"; // Trạng thái bình thường
                    element.style.textDecoration = "none"; // Trạng thái bình thường
                }
            }

        </script>
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
