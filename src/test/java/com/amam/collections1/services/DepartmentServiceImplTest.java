package com.amam.collections1.services;

import com.amam.collections1.exceptions.EmployeeNotFoundException;
import com.amam.collections1.services.for_services.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    @Mock
    private EmployeeServiceImpl employeeServiceMock;

    private DepartmentService out;

    @BeforeEach
    public void setUp() {
        out = new DepartmentServiceImpl(employeeServiceMock);
        when(employeeServiceMock.getEmployeesBook()).
                thenReturn(Map.of(1, new Employee("Фёдор", "Степанов", 1, 50_000f),
                        2, new Employee("Светослав", "Листов", 1, 125_000f),
                        3, new Employee("Игорь", "Астафьев", 2, 75_00f)));
    }

    @Test
    public void whenGetAllEmployeesInDepartment() {
        List<Employee> expected = List.of(new Employee("Светослав", "Листов", 1, 125_000f),
                new Employee("Фёдор", "Степанов", 1, 50_000f));

        assertEquals(expected, out.getAllEmployeesInDepartment(1));
    }

    @Test
    public void whenGetAllEmployeesInNonExistDepartment() {
        assertThrows(EmployeeNotFoundException.class,() -> out.getAllEmployeesInDepartment(0));
    }

    @Test
    public void whenGetSalarySumInDepartment() {
        Double expected = 50_000.0 + 125_000.0;
        assertEquals(expected, out.getSalarySumInDepartment(1));
    }

    @Test
    public void whenGetSalarySumInNonExistDepartment() {
        assertThrows(EmployeeNotFoundException.class,() -> out.getSalarySumInDepartment(0));
    }

    @Test
    public void whenGetMinSalaryEmployeeInDepartment() {
        float expected = 50_000f;
        assertEquals(expected, out.getMinSalaryEmployeeInDepartment(1));
    }

    @Test
    public void whenGetMinSalaryEmployeeInNonExistDepartment() {
        assertThrows(EmployeeNotFoundException.class, () -> out.getMinSalaryEmployeeInDepartment(5));
    }

    @Test
    public void whenGetMaxSalaryEmployeeInDepartment() {
        float expected = 125_000f;
        assertEquals(expected, out.getMaxSalaryEmployeeInDepartment(1));
    }

    @Test
    public void whenGetMaxSalaryEmployeeInNonExistDepartment() {
        assertThrows(EmployeeNotFoundException.class, () -> out.getMaxSalaryEmployeeInDepartment(5));
    }

}