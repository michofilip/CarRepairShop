package pl.coderslab.servlets.OrdersControl;

import pl.coderslab.dao.OrderDao;
import pl.coderslab.models.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "OrdersShow", urlPatterns = "/admin/orders-show")
public class OrdersShow extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Order> orders = new ArrayList<>();

        String idStr = request.getParameter("id");
        String employeeIdStr = request.getParameter("employeeId");
        if (idStr != null) {
            try {
                int id = Integer.parseInt(idStr);
                orders.add(OrderDao.loadById(id));
            } catch (NumberFormatException ignored) {
            }
        } else if (employeeIdStr != null) {
            try {
                int employeeId = Integer.parseInt(employeeIdStr);
                orders = OrderDao.loadByEmployeeId(employeeId);
            } catch (NumberFormatException ignored) {
            }
        } else {
            orders = OrderDao.loadAll();
        }

        request.setAttribute("orders", orders);
        getServletContext().getRequestDispatcher("/WEB-INF/OrdersView/orders.jsp").forward(request, response);
    }
}
