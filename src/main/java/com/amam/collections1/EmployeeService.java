package com.amam.collections1;

import com.amam.collections1.exceptions.EmployeeAlreadyAddedException;
import com.amam.collections1.exceptions.EmployeeNotFoundException;
import com.amam.collections1.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeeService {
    private Set<Employee> employees;
    public static final int MAX_EMPLOYEES = 5;

    public EmployeeService() {
        employees = new HashSet<>();
    }

    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (employees.size() >= MAX_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("Количество сотрудников достигло максимума. Обсудите возможность добавление персонала с руководством");
        }

        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Такой пользователь уже работает в компании");
        }

        employees.add(employee);
        return employee;
    }

    public Employee findEmployee(String firstName, String lastName) {

        Employee employee = new Employee(firstName, lastName);

        if (employees.contains(employee)) {
            return employee;
        } else {
            throw new EmployeeNotFoundException("Такой пользователь не работает в компании");
        }
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        } else {
            throw new EmployeeNotFoundException("Такой пользователь не работает в компании и удалить его невозможно");
        }
    }

    public Set<Employee> getEmployees() {
        return employees;
    }
}
