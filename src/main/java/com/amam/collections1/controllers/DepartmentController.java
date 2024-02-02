package com.amam.collections1.controllers;

import com.amam.collections1.services.DepartmentService;
import com.amam.collections1.services.for_services.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService ds;

    public DepartmentController(DepartmentService departmentService) {
        ds = departmentService;
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getAllEmployeesInDepartment(@PathVariable("id") int departmentId) {
        return ds.getAllEmployeesInDepartment(departmentId);
    }

    @GetMapping("/{id}/salary/sum")
    public Double getSalarySumInDepartment(@PathVariable("id") int departmentId) {
        return ds.getSalarySumInDepartment(departmentId);
    }

    @GetMapping("{id}/salary/max")
    public float getMaxSalaryEmployeeInDepartment(@PathVariable("id") int departmentId) {
        return ds.getMaxSalaryEmployeeInDepartment(departmentId);
    }

    @GetMapping("{id}/salary/min")
    public float getMinSalaryEmployeeInDepartment(@PathVariable("id") int departmentId) {
        return ds.getMinSalaryEmployeeInDepartment(departmentId);
    }

    @GetMapping("employees")
    public Map<Integer, List<Employee>> getAllEmployeesDividedToDeparments() {
        return ds.getAllEmployeesDividedToDeparments();
    }
}
