package pl.coderslab.servlets;

import pl.coderslab.dao.OrderDao;
import pl.coderslab.models.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Index", urlPatterns = "/admin/index")
public class Index extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Order> orders = OrderDao.loadInProgress();
        request.setAttribute("orders", orders);
        getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        System.out.println(orders.get(0));
    }
}
