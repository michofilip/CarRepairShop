//package pl.coderslab.dao_old;
//
//import pl.coderslab.models.Employee;
//import pl.coderslab.services.DbService;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class EmployeeDao {
//    public static ArrayList<Employee> loadAll() {
//        ArrayList<Employee> employees = new ArrayList<>();
//
//        //language=MySQL
//        String query = "SELECT * FROM employees";
//
//        try {
//            List<String[]> list = DbService.getData(query);
//            for (String[] item : list) {
//                Employee employee = new Employee()
//                        .setId(Integer.parseInt(item[0]))
//                        .setName(item[1])
//                        .setSurname(item[2])
//                        .setAddress(item[3])
//                        .setPhone(item[4])
//                        .setNote(item[5])
//                        .setManhourValue(Float.parseFloat(item[6]));
//
//                employees.add(employee);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return employees;
//    }
//
//    public static Employee loadById(int id) {
//        //language=MySQL
//        String query = "SELECT * FROM employees WHERE id = ?";
//
//        try {
//            List<String[]> list = DbService.getData(query, String.valueOf(id));
//
//            if (!list.isEmpty()) {
//                String[] item = list.get(0);
//
//                return new Employee()
//                        .setId(Integer.parseInt(item[0]))
//                        .setName(item[1])
//                        .setSurname(item[2])
//                        .setAddress(item[3])
//                        .setPhone(item[4])
//                        .setNote(item[5])
//                        .setManhourValue(Float.parseFloat(item[6]));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//    public static void save(Employee employee) {
//        if (employee.getId() == 0) {
//            //language=MySQL
//            String query = "INSERT INTO employees(name, surname, address, phone, note, manhourValue) VALUES(?, ?, ?, ?, ?, ?)";
//
//            try {
//                Integer id = DbService.insertIntoDatabase(query,
//                        employee.getName(),
//                        employee.getSurname(),
//                        employee.getAddress(),
//                        employee.getPhone(),
//                        employee.getNote(),
//                        String.valueOf(employee.getManhourValue()));
//                if (id != null) {
//                    employee.setId(id);
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        } else {
//            //language=MySQL
//            String query = "UPDATE employees SET name = ?, surname = ?, address = ?, phone = ?, note = ?, manhourValue = ? WHERE id = ?";
//
//            try {
//                DbService.executeUpdate(query,
//                        employee.getName(),
//                        employee.getSurname(),
//                        employee.getAddress(),
//                        employee.getPhone(),
//                        employee.getNote(),
//                        String.valueOf(employee.getManhourValue()),
//                        String.valueOf(employee.getId()));
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public static void delete(int id) {
//        if (id != 0) {
//            //language=MySQL
//            String query = "DELETE FROM employees WHERE id = ?";
//
//            try {
//                DbService.executeUpdate(query, String.valueOf(id));
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
