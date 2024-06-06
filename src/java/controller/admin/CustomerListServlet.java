package controller.admin;

import dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.*;

@WebServlet(name = "CustomerListServlet", urlPatterns = {"/customerlist"})

public class CustomerListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UsersDAO ud = new UsersDAO();
        List<Users> list = ud.getAllUser();
        List<Users> listU = new ArrayList<>();
        for (Users u : list) {
            if (u.getRole() == 2) {
                listU.add(u);
            }
        }
        request.setAttribute("listU", listU);
        request.getRequestDispatcher("customer-manager.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String txt = request.getParameter("txt");

        UsersDAO ud = new UsersDAO();
        List<Users> list = ud.getAllUser();
        List<Users> listU = new ArrayList<>();
        for (Users u : list) {
            if (u.getRole() == 2 && u.getUsername().contains(txt)) {
                listU.add(u);
            }
        }
        request.setAttribute("listU", listU);
        request.getRequestDispatcher("customer-manager.jsp").forward(request, response);

    }

}
