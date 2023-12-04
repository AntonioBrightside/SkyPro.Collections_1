package com.amam.collections1;

import com.amam.collections1.exceptions.EmployeeAlreadyAddedException;
import com.amam.collections1.exceptions.EmployeeBookIsEmpty;
import com.amam.collections1.exceptions.EmployeeNotFoundException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EmployeeBook {

    private final Map<Integer, Employee> employeesBook;
    private int id;

    /**
     * Словарь сотрудников
     *
     * @param employees [Employee] сотрудник / сотрудники
     */
    public EmployeeBook() {
        employeesBook = new HashMap<>();
    }

    /**
     * Проверят список сотрудников на дублирование при добавлении
     * @param o [Employee] сотрудник
     * @return [boolean]
     */
    private boolean isAlreadyIn(Employee o) {
        for (Employee employee : employeesBook.values()) {
            if (employee != null && employee.equals(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Возвращает список сотрудников.
     *
     * @return [Employee[]] список сотрудников
     */
    public Collection<Employee> getEmployeesBook() {
        if (employeesBook.isEmpty()) {
            throw new EmployeeBookIsEmpty("В компании никто не работает");
        } else {
            return employeesBook.values();
        }
    }

    /**
     * Добавляет сотрудника в базу / словарь
     * @param employee [Employee] сотрудник
     */
    public void add(Employee employee) {
        if (isAlreadyIn(employee)) {
            throw new EmployeeAlreadyAddedException("Данный пользователь уже существует в базе");
        } else {
            employeesBook.put(id, employee);
            id++;
        }
    }

    /**
     * Находит и возвращает пользователя
     * @param key ключ / индекс
     * @return пользователь
     */
    public Employee find(Integer key) {
        try {
            return employeesBook.get(key);
        } catch (Exception e) {
            throw new EmployeeNotFoundException("Данный пользователь отсутствует в базе");
        }
    }

    /**
     * Удаляет пользователя и возвращает его в браузер
     * @param key ключ / индекс
     * @return пользователь
     */
    public Employee remove(Integer key) {
        try {
            Employee employee = employeesBook.get(key);
            employeesBook.remove(key);
            return employee;

        } catch (Exception e) {
            throw new EmployeeNotFoundException("Данный пользователь отсутствует в базе");
        }
    }
}

