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
        <title>Sach</title>
        <style>
            /* Custom CSS */

            /* Table Styling */
            table {
                width: 100%;
                border-collapse: collapse;
                margin-bottom: 20px;
            }

            th,
            td {
                text-align: left;
                padding: 10px;
            }

            th {
                background-color: #f2f2f2;
            }
            /* End of Custom CSS */
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
                            <h3><strong>Bill Details</strong></h3> 
                            <div>
                                <table>
                                    <thead>
                                        <tr>
                                            <th>Product Name</th>
                                            <th>Price pet unit</th>
                                            <th>Quantity</th>
                                            <th>Total</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${detail}" var="o">
                                        <tr>
                                            <td>${o.getProductName()}</td>
                                            <td>${o.getProductPrice()}</td>
                                            <td>${o.getQuantity()}</td>
                                            <td>${o.getProductPrice() * o.getQuantity()} VND</td>                    
                                        </tr>
                                    </c:forEach>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td>${o.totalAmount} VND</td>
                                        </tr>
                                </tbody>
                            </table>
                            <div style="float: right">
                                <a href="javascript:history.back()" class="btn btn-primary">Back to Previous</a>
                            </div>
                        </div>
                    </div
                </div>
            </div>
        </section>
        <!-- Hero Section End -->

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
