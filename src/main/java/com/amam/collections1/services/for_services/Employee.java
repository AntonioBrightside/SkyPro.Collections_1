package com.amam.collections1.services.for_services;

import java.util.Objects;


public class Employee {

    private final String firstName;
    private final String secondName;
    private final int unit;
    private final float salary;

    public Employee(String firstName, String secondName, int unit, float salary) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.unit = unit;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getUnit() {
        return unit;
    }

    public float getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return firstName + " " + secondName + " [подразделение: " + unit + ", з/п: " + String.format("%,.2f", salary) + " руб.]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(secondName, employee.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName);
    }

}