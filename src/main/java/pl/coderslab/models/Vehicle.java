package pl.coderslab.models;

import java.time.LocalDate;

public class Vehicle {
    private int id;
    private String model;
    private String brand;
    private int productionYear;
    private LocalDate nextCheckup;
    private Customer owner;

    public Vehicle() {
        this.id = 0;
    }

    public Vehicle(String model, String brand, int productionYear, LocalDate nextCheckup, Customer owner) {
        this(0, model, brand, productionYear, nextCheckup, owner);
    }

    public Vehicle(int id, String model, String brand, int productionYear, LocalDate nextCheckup, Customer owner) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.productionYear = productionYear;
        this.nextCheckup = nextCheckup;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", productionYear=" + productionYear +
                ", nextCheckup=" + nextCheckup +
                '}';
    }

    public int getId() {
        return id;
    }

    public Vehicle setId(int id) {
        this.id = id;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Vehicle setModel(String model) {
        this.model = model;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public Vehicle setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public Vehicle setProductionYear(int productionYear) {
        this.productionYear = productionYear;
        return this;
    }

    public LocalDate getNextCheckup() {
        return nextCheckup;
    }

    public Vehicle setNextCheckup(LocalDate nextCheckup) {
        this.nextCheckup = nextCheckup;
        return this;
    }

    public Customer getOwner() {
        return owner;
    }

    public Vehicle setOwner(Customer owner) {
        this.owner = owner;
        return this;
    }
}
