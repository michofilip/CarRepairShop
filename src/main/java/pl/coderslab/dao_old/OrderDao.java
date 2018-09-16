//package pl.coderslab.dao_old;
//
//import pl.coderslab.dao.EmployeeDao;
//import pl.coderslab.models.Order;
//import pl.coderslab.models.Status;
//import pl.coderslab.services.DbService;
//
//import java.sql.SQLException;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//public class OrderDao {
//    public static ArrayList<Order> loadAll() {
//        ArrayList<Order> orders = new ArrayList<>();
//
//        //language=MySQL
//        String query = "SELECT * FROM orders";
//
//        try {
//            List<String[]> list = DbService.getData(query);
//            for (String[] item : list) {
//                Order order = new Order()
//                        .setId(Integer.parseInt(item[0]))
//                        .setReceived(LocalDate.parse(item[1]))
//                        .setPlanedBeginning(LocalDate.parse(item[2]))
//                        .setBegun(LocalDate.parse(item[3]))
//                        .setEmployee(EmployeeDao.loadById(Integer.parseInt(item[4])))
//                        .setProblemDescription(item[5])
//                        .setRepairDescription(item[6])
//                        .setStatus(Status.valueOf(item[7]))
//                        .setVehicle(VehicleDao.loadById(Integer.parseInt(item[8])))
//                        .setPrice(Float.parseFloat(item[9]))
//                        .setExpense(Float.parseFloat(item[10]))
//                        .setManhours(Integer.parseInt(item[11]));
//
//                orders.add(order);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return orders;
//    }
//
//    public static Order loadById(int id) {
//        //language=MySQL
//        String query = "SELECT * FROM orders WHERE id = ?";
//
//        try {
//            List<String[]> list = DbService.getData(query, String.valueOf(id));
//
//            if (!list.isEmpty()) {
//                String[] item = list.get(0);
//
//                return new Order()
//                        .setId(Integer.parseInt(item[0]))
//                        .setReceived(LocalDate.parse(item[1]))
//                        .setPlanedBeginning(LocalDate.parse(item[2]))
//                        .setBegun(LocalDate.parse(item[3]))
//                        .setEmployee(EmployeeDao.loadById(Integer.parseInt(item[4])))
//                        .setProblemDescription(item[5])
//                        .setRepairDescription(item[6])
//                        .setStatus(Status.valueOf(item[7]))
//                        .setVehicle(VehicleDao.loadById(Integer.parseInt(item[8])))
//                        .setPrice(Float.parseFloat(item[9]))
//                        .setExpense(Float.parseFloat(item[10]))
//                        .setManhours(Integer.parseInt(item[11]));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//    public static void save(Order order) {
//        if (order.getId() == 0) {
//            //language=MySQL
//            String query = "INSERT INTO orders (received,\n" +
//                    "                    planedBeginning,\n" +
//                    "                    begun,\n" +
//                    "                    employee_id,\n" +
//                    "                    problemDescription,\n" +
//                    "                    repairDescription,\n" +
//                    "                    status,\n" +
//                    "                    vehicle_id,\n" +
//                    "                    price,\n" +
//                    "                    expense,\n" +
//                    "                    manhours)\n" +
//                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//
//            try {
//                Integer id = DbService.insertIntoDatabase(query,
//                        order.getReceived().toString(),
//                        order.getPlanedBeginning().toString(),
//                        order.getBegun().toString(),
//                        String.valueOf(order.getEmployee().getId()),
//                        order.getProblemDescription(),
//                        order.getRepairDescription(),
//                        order.getStatus().toString(),
//                        String.valueOf(order.getVehicle().getId()),
//                        String.valueOf(order.getPrice()),
//                        String.valueOf(order.getExpense()),
//                        String.valueOf(order.getManhours()));
//                if (id != null) {
//                    order.setId(id);
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        } else {
//            //language=MySQL
//            String query = "UPDATE orders\n" +
//                    "SET received           = ?,\n" +
//                    "    planedBeginning    = ?,\n" +
//                    "    begun              = ?,\n" +
//                    "    employee_id        = ?,\n" +
//                    "    problemDescription = ?,\n" +
//                    "    repairDescription  = ?,\n" +
//                    "    status             = ?,\n" +
//                    "    vehicle_id         = ?,\n" +
//                    "    price              = ?,\n" +
//                    "    expense            = ?,\n" +
//                    "    manhours           = ?\n" +
//                    "WHERE id = ?";
//
//            try {
//                DbService.executeUpdate(query,
//                        order.getReceived().toString(),
//                        order.getPlanedBeginning().toString(),
//                        order.getBegun().toString(),
//                        String.valueOf(order.getEmployee().getId()),
//                        order.getProblemDescription(),
//                        order.getRepairDescription(),
//                        order.getStatus().toString(),
//                        String.valueOf(order.getVehicle().getId()),
//                        String.valueOf(order.getPrice()),
//                        String.valueOf(order.getExpense()),
//                        String.valueOf(order.getManhours()),
//                        String.valueOf(order.getId()));
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public static void delete(int id) {
//        if (id != 0) {
//            //language=MySQL
//            String query = "DELETE FROM orders WHERE id = ?";
//
//            try {
//                DbService.executeUpdate(query, String.valueOf(id));
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
