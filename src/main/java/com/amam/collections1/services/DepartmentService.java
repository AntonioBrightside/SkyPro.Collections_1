package com.amam.collections1.services;

import com.amam.collections1.services.for_services.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Double getSalarySumInDepartment(int departmentId);

    float getMaxSalaryEmployeeInDepartment(int departmentId);

    float getMinSalaryEmployeeInDepartment(int departmentId);

    List<Employee> getAllEmployeesInDepartment(int departmentId);

    Map<Integer, List<Employee>> getAllEmployeesDividedToDeparments();
}
