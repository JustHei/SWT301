package controller.admin;

import dao.*;
import model.*;
import java.util.*;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "EditProductServlet", urlPatterns = {"/editproduct"})
public class EditProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("ID");

         // lay ra danh sach san pham
        ProductsDAO pd = new ProductsDAO();
        List<Products> listP;
        listP = pd.getAllProducts();
        request.setAttribute("listP", listP);
        
        Products p = pd.getProductByID(Integer.parseInt(id));
        request.setAttribute("p", p);

        CategoriesDAO cd = new CategoriesDAO();
        List<Categories> listC = cd.getCategories();
        request.setAttribute("listC", listC);

        request.getRequestDispatcher("edit-product.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // lay ra thong tin cua san pham sau khi cap nhat
        int productID = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String image = "img/product/" + request.getParameter("image");
        int Price = Integer.parseInt(request.getParameter("price"));
        int cateID = Integer.parseInt(request.getParameter("category"));
        String des = request.getParameter("des");

        // cap nhat san pham
        Products productUpdate = new Products(name, des, Price, image, cateID);
        ProductsDAO pd = new ProductsDAO();
        pd.editProduct(productID, productUpdate);

        // lay ra danh sach san pham
        List<Products> listP;
        listP = pd.getAllProducts();
        request.setAttribute("listP", listP);

        request.getRequestDispatcher("product-list.jsp").forward(request, response);

    }
}
