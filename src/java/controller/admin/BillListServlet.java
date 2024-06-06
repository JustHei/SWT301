package controller.admin;

import dao.OrdersDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.Orders;

@WebServlet(name = "BillListServlet", urlPatterns = {"/billlist"})

public class BillListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OrdersDAO od = new OrdersDAO();
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int txt = Integer.parseInt(request.getParameter("odid"));

        OrdersDAO od = new OrdersDAO();
        List<Orders> list = od.getAllOrders();
        List<Orders> listO = new ArrayList<>();
        for (Orders o : list) {
            if(o.getID() == txt){
                listO.add(o);
            }
        }

        request.setAttribute("listO", listO);
        request.getRequestDispatcher("bill-manager.jsp").forward(request, response);
    }

}
