package pl.coderslab.servlets.Reports;

import pl.coderslab.dao.ReportsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

@WebServlet(name = "ReportManhours", urlPatterns = "/admin/report-manhours")
public class ReportManhours extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LocalDate from = null;
        LocalDate to = null;

        try {
            String fromStr = request.getParameter("from");
            if (fromStr != null) {
                from = LocalDate.parse(fromStr);
            }
        } catch (DateTimeParseException ignored) {
        }

        try {
            String toStr = request.getParameter("to");
            if (toStr != null) {
                to = LocalDate.parse(toStr);
            }
        } catch (DateTimeParseException ignored) {
        }

        try {
            List<String[]> report = ReportsDao.reportEmployeeManhours(from, to);
            request.setAttribute("from", from);
            request.setAttribute("to", to);
            request.setAttribute("report", report);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/WEB-INF/ReportsView/report-manhours.jsp").forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        getServletContext().getRequestDispatcher("/WEB-INF/ReportsView/report-manhours.jsp").forward(request, response);
    }
}
