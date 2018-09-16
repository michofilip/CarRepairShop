package pl.coderslab.servlets.VehicleControl;

import pl.coderslab.dao.VehicleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "VehicleDelete", urlPatterns = "/admin/vehicle-delete")
public class VehicleDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        try {
            int id = Integer.parseInt(idStr);
            VehicleDao.delete(id);
        } catch (NumberFormatException ignored) {
        }
        response.sendRedirect("/admin/vehicles-show");
    }
}
