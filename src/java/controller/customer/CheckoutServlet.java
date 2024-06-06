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
import java.time.LocalDate;

@WebServlet(name = "CheckoutServlet", urlPatterns = {"/checkout"})
public class CheckoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //gọi ra dữ liệu của phiên người dùng hiện tại
        HttpSession session = request.getSession();
        Users u = (Users) session.getAttribute("user");

        // thong tin nguoi mua
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        // lay ra gio hang hien tai
        List<Products> cart = (List<Products>) session.getAttribute("cart");
        
        // tinh tong tien cua gio hang/ don hàng
        int total = 0;
        for (Products cartProduct : cart) {
            total += cartProduct.getPrice() * cartProduct.getQuantity();
        }
        // ngay mua
        LocalDate date = LocalDate.now();

        // Tạo đơn hàng
        OrdersDAO od = new OrdersDAO();
        Orders order = new Orders(u.getID(), name, phone, address, date, total);
        od.createOrder(order);

        // Tạo các mặt hàng trong đơn hàng (OrderItems)
        OrderItemsDAO oid = new OrderItemsDAO();
        for (Products p : cart) {
            oid.insert(p.getID(), p.getQuantity());
        }

        // cap nhat lai gio hàng sau khi dã mua: xóa các san pham trong gio hang và thành tien cua gio hàng
        session.removeAttribute("cart");
        session.removeAttribute("total");
        session.removeAttribute("num");

        request.setAttribute("mess", "Order success !");
      
        
        request.getRequestDispatcher("content").forward(request, response);

    }

}
