package pl.coderslab.servlets.EmployeesControl;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.models.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "EmployeesShow", urlPatterns = "/admin/employees-show")

public class EmployeesShow extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Employee> employees = new ArrayList<>();

        String idStr = request.getParameter("id");
        if (idStr != null) {
            try {
                int id = Integer.parseInt(idStr);
                employees.add(EmployeeDao.loadById(id));
            } catch (NumberFormatException ignored) {
            }
        } else {
            employees = EmployeeDao.loadAll();
        }

        request.setAttribute("employees", employees);
        getServletContext().getRequestDispatcher("/WEB-INF/EmployeeView/employees.jsp").forward(request, response);
    }

}


