package controller.customer;

import dao.*;
import model.*;
import java.util.*;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "CartServlet", urlPatterns = {"/cart"})
public class CartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        // them 
        int productId = Integer.parseInt(request.getParameter("productID"));
        ProductsDAO pd = new ProductsDAO();
        Products p = pd.getProductByID(productId);

        // lay ra gio hang
        Vector<Products> cart = (Vector<Products>) session.getAttribute("cart");
        if (cart == null) {
            cart = new Vector<>();
        }

        // Calculate the number of items incart and total price of items in the cart
        int num = 0, total = 0;
        boolean productExists = false;

        //them san pham vao gio hang, neu san pham da ton tai trong gio hang, cap nhat quantity += 1, tính thành tien cua gio hàng
        for (Products item : cart) {
            if (item.getID() == p.getID()) {
                item.setQuantity(item.getQuantity() + 1);
                productExists = true;
            }
            total += item.getPrice() * item.getQuantity();
            num += 1;
        }

        //them san pham vao gio hang, neu san pham chua ton tai trong gio hang, cap nhat quantity = 1, cap nhat thành tièn cua gio hàng
        if (!productExists) {
            p.setQuantity(1);
            cart.add(p);
            total += p.getPrice();
            num += 1;
        }

        session.setAttribute("total", total);
        session.setAttribute("cart", cart);
        session.setAttribute("num", num);
        request.getRequestDispatcher("content").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Vector<Products> cart = (Vector<Products>) session.getAttribute("cart");

        if (request.getParameter("productID") != null) {
            // Xử lý tăng/giảm số lượng sản phẩm dựa trên productId
            int productId = Integer.parseInt(request.getParameter("productID"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            if (quantity <= 0) {
                // Nếu số lượng là 0 hoặc âm, xóa sản phẩm khỏi giỏ hàng
                for (Products item : cart) {
                    if (item.getID() == productId) {
                        cart.remove(item);
                        break;
                    }
                }
            } else {
                // Cập nhật số lượng sản phẩm
                for (Products item : cart) {
                    if (item.getID() == productId) {
                        item.setQuantity(quantity);
                        break;
                    }
                }
            }
        } else if (request.getParameter("removeAll") != null) {
            // Xử lý xóa toàn bộ giỏ hàng
            cart.clear();
        }

        // Tính lại tổng tiền và tổng số lượng sản phẩm
        int total = 0;
        int num = 0;
        for (Products item : cart) {
            total += item.getPrice() * item.getQuantity();
            num += item.getQuantity();
        }

        // Lưu lại giỏ hàng đã được cập nhật
        session.setAttribute("cart", cart);
        // Đặt lại tổng tiền và tổng số lượng sản phẩm
        session.setAttribute("total", total);
        session.setAttribute("num", num);

        // Gửi phản hồi về trang cart.jsp sau khi xử lý
        response.sendRedirect("cart.jsp");
    }

}
