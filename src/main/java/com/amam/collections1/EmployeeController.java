package com.amam.collections1;

import com.amam.collections1.exceptions.EmployeeAlreadyAddedException;
import com.amam.collections1.exceptions.EmployeeNotFoundException;
import com.amam.collections1.exceptions.EmployeeStorageIsFullException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService ES;

    public EmployeeController(EmployeeService ES) {
        this.ES = ES;
    }

    @GetMapping
    public Collection<Employee> showAllEmployees() {
        return ES.getEmployees();
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("unit") String unit,
                                @RequestParam("salary") String salary) {

        return ES.addEmployee(firstName, lastName, unit, salary);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("key") Integer key) {
        return ES.removeEmployee(key);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("key") Integer key) {
        return ES.findEmployee(key);
    }
}
