package pl.coderslab.servlets.VehicleControl;

import pl.coderslab.dao.VehicleDao;
import pl.coderslab.models.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "VehicleShow", urlPatterns = "/admin/vehicles-show")
public class VehicleShow extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        String idStr = request.getParameter("id");
        String ownerIdStr = request.getParameter("ownerId");
        if (idStr != null) {
            try {
                int id = Integer.parseInt(idStr);
                vehicles.add(VehicleDao.loadById(id));
            } catch (NumberFormatException ignored) {
            }
        } else if (ownerIdStr != null) {
            try {
                int ownerId = Integer.parseInt(ownerIdStr);
                vehicles = VehicleDao.loadByOwnerId(ownerId);
            } catch (NumberFormatException ignored) {
            }
        } else {
            vehicles = VehicleDao.loadAll();
        }

        request.setAttribute("vehicles", vehicles);
        getServletContext().getRequestDispatcher("/WEB-INF/VehicleView/vehicles.jsp").forward(request, response);
    }
}
