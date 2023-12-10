package com.amam.collections1.services;

import com.amam.collections1.exceptions.EmployeeNotFoundException;
import com.amam.collections1.services.for_services.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService ES;

    public DepartmentServiceImpl(EmployeeService es) {
        ES = es;
    }

    @Override
    public Employee getMaxSalaryEmployeeInDepartment(int departmentId) {
        return ES.getEmployeesBook().values().stream()
                .filter(employee -> employee.getUnit() == departmentId)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Нет сотрудников в отделе"));
    }

    @Override
    public Employee getMinSalaryEmployeeInDepartment(int departmentId) {
        return ES.getEmployeesBook().values().stream()
                .filter(employee -> employee.getUnit() == departmentId)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Нет сотрудников в отделе"));
    }

    @Override
    public List<Employee> getAllEmployeesInDepartment(int departmentId) {
        return ES.getEmployeesBook().values().stream()
                .filter(employee -> employee.getUnit() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployeesDividedToDeparments() {
        return ES.getEmployeesBook().values().stream().
                collect(Collectors.groupingBy(Employee::getUnit));

    }


}


