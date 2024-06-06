package controller.guest;

import dao.*;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.*;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})

public class RegisterServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pass, cfpass, username;

        // lay ra thong tin nguoi dung input o form signup
        username = request.getParameter("username");
        pass = request.getParameter("password");
        cfpass = request.getParameter("cfpassword");

        // lay ra tat ca nhung tai khoan da ton tai trong he thong
        UsersDAO ud = new UsersDAO();
        List<Users> listU = ud.getAllUser();


        if (checkUserExist(username, listU)) {
            request.setAttribute("mess", "Username already exists");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else if (!pass.equals(cfpass)) {
            // kiem tra mat khau va nhap lai mat khau co khop nhau hay khong
            request.setAttribute("mess", "Password not match!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else {
            // neu khong co van de gì -> dang ky tai khoan thành công
            ud.Register(username, pass);
            request.getRequestDispatcher("content").forward(request, response);

        }

    }

    public static boolean checkUserExist(String username, List<Users> listU) {
        for (Users u : listU) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

}
