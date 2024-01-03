package com.amam.collections1.controllers;

import com.amam.collections1.services.for_services.Employee;
import com.amam.collections1.services.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl es;

    public EmployeeController(EmployeeServiceImpl es) {
        this.es = es;
    }

    @GetMapping("/all")
    public String showAllEmployees() {
        return es.getEmployees();
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("unit") int unit,
                                @RequestParam("salary") float salary) {

        return es.addEmployee(firstName, lastName, unit, salary);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("key") int key) {
        return es.removeEmployee(key);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("key") int key) {
        return es.findEmployee(key);
    }
}
