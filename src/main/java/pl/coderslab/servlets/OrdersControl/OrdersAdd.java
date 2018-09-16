package pl.coderslab.servlets.OrdersControl;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.OrderDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.models.Employee;
import pl.coderslab.models.Order;
import pl.coderslab.models.Status;
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
import java.util.List;



@WebServlet(name = "OrdersAdd", urlPatterns = "/admin/orders-add")

public class OrdersAdd extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String recievedStr = request.getParameter("recieved");

        String planedBeginningStr = request.getParameter("planedBeginning");

        String begunStr = request.getParameter("begun");

        String employeeIdStr = request.getParameter("employeeId");

        String problemDescription = request.getParameter("problemDescription");

        String repairDescription = request.getParameter("repairDescription");

        String statusStr = request.getParameter("status");

        String vehicleIdStr = request.getParameter("vehicleId");

        String priceStr = request.getParameter("price");

        String expensesStr = request.getParameter("expenses");

        String manhoursStr = request.getParameter("manhours");





        LocalDate recieved;

        LocalDate planedBeginning = null;

        LocalDate begun = null;

        Status status;

        Float price = null;

        Float expenses = null;

        Integer manhours = null;

        try {

            recieved = LocalDate.parse(recievedStr);



            if (planedBeginningStr != null && !planedBeginningStr.isEmpty()) {

                try {

                    planedBeginning = LocalDate.parse(planedBeginningStr);

                } catch (DateTimeParseException ignored) {

                }

            }

            if (begunStr != null && !begunStr.isEmpty()) {

                try {

                    begun = LocalDate.parse(begunStr);

                } catch (DateTimeParseException ignored) {

                }

            }

            Employee employee = EmployeeDao.loadById(Integer.parseInt(employeeIdStr));

            status = Status.valueOf(statusStr);

            Vehicle vehicle = VehicleDao.loadById(Integer.parseInt(vehicleIdStr));



            if (priceStr != null && !priceStr.isEmpty()) {

                try {

                    price = Float.valueOf(priceStr);

                } catch (DateTimeParseException ignored) {

                }

            }

            if (expensesStr != null && !expensesStr.isEmpty()) {

                try {

                    expenses = Float.valueOf(expensesStr);

                } catch (DateTimeParseException ignored) {

                }

            }

            if (manhoursStr != null && !manhoursStr.isEmpty()) {

                try {

                    manhours = Integer.valueOf(manhoursStr);

                } catch (NumberFormatException ignored) {

                }

            }



            Order order = new Order(recieved, planedBeginning, begun, employee, problemDescription, repairDescription, status, vehicle, price, expenses, manhours);

            System.out.println(order);

            OrderDao.save(order);



        } catch (DateTimeParseException | NumberFormatException e) {

        }



        response.sendRedirect("/admin/orders-show");

    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Vehicle> vehicles = VehicleDao.loadAll();

        ArrayList<Employee> employees = EmployeeDao.loadAll();



        request.setAttribute("employees", employees);

        request.setAttribute("vehicles", vehicles);

        request.setAttribute("statuses", Status.values());



        getServletContext().getRequestDispatcher("/WEB-INF/OrdersView/OrdersForm.jsp").forward(request, response);

    }

}
