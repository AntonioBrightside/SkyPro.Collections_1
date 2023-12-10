package com.amam.collections1.services;

import com.amam.collections1.services.for_services.Employee;

import java.util.Collection;
import java.util.Map;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName, int unit, float salary);

    Employee removeEmployee(int key);

    Employee findEmployee(int key);

    String getEmployees();

    Map<Integer, Employee> getEmployeesBook();
}
