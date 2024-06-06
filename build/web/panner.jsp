<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Page Preloder -->
<div id="preloder">
    <div class="loader"></div>
</div>


<!-- Header Section Begin -->
<header class="header">
    <div class="header__top">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6">
                    <div class="header__top__left">
                        <ul>
                            <li><i class="fa fa-envelope"></i> abc123@fpt.edu.vn</li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="header__top__right">
                        <div class="header__top__right__social">
                            <a href="#"><i class="fa fa-facebook"></i></a>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                            <a href="#"><i class="fa fa-linkedin"></i></a>
                            <a href="#"><i class="fa fa-pinterest-p"></i></a>
                        </div>
                        <div class="header__top__right__language">
                            <c:if test="${sessionScope.user != null}">
                                <div>Welcome ${user.username}</div>
                            </c:if>
                        </div>
                        <c:if test="${sessionScope.user == null}">
                            <div class="header__top__right__auth">
                                <a href="login.jsp"><i class="fa fa-user"></i> Login</a>
                            </div>
                        </c:if>

                        <c:if test="${sessionScope.user != null}">
                            <div class="header__top__right__auth">
                                <a href="logout"><i class="fa fa-user"></i> Logout</a>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <div class="header__logo">
                    <c:if test="${sessionScope.user.role != 1}">
                        <a href="content"><h2 style="color: #7fad39">Home</h2></a>
                    </c:if>

                    <c:if test="${sessionScope.user.role == 1}">
                        <a href="admin-index.jsp"><h2 style="color: #7fad39">Home</h2></a>
                    </c:if>

                </div>
            </div>
            <div class="col-lg-6">

            </div>
            <div class="col-lg-3">
                <div class="header__cart">
                    <ul>
                        <c:if test="${sessionScope.user.getRole() == 2}" >
                            <li><a href="cart.jsp"><i class="fa fa-shopping-bag"></i> <span>${num}</span></a></li>
                            </c:if>

                        <c:if test="${sessionScope.user == null}">
                            <li><a href="cart.jsp"><i class="fa fa-shopping-bag"></i> <span>${num}</span></a></li>
                            </c:if>

                    </ul>
                </div>
            </div>

        </div>
        <div class="humberger__open">
            <i class="fa fa-bars"></i>
        </div>
    </div>

</header>

<!-- Header Section End -->
