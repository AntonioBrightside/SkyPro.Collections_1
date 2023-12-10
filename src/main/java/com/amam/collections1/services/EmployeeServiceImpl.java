package com.amam.collections1.services;

import com.amam.collections1.exceptions.EmployeeAlreadyAddedException;
import com.amam.collections1.exceptions.EmployeeNotFoundException;
import com.amam.collections1.services.for_services.Employee;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<Integer, Employee> employeesBook;
    private int id;

    public EmployeeServiceImpl() {
        this.employeesBook = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int unit, float salary) {
        Employee employee = new Employee(firstName, lastName, unit, salary);

        if (isAlreadyIn(employee)) {
            throw new EmployeeAlreadyAddedException("Данный пользователь уже существует в базе");
        } else {
            employeesBook.put(id, employee);
            id++;
        }

        return employee;
    }

    @Override
    public Employee findEmployee(int key) {
        if (isAlreadyIn(key)) {
            return employeesBook.get(key);
        } else {
            throw new EmployeeNotFoundException("Данный пользователь отсутствует в базе");
        }

    }

    @Override
    public Employee removeEmployee(int key) {
        if (isAlreadyIn(key)) {
            Employee employee = employeesBook.get(key);
            employeesBook.remove(key);
            return employee;
        } else {
            throw new EmployeeNotFoundException("Данный пользователь отсутствует в базе");
        }
    }

    /**
     * Возвращает коллекцию всех сотрудников
     * @return коллекция сотрудников
     */
    @Override
    public String getEmployees() {
        return employeesBook.toString();
    }



    /**
     * Проверят список сотрудников на дублирование при добавлении
     * @param o [Employee] сотрудник
     * @return [boolean]
     */
    private boolean isAlreadyIn(Employee o) {
        return employeesBook.values().stream().anyMatch(e -> e.equals(o));
    }

    /**
     * Проверяет список ключей / id сотрудников на наличие в базе
     * @param key ключ / id
     * @return true or false
     */
    private boolean isAlreadyIn(int key) {
        return employeesBook.keySet().stream().anyMatch(e -> Objects.equals(e, key));
    }

    @Override
    public Map<Integer, Employee> getEmployeesBook() {
        return employeesBook;
    }
}
