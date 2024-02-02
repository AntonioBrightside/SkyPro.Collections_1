package com.amam.collections1.services;

import com.amam.collections1.exceptions.EmployeeAlreadyAddedException;
import com.amam.collections1.exceptions.EmployeeNameIsIncorrect;
import com.amam.collections1.exceptions.EmployeeNotFoundException;
import com.amam.collections1.services.for_services.Employee;
import org.apache.commons.lang3.StringUtils;
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

    /**
     * Добавляе сотрудника в коллекцию
     * @param firstName имя
     * @param lastName фамилия
     * @param unit ID департамента
     * @param salary зарплата
     * @return сотрудник
     */
    @Override
    public Employee addEmployee(String firstName, String lastName, int unit, float salary) {

        if (isIncorrectNamesSpelling(firstName) || isIncorrectNamesSpelling(lastName)) {
            throw new EmployeeNameIsIncorrect("Имя или фамилия имеют запрещенные символы");
        }

        Employee employee = new Employee(StringUtils.capitalize(firstName.toLowerCase()),
                StringUtils.capitalize(lastName.toLowerCase()),
                unit,
                salary);

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
     * Возвращает список всех сотрудников
     * @return список сотрудников
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

    /**
     * Проверяет String на наличие запрещенных символов и чисел
     * @param text String
     * @return boolean
     */
    @Override
    public boolean isIncorrectNamesSpelling(String text) {
        return StringUtils.containsAny(text, "!\"#$%&'()*+,\\-./:;<=>?@[]^_`{|} 0123456789");
    }
}
