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

/**
 *
 * @author havie
 */
@WebServlet(name = "ListProductServlet", urlPatterns = {"/listproduct"})
public class ListProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // lay ra danh sach san pham
        ProductsDAO pd = new ProductsDAO();
        List<Products> listP;
        listP = pd.getAllProducts();
        request.setAttribute("listP", listP);

        CategoriesDAO cd = new CategoriesDAO();
        List<Categories> listC = cd.getCategories();
        request.setAttribute("listC", listC);

        request.getRequestDispatcher("product-list.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // search san pham
        String txt = request.getParameter("txt");
        ProductsDAO pd = new ProductsDAO();
        List<Products> listP;
        listP = pd.searchProductByName(txt);
        request.setAttribute("listP", listP);
        
        CategoriesDAO cd = new CategoriesDAO();
        List<Categories> listC = cd.getCategories();
        request.setAttribute("listC", listC);

        request.getRequestDispatcher("product-list.jsp").forward(request, response);

    }
}
