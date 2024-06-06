package controller.admin;

import dao.OrderItemsDAO;
import dao.OrdersDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.OrderItems;
import model.Orders;

@WebServlet(name = "BillActionsServlet", urlPatterns = {"/billactions"})

public class BillActionsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // lay thong tin chi tiet orderItems cua 1 order
        int odid = Integer.parseInt(request.getParameter("odid"));
        OrderItemsDAO oid = new OrderItemsDAO();
        List<OrderItems> detail = oid.getOdDetailByOdId(odid);
        request.setAttribute("detail", detail);
        
        OrdersDAO od = new OrdersDAO();
        Orders o = od.getOrderByOdId(odid);
        request.setAttribute("o", o);

        request.getRequestDispatcher("bill-details.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int odid = Integer.parseInt(request.getParameter("odid"));
        OrdersDAO od = new OrdersDAO();
        od.nextStatus(odid);
        
        List<Orders> listO = new ArrayList<>();
        String strUid = request.getParameter("uid");
        
        if (strUid == null) {
            // lay ra danh sách tat ca order
            listO = od.getAllOrders();
            request.setAttribute("listO", listO);
            request.getRequestDispatcher("bill-manager.jsp").forward(request, response);
        } else {
            // lay ra danh sách  order theo customer
            int uid = Integer.parseInt(strUid);
            listO = od.getOrderByUserID(uid);
            request.setAttribute("listO", listO);
            request.getRequestDispatcher("order-history.jsp").forward(request, response);
        }

       

    }

}
