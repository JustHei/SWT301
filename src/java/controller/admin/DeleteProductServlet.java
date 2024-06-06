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


@WebServlet(name = "DeleteProductServlet", urlPatterns = {"/deleteproduct"})
public class DeleteProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // xóa san pham
        int productID = Integer.parseInt(request.getParameter("ID"));
        ProductsDAO pd = new ProductsDAO();
        pd.deleteProduct(productID);
        
        // lay lai danh sách san pham
        List<Products> listP;
        listP = pd.getAllProducts();
        request.setAttribute("listP", listP);
        
        request.getRequestDispatcher("product-list.jsp").forward(request, response);

    }

}
