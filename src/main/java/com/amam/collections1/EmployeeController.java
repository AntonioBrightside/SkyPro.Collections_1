package com.amam.collections1;

import com.amam.collections1.exceptions.EmployeeAlreadyAddedException;
import com.amam.collections1.exceptions.EmployeeNotFoundException;
import com.amam.collections1.exceptions.EmployeeStorageIsFullException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService ES;

    public EmployeeController(EmployeeService ES) {
        this.ES = ES;
    }

    @GetMapping
    public Set<Employee> showAllEmployees() {
        return ES.getEmployees();
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName) {
        return ES.addEmployee(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName) {
        return ES.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName) {
        return ES.findEmployee(firstName, lastName);
    }
}
