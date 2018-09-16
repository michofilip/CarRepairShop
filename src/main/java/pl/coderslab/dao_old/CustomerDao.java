//package pl.coderslab.dao_old;
//
//import pl.coderslab.models.Customer;
//import pl.coderslab.services.DbService;
//
//import java.sql.SQLException;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//public class CustomerDao {
//    public static ArrayList<Customer> loadAll() {
//        ArrayList<Customer> customers = new ArrayList<>();
//
//        //language=MySQL
//        String query = "SELECT * FROM customers";
//
//        try {
//            List<String[]> list = DbService.getData(query);
//            for (String[] item : list) {
//                Customer customer = new Customer()
//                        .setId(Integer.parseInt(item[0]))
//                        .setName(item[1])
//                        .setSurname(item[2])
//                        .setBirthday(LocalDate.parse(item[3]));
//
//                customers.add(customer);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return customers;
//    }
//
//    public static Customer loadById(int id) {
//        //language=MySQL
//        String query = "SELECT * FROM customers WHERE id = ?";
//
//        try {
//            List<String[]> list = DbService.getData(query, String.valueOf(id));
//
//            if (!list.isEmpty()) {
//                String[] item = list.get(0);
//
//                return new Customer()
//                        .setId(Integer.parseInt(item[0]))
//                        .setName(item[1])
//                        .setSurname(item[2])
//                        .setBirthday(LocalDate.parse(item[3]));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//    public static void save(Customer customer) {
//        if (customer.getId() == 0) {
//            //language=MySQL
//            String query = "INSERT INTO customers(name, surname, birthday) VALUES(?, ?, ?)";
//
//            try {
//                Integer id = DbService.insertIntoDatabase(query,
//                        customer.getName(),
//                        customer.getSurname(),
//                        customer.getBirthday().toString());
//                if (id != null) {
//                    customer.setId(id);
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        } else {
//            //language=MySQL
//            String query = "UPDATE customers SET name = ?, surname = ?, birthday = ? WHERE id = ?";
//
//            try {
//                DbService.executeUpdate(query,
//                        customer.getName(),
//                        customer.getSurname(),
//                        customer.getBirthday().toString(),
//                        String.valueOf(customer.getId()));
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public static void delete(int id) {
//        if (id != 0) {
//            //language=MySQL
//            String query = "DELETE FROM customers WHERE id = ?";
//
//            try {
//                DbService.executeUpdate(query, String.valueOf(id));
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
