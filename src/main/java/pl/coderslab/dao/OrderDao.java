package pl.coderslab.dao;


import pl.coderslab.models.Order;
import pl.coderslab.models.Status;
import pl.coderslab.services.DbService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class OrderDao {

    private static Order makeOrder(String[] strs) {
        return new Order()
                .setId(Integer.parseInt(strs[0]))
                .setReceived(LocalDate.parse(strs[1]))
                .setPlanedBeginning(strs[2] != null ? LocalDate.parse(strs[2]) : null)
                .setBegun(strs[3] != null ? LocalDate.parse(strs[3]) : null)
                .setEmployee(strs[4] != null ? EmployeeDao.loadById(Integer.parseInt(strs[4])) : null)
                .setProblemDescription(strs[5])
                .setRepairDescription(strs[6])
                .setStatus(Status.valueOf(strs[7]))
                .setVehicle(VehicleDao.loadById(Integer.parseInt(strs[8])))
                .setPrice(strs[9] != null ? Float.valueOf(strs[9]) : null)
                .setExpense(strs[10] != null ? Float.valueOf(strs[10]) : null)
                .setManhours(strs[11] != null ? Integer.valueOf(strs[11]) : null);
    }

    private static Order loadOne(String query, String... parameters) {
        try {
            List<String[]> list = DbService.getData(query, parameters);
            if (!list.isEmpty()) {
                return makeOrder(list.get(0));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static ArrayList<Order> loadMany(String query, String... parameters) {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            List<String[]> list = DbService.getData(query, parameters);
            list.forEach(item -> orders.add(makeOrder(item)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    // crud
    public static ArrayList<Order> loadAll() {
        //language=MySQL
        String query = "SELECT *\n" +
                "FROM orders\n" +
                "ORDER BY received DESC ";
        return loadMany(query);
    }

    public static Order loadById(int id) {
        //language=MySQL
        String query = "SELECT * FROM orders WHERE id = ?";
        return loadOne(query, String.valueOf(id));
    }

    public static ArrayList<Order> loadLast(int limit) {
        //language=MySQL
        String query = "SELECT *\n" +
                "FROM orders\n" +
                "ORDER BY received DESC\n" +
                "LIMIT ?";
        return loadMany(query, String.valueOf(limit));
    }

    public static ArrayList<Order> loadByEmployeeId(int id) {
        //language=MySQL
        String query = "SELECT *\n" +
                "FROM orders\n" +
                "WHERE employee_id = ?";
        return loadMany(query, String.valueOf(id));
    }

    public static ArrayList<Order> loadInProgress() {
        //language=MySQL
        String query = "SELECT *" +
                "FROM orders\n" +
                "WHERE status = 'REPAIR_IN_PROGRESS'";
        return loadMany(query);
    }

    public static void save(Order order) {
        List<String> parameters = new ArrayList<>();
        parameters.add(order.getReceived().toString());
        parameters.add(order.getPlanedBeginning() != null ? order.getPlanedBeginning().toString() : null);
        parameters.add(order.getBegun() != null ? order.getBegun().toString() : null);
        parameters.add(order.getEmployee() != null ? String.valueOf(order.getEmployee().getId()) : null);
        parameters.add(order.getProblemDescription());
        parameters.add(order.getRepairDescription());
        parameters.add(order.getStatus().toString());
        parameters.add(String.valueOf(order.getVehicle().getId()));
        parameters.add(order.getPrice() != null ? String.valueOf(order.getPrice()) : null);
        parameters.add(order.getExpense() != null ? String.valueOf(order.getExpense()) : null);
        parameters.add(order.getManhours() != null ? String.valueOf(order.getManhours()) : null);

        if (order.getId() == 0) {
            //language=MySQL
            String query = "INSERT INTO orders (received,\n" +
                    "                    planedBeginning,\n" +
                    "                    begun,\n" +
                    "                    employee_id,\n" +
                    "                    problemDescription,\n" +
                    "                    repairDescription,\n" +
                    "                    status,\n" +
                    "                    vehicle_id,\n" +
                    "                    price,\n" +
                    "                    expense,\n" +
                    "                    manhours)\n" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try {
                Integer id = DbService.insertIntoDatabase(query, parameters);
                if (id != null) {
                    order.setId(id);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            //language=MySQL
            String query = "UPDATE orders\n" +
                    "SET received           = ?,\n" +
                    "    planedBeginning    = ?,\n" +
                    "    begun              = ?,\n" +
                    "    employee_id        = ?,\n" +
                    "    problemDescription = ?,\n" +
                    "    repairDescription  = ?,\n" +
                    "    status             = ?,\n" +
                    "    vehicle_id         = ?,\n" +
                    "    price              = ?,\n" +
                    "    expense            = ?,\n" +
                    "    manhours           = ?\n" +
                    "WHERE id = ?";
            try {
                parameters.add(String.valueOf(order.getId()));
                DbService.executeUpdate(query, parameters);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void delete(int id) {
        if (id != 0) {
            //language=MySQL
            String query = "DELETE FROM orders WHERE id = ?";

            try {
                DbService.executeUpdate(query, String.valueOf(id));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}