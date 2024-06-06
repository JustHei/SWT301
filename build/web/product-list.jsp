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
        <title>FastFood</title>
        <style>
            /* Chỉnh kích thước tối đa của ảnh */
            img {
                max-width: 100px; /* Thiết lập chiều rộng tối đa */
                max-height: 100px; /* Thiết lập chiều cao tối đa */
            }

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
                            <h3><strong>Product Manager</strong></h3>
                            <div>
                                <a href="#addModal" class="btn btn-success" data-toggle="modal"> <span>Add Product</span></a>				
                            </div>
                            <form action="listproduct" method="post">
                                <div class="menu_box_2">
                                    <input required name="txt" class="form_1" type="text" value="${txt}" placeholder="Search by productname">
                                <input type="submit" value="Ok">
                            </div>
                        </form>
                        <div>
                            <table>
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Name</th>
                                        <th>Image</th>
                                        <th>Price</th>
                                        <th colspan="6">Actions</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listP}" var="p">
                                        <tr>
                                            <td>${p.ID}</td>
                                            <td>${p.name}</td>
                                            <td>
                                                <img src="${p.getImage()}">
                                            </td>
                                            <td>${p.price} VND</td>
                                            <td>
                                                <a href="productdetail?ID=${p.ID}">
                                                    Detail |
                                                </a>
                                                <a href="editproduct?ID=${p.ID}">
                                                    Edit |
                                                </a>
                                                <a href="#" onclick="confirmDelete(${p.ID})">Delete</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>

                        </div>
                    </div
                </div>
            </div>
        </section>

        <div id="addModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="addproduct" method="get">
                        <div class="modal-header">						
                            <h4 class="modal-title">Add Product</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>

                        <div class="modal-body">					
                            <div class="form-group">
                                <label>Product Name</label>
                                <input  name="name" type="text" class="form-control" required>
                            </div>

                            <div class="form-group">
                                <label>Image</label>
                                <input name="image" type="file" class="form-control" required>
                            </div>

                            <div class="form-group">
                                <label>Price</label>
                                <input name="price" type="number" class="form-control" required>
                            </div> 

                            <div class="form-group">
                                <label>Description</label>
                                <textarea name="des" class="form-control" required></textarea>
                            </div>
                            <label>Category</label>

                            <div class="form-group">
                                <select name="category" class="form-select" aria-label="Default select example">
                                    <c:forEach items="${listC}" var="c">                                   
                                        <option value="${c.getID()}"> ${c.getName()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-success" value="Add">
                        </div>
                    </form>
                </div>
            </div>
        </div>

         <div id="editModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="editproduct" method="post">
                        <div class="modal-header">						
                            <h4 class="modal-title">Edit Product</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>

                        <div class="modal-body">					
                            <div class="form-group">
                                <label>Product Name</label>
                                <input name="name" value="${p.name}" type="text" class="form-control" required>
                            </div>

                            <input type="hidden" name="productId">

                            <div class="form-group">
                                <label>Image</label>
                                <input value="${p.image}" name="image" type="file" class="form-control" required>
                            </div>

                            <div class="form-group">
                                <label>Price</label>
                                <input value="${p.price}" name="price" type="number" class="form-control" required>
                            </div> 

                            <div class="form-group">
                                <label>Description</label>
                                <textarea value="${p.description}" name="des" class="form-control" required></textarea>
                            </div>

                            <label>Category</label>
                            <div class="form-group">
                                <select name="category" class="form-select" aria-label="Default select example">
                                    <c:forEach items="${listC}" var="c">                                   
                                        <option value="${c.getID()}"> ${c.getName()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-success" value="Edit">
                        </div>
                    </form>
                </div>
            </div>
        </div>



        <!-- jquery plugins here-->
        <script>
            // Kiểm tra nếu trang được gọi từ editproduct
            if (window.location.href.includes('editproduct')) {
                // Mở editModal
                $('#editModal').modal('show');
            }
        </script>
        <script>
            function confirmDelete(productID) {
                if (confirm("Are you sure you want to delete this product?")) {
                    // If the user confirms, redirect to the deleteproduct URL
                    window.location.href = "deleteproduct?ID=" + productID;
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
