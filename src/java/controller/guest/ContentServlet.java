package controller.guest;

import dao.CategoriesDAO;
import dao.ProductsDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Categories;
import model.Products;

@WebServlet(name = "ContentServlet", urlPatterns = {"/content"})

public class ContentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // lay ra list category
        CategoriesDAO cd = new CategoriesDAO();
        List<Categories> listC = cd.getCategories();
        request.setAttribute("listC", listC);

        // lay ra categoryID mà nguoi dùng muon xem
        String stringCateID = request.getParameter("CateID");

        // danh sach san pham
        ProductsDAO pd = new ProductsDAO();
        List<Products> listP;
        //neu khong chon category cu the, tra ve danh sach tat ca san pham
        if (stringCateID == null) {
            listP = pd.getAllProducts();
            // neu chon 1 category, lay ra danh sach san pham thuoc ve category do
        } else {
            int cateID = Integer.parseInt(stringCateID);
            listP = pd.getProductsByCategoryID(cateID);
        }
        request.setAttribute("listP", listP);

        request.getRequestDispatcher("content.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // lay ra ky tu ma nguoi dung search
        String txt = request.getParameter("txt");

        // lay ra list category
        CategoriesDAO cd = new CategoriesDAO();
        List<Categories> listC = cd.getCategories();
        request.setAttribute("listC", listC);

        //lay ra nhung san pham co tên chua ký tu mà nguoi dùng muon search
        ProductsDAO pd = new ProductsDAO();
        List<Products> listP = pd.searchProductByName(txt);
        request.setAttribute("listP", listP);

        request.getRequestDispatcher("content.jsp").forward(request, response);

    }

}
