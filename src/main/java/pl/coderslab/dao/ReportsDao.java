package pl.coderslab.dao;

import pl.coderslab.services.DbService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class ReportsDao {

    public static List<String[]> reportEmployeeManhours(LocalDate from, LocalDate to) throws SQLException {

        //language=MySQL

        String queryAny = "SELECT crm.employees.name, crm.employees.surname, sum(orders.manhours)\n" +

                "FROM crm.employees\n" +

                "       JOIN crm.orders ON employees.id = orders.employee_id\n" +

                "GROUP BY orders.employee_id";

        //language=MySQL

        String queryFrom = "SELECT crm.employees.name, crm.employees.surname, sum(orders.manhours)\n" +

                "FROM crm.employees\n" +

                "       JOIN crm.orders ON employees.id = orders.employee_id\n" +

                "WHERE orders.begun >= ?\n" +

                "GROUP BY orders.employee_id";

        //language=MySQL

        String queryTo = "SELECT crm.employees.name, crm.employees.surname, sum(orders.manhours)\n" +

                "FROM crm.employees\n" +

                "       JOIN crm.orders ON employees.id = orders.employee_id\n" +

                "WHERE orders.begun <= ?\n" +

                "GROUP BY orders.employee_id";

        //language=MySQL

        String queryBetween = "SELECT crm.employees.name, crm.employees.surname, sum(orders.manhours)\n" +

                "FROM crm.employees\n" +

                "       JOIN crm.orders ON employees.id = orders.employee_id\n" +

                "WHERE orders.begun BETWEEN ? AND ?\n" +

                "GROUP BY orders.employee_id";



        if (from != null && to != null) {

            return DbService.getData(queryBetween, from.toString(), to.toString());

        } else if (from != null) {

            return DbService.getData(queryFrom, from.toString());

        } else if (to != null) {

            return DbService.getData(queryTo, to.toString());

        } else {

            return DbService.getData(queryAny);

        }

    }



    public static List<String[]> reportProfit(LocalDate from, LocalDate to) throws SQLException {

        //language=MySQL

        String queryAny = "SELECT orders.id, orders.price - orders.expense - orders.manhours * employees.manhourValue\n" +

                "FROM crm.employees\n" +

                "       JOIN crm.orders ON employees.id = orders.employee_id";

        //language=MySQL

        String queryFrom = "SELECT orders.id, orders.price-orders.expense-orders.manhours*employees.manhourValue\n" +

                "FROM crm.employees JOIN crm.orders ON employees.id = orders.employee_id\n" +

                "WHERE orders.begun >= ?";

        //language=MySQL

        String queryTo = "SELECT orders.id, orders.price - orders.expense - orders.manhours * employees.manhourValue\n" +

                "FROM crm.employees\n" +

                "       JOIN crm.orders ON employees.id = orders.employee_id\n" +

                "WHERE orders.begun <= ?";

        //language=MySQL

        String queryBetween = "SELECT orders.id, orders.price - orders.expense - orders.manhours * employees.manhourValue\n" +

                "FROM crm.employees\n" +

                "       JOIN crm.orders ON employees.id = orders.employee_id\n" +

                "WHERE orders.begun BETWEEN ? AND ?";



        if (from != null && to != null) {

            return DbService.getData(queryBetween, from.toString(), to.toString());

        } else if (from != null) {

            return DbService.getData(queryFrom, from.toString());

        } else if (to != null) {

            return DbService.getData(queryTo, to.toString());

        } else {

            return DbService.getData(queryAny);

        }

    }

}