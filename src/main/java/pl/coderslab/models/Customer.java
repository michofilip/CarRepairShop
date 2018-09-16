package pl.coderslab.models;

import java.time.LocalDate;

public class Customer {
    private int id;
    private String name;
    private String surname;
    private LocalDate birthday;

    public Customer() {
        this.id = 0;
    }

    public Customer(String name, String surname, LocalDate birthday) {
        this(0, name, surname, birthday);
    }

    public Customer(int id, String name, String surname, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public int getId() {
        return id;
    }

    public Customer setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Customer setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Customer setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }
}
