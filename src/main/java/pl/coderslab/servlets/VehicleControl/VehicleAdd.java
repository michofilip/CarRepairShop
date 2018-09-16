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
import java.util.ArrayList;

@WebServlet(name = "VehicleAdd", urlPatterns = "/admin/vehicle-add")
public class VehicleAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            int productionYear = Integer.parseInt(productionYearStr);
            int customer_id = Integer.parseInt(customer_idStr);
            Customer customer = CustomerDao.loadById(customer_id);
            Vehicle vehicle = new Vehicle(model, brand, productionYear, nextCheckup, customer);
            System.out.println(vehicle);
            VehicleDao.save(vehicle);
        } catch (NumberFormatException ignored) {
        }

        response.sendRedirect("/admin/vehicles-show");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Customer> customers = CustomerDao.loadAll();
        request.setAttribute("customers", customers);
        getServletContext().getRequestDispatcher("/WEB-INF/VehicleView/VehicleForm.jsp").forward(request, response);
    }
}
