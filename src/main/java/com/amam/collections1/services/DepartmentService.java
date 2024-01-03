package com.amam.collections1.services;

import com.amam.collections1.services.for_services.Employee;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface DepartmentService {
    Employee getMaxSalaryEmployeeInDepartment(int departmentId);

    Employee getMinSalaryEmployeeInDepartment(int departmentId);

    List<Employee> getAllEmployeesInDepartment(int departmentId);

    Map<Integer, List<Employee>> getAllEmployeesDividedToDeparments();
}
