
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
        <link rel="stylesheet" href="assets/css/fontawesome.min.css">
        <style>
            .container {
                margin-top: 20px;
            }
            .card-body {
                font-family: 'Roboto', sans-serif;
            }
            .title {
                font-weight: 700;
                margin-bottom: 20px;
            }
            .item-property p {
                margin-bottom: 10px;
            }
            .btn-back {
                margin-bottom: 20px;
            }
            .col-sm-5.border-right {
                padding-right: 20px;
            }
            .img-big-wrap {
                text-align: center;
            }
            .img-big-wrap img {
                max-width: 100%;
                max-height: 300px;
            }
            .col-sm-7 {
                padding-left: 20px;
            }
            /* Related product section */
            h3 {
                font-size: 24px;
                font-weight: bold;
                margin-top: 40px; /* Điều chỉnh margin tùy theo nhu cầu */
                margin-bottom: 20px;
                color: #333; /* Thay đổi màu sắc theo sở thích của bạn */
            }

            /* Container chứa danh sách sản phẩm liên quan */
            .related-products {
                display: flex; /* Hiển thị các mục sản phẩm theo chiều ngang */
                overflow-x: auto; /* Cho phép cuộn khi không đủ không gian */
                gap: 20px; /* Khoảng cách giữa các mục sản phẩm */
            }





        </style>
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

            /* Related Products Section */
            .related-products {
                display: flex;
                flex-wrap: nowrap; /* Ngăn các mục chồng chéo khi quá rộng */
                overflow-x: auto;
                gap: 40px; /* Khoảng cách giữa các sản phẩm */
                margin-top: 20px;
                margin-bottom: 40px;
                padding-bottom: 20px;
                border-bottom: 1px solid #ebebeb; /* Đường kẻ dưới */
            }

            .related-product {
                flex: 0 0 auto;
                width: 150px; /* Kích thước của mỗi sản phẩm */
                background-color: #fff; /* Màu nền cho mỗi sản phẩm */
                border-radius: 5px; /* Độ cong viền */
                overflow: hidden;
            }

            .related-product__image img {
                width: 100%;
                height: auto; /* Đảm bảo tỷ lệ khung hình ảnh */
            }

            .related-product__info {
                padding: 10px;
            }

            .related-product__name {
                margin-top: 0;
                margin-bottom: 5px;
                font-size: 14px;
            }

            .related-product__name a {
                color: #333;
                text-decoration: none;
            }

            .related-product__name a:hover {
                text-decoration: underline;
            }

            .related-product__price {
                font-size: 12px;
                color: #ff5722; /* Màu giá sản phẩm */
                font-weight: bold;
                margin: 0;
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
                            <div class="hero__search">
                                <div class="hero__search__form">
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
                            <div class="row">
                                <aside class="col-sm-5 border-right">
                                    <article class="gallery-wrap"> 
                                        <div class="img-big-wrap">
                                            <div> <a href="#"><img src="${p.getImage()}"></a></div>
                                    </div>
                                </article>
                            </aside>
                            <aside class="col-sm-7">
                                <article class="card-body p-5">
                                    <h3 class="title mb-3">${p.getName()}</h3>
                                    <dl class="item-property">      
                                        <dd><p style="color: black">Category: ${c.name}</p></dd>
                                        <dd><p style="color: black">Availibility: In Stock</p></dd>
                                        <dd><p style="color: black">${p.getDescription()}</p></dd>
                                        <dd><p style="color: red">${p.getPrice()} VND</p></dd>
                                        <dd><c:if test="${sessionScope.user.getRole() == null}" >
                                                <a href="cart.jsp"><i class="btn btn-danger">Cart</i></a>
                                            </c:if></dd>

                                        <c:if test="${sessionScope.user.getRole() == 1}" >
                                            <dd>
                                                <a href="javascript:history.back()" class="btn btn-primary">Back</a>
                                            </dd>                                           
                                        </c:if>
                                        <c:if test="${sessionScope.user.getRole() != 1}" >
                                            <dd>
                                                <a href="content" class="btn btn-primary">Back</a>
                                            </dd>                                           
                                        </c:if>

                                    </dl>

                                </article>
                            </aside>
                        </div>
                        <!-- Featured Section End -->
                        <c:if test="${sessionScope.user.role !=  1}">
                            <h3>San phâm liên quan</h3>
                            <!-- Related Products Section Begin -->
                            <div class="related-products">
                                <c:forEach items="${listP}" var="p">
                                    <div class="related-product">
                                        <div class="related-product__image">
                                            <a href="productdetail?ID=${p.getID()}">
                                                <img src="${p.getImage()}" alt="${p.getName()}">
                                            </a>
                                        </div>
                                        <div class="related-product__info">
                                            <h6 class="related-product__name">
                                                <a href="productdetail?ID=${p.getID()}">${p.getName()}</a>
                                            </h6>
                                            <p class="related-product__price">${p.getPrice()} VND</p>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </c:if>

                        <!-- Related Products Section End -->

                    </div>
                </div>
            </div>
        </section>
        <!-- Hero Section End -->







        <jsp:include page="footer.jsp"></jsp:include>



        <!-- Start Script -->
        <script src="assets/js/jquery-1.11.0.min.js"></script>
        <script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
        <script src="assets/js/bootstrap.bundle.min.js"></script>
        <script src="assets/js/templatemo.js"></script>
        <script src="assets/js/custom.js"></script>
        <!-- End Script -->
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

