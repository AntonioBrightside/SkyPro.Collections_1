package com.amam.collections1.controllers;

import com.amam.collections1.services.for_services.Employee;
import com.amam.collections1.services.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl ES;

    public EmployeeController(EmployeeServiceImpl ES) {
        this.ES = ES;
    }

    @GetMapping("/all")
    public String showAllEmployees() {
        return ES.getEmployees();
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("unit") int unit,
                                @RequestParam("salary") float salary) {

        return ES.addEmployee(firstName, lastName, unit, salary);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("key") int key) {
        return ES.removeEmployee(key);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("key") int key) {
        return ES.findEmployee(key);
    }
}
