package pl.coderslab.servlets;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.OrderDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.models.Customer;
import pl.coderslab.models.Employee;
import pl.coderslab.models.Order;
import pl.coderslab.models.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

@WebServlet(name = "TestServlet", urlPatterns = "/test")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = new Customer("Name", "Surname", LocalDate.now().minusYears(20));
        Customer customer1 = new Customer("Name", "Surname", null);

//        System.out.println(customer.toString());
        CustomerDao.save(customer1);
//        System.out.println(customer.toString());
//        customer.setName("New name");
//        CustomerDao.save(customer);
//        System.out.println(customer.toString());
//        CustomerDao.delete(9);

        ArrayList<Customer> customers = CustomerDao.loadAll();
        ArrayList<Employee> employees = EmployeeDao.loadAll();
        ArrayList<Vehicle> vehicles = VehicleDao.loadAll();
        ArrayList<Order> orders = OrderDao.loadAll();
//        customers.forEach(System.out::println);


        request.setAttribute("customers", customers);
        request.setAttribute("employees", employees);
        request.setAttribute("vehicles", vehicles);
        request.setAttribute("orders", orders);
//        request.setAttribute("customer", CustomerDao.loadById(2));


        getServletContext().getRequestDispatcher("/test.jsp").forward(request, response);
    }
}
