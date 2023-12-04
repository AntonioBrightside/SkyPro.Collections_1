package com.amam.collections1;

import java.util.Objects;


public class Employee {

    private final String firstName;
    private final String secondName;
    private final String unit;
    private final String salary;


    public Employee(String firstName, String secondName, String unit, String salary) {
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

    public String getUnit() {
        return unit;
    }

    public String getSalary() {
        return salary;
    }


    @Override
    public String toString() {
        return firstName + " " + secondName + " [подразделение: " + unit + ", з/п: " + salary + " руб.]";
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