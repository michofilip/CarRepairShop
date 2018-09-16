package pl.coderslab.dao;

import pl.coderslab.models.Customer;
import pl.coderslab.services.DbService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    private static Customer makeCustomer(String[] strs) {
        return new Customer()
                .setId(Integer.parseInt(strs[0]))
                .setName(strs[1])
                .setSurname(strs[2])
                .setBirthday(strs[3] != null ? LocalDate.parse(strs[3]) : null);
    }

    private static Customer loadOne(String query, String... parameters) {
        try {
            List<String[]> list = DbService.getData(query, parameters);
            if (!list.isEmpty()) {
                return makeCustomer(list.get(0));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static ArrayList<Customer> loadMany(String query, String... parameters) {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            List<String[]> list = DbService.getData(query, parameters);
            list.forEach(item -> customers.add(makeCustomer(item)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    // crud
    public static ArrayList<Customer> loadAll() {
        //language=MySQL
        String query = "SELECT * FROM customers";
        return loadMany(query);
    }

    public static Customer loadById(int id) {
        //language=MySQL
        String query = "SELECT * FROM customers WHERE id = ?";
        return loadOne(query, String.valueOf(id));
    }

    public static void save(Customer customer) {
        List<String> parameters = new ArrayList<>();
        parameters.add(customer.getName());
        parameters.add(customer.getSurname());
        parameters.add(customer.getBirthday() != null ? customer.getBirthday().toString() : null);

        if (customer.getId() == 0) {
            //language=MySQL
            String query = "INSERT INTO customers(name, surname, birthday) VALUES(?, ?, ?)";

            try {
                Integer id = DbService.insertIntoDatabase(query, parameters);
                if (id != null) {
                    customer.setId(id);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            //language=MySQL
            String query = "UPDATE customers SET name = ?, surname = ?, birthday = ? WHERE id = ?";

            try {
                parameters.add(String.valueOf(customer.getId()));
                DbService.executeUpdate(query, parameters);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void delete(int id) {
        if (id != 0) {
            //language=MySQL
            String query = "DELETE FROM customers WHERE id = ?";

            try {
                DbService.executeUpdate(query, String.valueOf(id));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
