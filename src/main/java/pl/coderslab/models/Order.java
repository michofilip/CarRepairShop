package pl.coderslab.models;

import java.time.LocalDate;

public class Order {
    private int id;
    private LocalDate received;
    private LocalDate planedBeginning;
    private LocalDate begun;
    private Employee employee;
    private String problemDescription;
    private String repairDescription;
    private Status status;
    private Vehicle vehicle;
    private Float price;
    private Float expense;
    private Integer manhours;

    public Order() {
        this.id = 0;
    }

    public Order(LocalDate received, LocalDate planedBeginning, LocalDate begun, Employee employee,
                 String problemDescription, String repairDescription, Status status, Vehicle vehicle,
                 Float price, Float expense, Integer manhours) {
        this(0, received, planedBeginning, begun, employee, problemDescription, repairDescription, status, vehicle, price, expense, manhours);
    }

    public Order(int id, LocalDate received, LocalDate planedBeginning, LocalDate begun, Employee employee,
                 String problemDescription, String repairDescription, Status status, Vehicle vehicle,
                 Float price, Float expense, Integer manhours) {
        this.id = id;
        this.received = received;
        this.planedBeginning = planedBeginning;
        this.begun = begun;
        this.employee = employee;
        this.problemDescription = problemDescription;
        this.repairDescription = repairDescription;
        this.status = status;
        this.vehicle = vehicle;
        this.price = price;
        this.expense = expense;
        this.manhours = manhours;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", received=" + received +
                ", planedBeginning=" + planedBeginning +
                ", begun=" + begun +
                ", employee=" + employee +
                ", problemDescription='" + problemDescription + '\'' +
                ", repairDescription='" + repairDescription + '\'' +
                ", status=" + status +
                ", vehicle=" + vehicle +
                ", price=" + price +
                ", expense=" + expense +
                ", manhours=" + manhours +
                '}';
    }

    public int getId() {
        return id;
    }

    public Order setId(int id) {
        this.id = id;
        return this;
    }

    public LocalDate getReceived() {
        return received;
    }

    public Order setReceived(LocalDate received) {
        this.received = received;
        return this;
    }

    public LocalDate getPlanedBeginning() {
        return planedBeginning;
    }

    public Order setPlanedBeginning(LocalDate planedBeginning) {
        this.planedBeginning = planedBeginning;
        return this;
    }

    public LocalDate getBegun() {
        return begun;
    }

    public Order setBegun(LocalDate begun) {
        this.begun = begun;
        return this;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Order setEmployee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public Order setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
        return this;
    }

    public String getRepairDescription() {
        return repairDescription;
    }

    public Order setRepairDescription(String repairDescription) {
        this.repairDescription = repairDescription;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public Order setStatus(Status status) {
        this.status = status;
        return this;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Order setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    }

    public Float getPrice() {
        return price;
    }

    public Order setPrice(Float price) {
        this.price = price;
        return this;
    }

    public Float getExpense() {
        return expense;
    }

    public Order setExpense(Float expense) {
        this.expense = expense;
        return this;
    }

    public Integer getManhours() {
        return manhours;
    }

    public Order setManhours(Integer manhours) {
        this.manhours = manhours;
        return this;
    }

    public Float getManhourValue() {
        if (employee != null) {
            return employee.getManhourValue();
        } else {
            return null;
        }
    }
}
