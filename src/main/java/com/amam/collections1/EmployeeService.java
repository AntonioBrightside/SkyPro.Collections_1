package com.amam.collections1;

import com.amam.collections1.exceptions.EmployeeAlreadyAddedException;
import com.amam.collections1.exceptions.EmployeeNotFoundException;
import com.amam.collections1.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeeService {

    private EmployeeBook employeeBook;

    public EmployeeService() {
        this.employeeBook = new EmployeeBook();
    }

    public Employee addEmployee(String firstName, String lastName, String unit, String salary) {
        Employee employee = new Employee(firstName, lastName, unit, salary);

        employeeBook.add(employee);
        return employee;
    }

    public Employee findEmployee(Integer key) {
        return employeeBook.find(key);
    }

    public Employee removeEmployee(Integer key) {
        return employeeBook.remove(key);
    }

    public Collection<Employee> getEmployees() {
        return employeeBook.getEmployeesBook();
    }
}
