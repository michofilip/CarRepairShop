package pl.coderslab.servlets.VehicleControl;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.models.Customer;
import pl.coderslab.models.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@WebServlet(name = "VehicleEdit", urlPatterns = "/admin/vehicle-edit")
public class VehicleEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String model = request.getParameter("model");
        String brand = request.getParameter("brand");
        String productionYearStr = request.getParameter("year");
        LocalDate nextCheckup = null;
        String customer_idStr = request.getParameter("ownerId");

        try {
            nextCheckup = LocalDate.parse(request.getParameter("checkup"));
        } catch (DateTimeParseException ignored) {
        }

        try {
            int id = Integer.parseInt(idStr);
            int productionYear = Integer.parseInt(productionYearStr);
            int customer_id = Integer.parseInt(customer_idStr);
            Customer customer = CustomerDao.loadById(customer_id);
            Vehicle vehicle = new Vehicle(id, model, brand, productionYear, nextCheckup, customer);
            VehicleDao.save(vehicle);
        } catch (NumberFormatException ignored) {
        }

        response.sendRedirect("/admin/vehicles-show");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        try {
            int id = Integer.parseInt(idStr);
            request.setAttribute("vehicle", VehicleDao.loadById(id));
            request.setAttribute("customers", CustomerDao.loadAll());
        } catch (NullPointerException | NumberFormatException ignored) {
        }



        getServletContext().getRequestDispatcher("/WEB-INF/VehicleView/VehicleEditForm.jsp").forward(request, response);
    }
}
