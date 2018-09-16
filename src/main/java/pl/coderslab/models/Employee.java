package pl.coderslab.models;

public class Employee {
    private int id;
    private String name;
    private String surname;
    private String address;
    private String phone;
    private String note;
    private float manhourValue;

    public Employee() {
        this.id = 0;
    }

    public Employee(String name, String surname, String address, String phone, String note, float manhourValue) {
        this(0, name, surname, address, phone, note, manhourValue);
    }

    public Employee(int id, String name, String surname, String address, String phone, String note, float manhourValue) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.note = note;
        this.manhourValue = manhourValue;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", note='" + note + '\'' +
                ", manhourValue=" + manhourValue +
                '}';
    }

    public int getId() {
        return id;
    }

    public Employee setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Employee setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Employee setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Employee setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getNote() {
        return note;
    }

    public Employee setNote(String note) {
        this.note = note;
        return this;
    }

    public float getManhourValue() {
        return manhourValue;
    }

    public Employee setManhourValue(float manhourValue) {
        this.manhourValue = manhourValue;
        return this;
    }
}