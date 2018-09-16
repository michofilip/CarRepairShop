package pl.coderslab.servlets.EmployeesControl;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.models.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeesAdd", urlPatterns = "/admin/employee-add")

public class EmployeesAdd extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String note = request.getParameter("note");
        Float manhourValue = Float.parseFloat(request.getParameter("manhourValue"));

        Employee employee = new Employee(name, surname, address, phone, note, manhourValue);
        EmployeeDao.save(employee);

        response.sendRedirect("/admin/employees-show");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/EmployeeView/employeesform.jsp").forward(request, response);

    }

}
