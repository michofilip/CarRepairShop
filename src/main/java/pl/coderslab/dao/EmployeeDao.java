package pl.coderslab.dao;

import pl.coderslab.models.Employee;
import pl.coderslab.services.DbService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    private static Employee makeEmployee(String[] strs) {
        return new Employee()
                .setId(Integer.parseInt(strs[0]))
                .setName(strs[1])
                .setSurname(strs[2])
                .setAddress(strs[3])
                .setPhone(strs[4])
                .setNote(strs[5])
                .setManhourValue(Float.parseFloat(strs[6]));
    }

    private static Employee loadOne(String query, String... parameters) {
        try {
            List<String[]> list = DbService.getData(query, parameters);
            if (!list.isEmpty()) {
                return makeEmployee(list.get(0));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static ArrayList<Employee> loadMany(String query, String... parameters) {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            List<String[]> list = DbService.getData(query, parameters);
            list.forEach(item -> employees.add(makeEmployee(item)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    // crud
    public static ArrayList<Employee> loadAll() {
        //language=MySQL
        String query = "SELECT * FROM employees";
        return loadMany(query);
    }

    public static Employee loadById(int id) {
        //language=MySQL
        String query = "SELECT * FROM employees WHERE id = ?";
        return loadOne(query, String.valueOf(id));
    }

    public static void save(Employee employee) {
        List<String> parameters = new ArrayList<>();
        parameters.add(employee.getName());
        parameters.add(employee.getSurname());
        parameters.add(employee.getAddress());
        parameters.add(employee.getPhone());
        parameters.add(employee.getNote());
        parameters.add(String.valueOf(employee.getManhourValue()));

        if (employee.getId() == 0) {
            //language=MySQL
            String query = "INSERT INTO employees(name, surname, address, phone, note, manhourValue) VALUES(?, ?, ?, ?, ?, ?)";

            try {
                Integer id = DbService.insertIntoDatabase(query, parameters);
                if (id != null) {
                    employee.setId(id);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            //language=MySQL
            String query = "UPDATE employees SET name = ?, surname = ?, address = ?, phone = ?, note = ?, manhourValue = ? WHERE id = ?";

            try {
                parameters.add(String.valueOf(employee.getId()));
                DbService.executeUpdate(query, parameters);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void delete(int id) {
        if (id != 0) {
            //language=MySQL
            String query = "DELETE FROM employees WHERE id = ?";

            try {
                DbService.executeUpdate(query, String.valueOf(id));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
