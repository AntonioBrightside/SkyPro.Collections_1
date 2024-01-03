package com.amam.collections1.controllers;

import com.amam.collections1.services.DepartmentService;
import com.amam.collections1.services.for_services.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService ds;

    public DepartmentController(DepartmentService departmentService) {
        ds = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee getMaxSalaryEmployeeInDepartment(@RequestParam("departmentId") int departmentId) {
        return ds.getMaxSalaryEmployeeInDepartment(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee getMinSalaryEmployeeInDepartment(@RequestParam("departmentId") int departmentId) {
        return ds.getMinSalaryEmployeeInDepartment(departmentId);
    }

    @GetMapping(value = "/all", params = "departmentId")
    public List<Employee> getAllEmployeesInDepartment(@RequestParam("departmentId") int departmentId) {
        return ds.getAllEmployeesInDepartment(departmentId);
    }

    @GetMapping(value = "/all")
    public Map<Integer, List<Employee>> getAllEmployeesDividedToDeparments() {
        return ds.getAllEmployeesDividedToDeparments();
    }
}
