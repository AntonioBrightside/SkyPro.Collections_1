package com.amam.collections1.services;

import com.amam.collections1.exceptions.EmployeeAlreadyAddedException;
import com.amam.collections1.exceptions.EmployeeNameIsIncorrect;
import com.amam.collections1.exceptions.EmployeeNotFoundException;
import com.amam.collections1.services.for_services.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {

    private EmployeeService out;

    @BeforeEach
    public void setUp() {
        out = new EmployeeServiceImpl();
    }

    @Test
    public void whenAddEmployeeWithIncorrectNameShouldThrowException() {
        assertThrows(EmployeeNameIsIncorrect.class,
                () -> out.addEmployee("Фёд0р", "Степанов", 1, 50_000f));
    }

    @Test
    public void WhenAddEmployeeWithIncorrectSecondNameShouldThrowException() {
        assertThrows(EmployeeNameIsIncorrect.class,
                () -> out.addEmployee("Фёдор", "Степанов ", 1, 55_000f));
    }

    @Test
    public void whenAddCorrectEmployeeShouldGetBackEmployee() {
        Employee expected = new Employee("Фёдор", "Степанов", 1, 55_000f);
        out.addEmployee("Фёдор", "Степанов", 1, 55_000f);
        Employee result = out.getEmployeesBook().get(0);

        assertEquals(expected, result);
    }

    @Test
    public void whenPlaceIncorrectNameAndSecondNameShouldCorrectsCaseInNameAndSecondName() {
        Employee expected = new Employee("Степан", "Фёдоров", 1, 55_000f);
        out.addEmployee("стЕпаН", "фёдоРОВ", 1, 55_000f);
        Employee result = out.getEmployeesBook().get(0);

        assertEquals(expected, result);
    }

    @Test
    public void whenEmployeeAlreadyInShouldThrowException() {
        assertThrows(EmployeeAlreadyAddedException.class,
                () -> {out.addEmployee("Фёдор", "Степанов", 1, 55_000f);
                        out.addEmployee("Фёдор", "Степанов", 1, 55_000f);
        });
    }

    @Test
    public void whenFindCorrectEmployee() {
        Employee expected = new Employee("Фёдор", "Степанов", 1, 55_000f);
        out.addEmployee("Антон", "Иванов", 1, 65_000f);
        out.addEmployee("Сергей", "Михайлов", 2, 75_000f);
        out.addEmployee("Фёдор", "Степанов", 1, 55_00f);

        Employee result = out.findEmployee(2);

        assertEquals(expected, result);
    }

    @Test
    public void whenFindIncorrectEmployeeByIdShouldThrowException() {
        out.addEmployee("Антон", "Иванов", 1, 65_000f);
        out.addEmployee("Сергей", "Михайлов", 2, 75_000f);
        assertThrows(EmployeeNotFoundException.class, ()->out.findEmployee(2));
    }

    @Test
    public void whenRemoveIncorrectEmployeeByIdShouldThrowException() {
        assertThrows(EmployeeNotFoundException.class, () -> out.removeEmployee(0));
    }

    @Test
    public void whenRemoveCorrectEmployee() {
        Employee expected = new Employee("Антон", "Иванов", 1, 65_000f);
        out.addEmployee("Антон", "Иванов", 1, 65_000f);
        assertEquals(expected, out.removeEmployee(0));
    }

}
