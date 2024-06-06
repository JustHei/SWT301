package controller.guest;

import dao.CategoriesDAO;
import dao.ProductsDAO;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.*;

@WebServlet(name = "ProductDetailServlet", urlPatterns = {"/productdetail"})

public class ProductDetailServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // lay ra thong tin cua 1 san pham
        int id = Integer.parseInt(request.getParameter("ID"));
        ProductsDAO pd = new ProductsDAO();
        Products p = pd.getProductByID(id);
        request.setAttribute("p", p);

        CategoriesDAO cd = new CategoriesDAO();
        Categories c = cd.getCategoryByProductId(id);
        request.setAttribute("c", c);

        // lay ra list category
        List<Categories> listC = cd.getCategories();
        request.setAttribute("listC", listC);

        // lay san pham lien quan
        List<Products> listP = new ArrayList<>();
        List<Products> relatedProducts = pd.getProductsByCategoryID(c.getID());

// Remove the current product from the list of related products
        Iterator<Products> iterator = relatedProducts.iterator();
        while (iterator.hasNext()) {
            Products product = iterator.next();
            if (product.getID() == id) {
                iterator.remove();
                break; // Assuming there's only one occurrence of the product in the related products list
            }
        }

// Get at most 3 related products
        int count = 0;
        for (Products product : relatedProducts) {
            listP.add(product);
            count++;
            if (count >= 3) {
                break;
            }
        }

        request.setAttribute("listP", listP);
        request.getRequestDispatcher("product-detail.jsp").forward(request, response);

    }

}
