package pl.coderslab.servlets.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String loginForm = request.getParameter("login");
        String passwordForm = request.getParameter("password");

        String loginUser = getInitParameter("login");
        String passwordUser = getInitParameter("password");

        if (loginUser.equals(loginForm) && passwordUser.equals(passwordForm)) {
            session.setAttribute("username", loginUser);
        }

        response.sendRedirect("/admin/index");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
