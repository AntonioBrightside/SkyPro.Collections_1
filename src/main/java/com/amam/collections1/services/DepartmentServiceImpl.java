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

    private final EmployeeService es;

    public DepartmentServiceImpl(EmployeeService es) {
        this.es = es;
    }

    /**
     * Возвращает список всех сотруднико в департаменте
     * @param departmentId ID департамента
     * @return список всех сотрудников в департаменте
     */
    @Override
    public List<Employee> getAllEmployeesInDepartment(int departmentId) {
        if (isEmptyList(departmentId)) {
            throw new EmployeeNotFoundException("Нет сотрудников в указанном департаменте");
        }

        return es.getEmployeesBook().values().stream()
                .filter(employee -> employee.getUnit() == departmentId)
                .collect(Collectors.toList());
    }

    /**
     * Возвращает сумму зарплат сотрудников в департаменте
     * @param departmentId ID департамента
     * @return
     */
    @Override
    public Double getSalarySumInDepartment(int departmentId) {
        if (isEmptyList(departmentId)) {
            throw new EmployeeNotFoundException("Нет сотрудников в указанном департаменте");
        }

        return es.getEmployeesBook().values().stream()
                .filter(employee -> employee.getUnit() == departmentId)
                .collect(Collectors.summingDouble(Employee::getSalary));
    }

    /**
     * Возвращает максимальную зарплату в департаменте
     *
     * @param departmentId ID департамента
     * @return
     */
    @Override
    public float getMaxSalaryEmployeeInDepartment(int departmentId) {
        Employee e =  es.getEmployeesBook().values().stream()
                .filter(employee -> employee.getUnit() == departmentId)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Нет сотрудников в отделе"));

        return e.getSalary();
    }

    /**
     * Возвращает минимальную зарплату в департаменте
     *
     * @param departmentId ID департамента
     * @return
     */
    @Override
    public float getMinSalaryEmployeeInDepartment(int departmentId) {
        Employee e = es.getEmployeesBook().values().stream()
                .filter(employee -> employee.getUnit() == departmentId)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Нет сотрудников в отделе"));

        return e.getSalary();
    }

    /**
     * Возвращает словарь всех сотрудников, сгруппированных по департаментам
     * @return
     */
    @Override
    public Map<Integer, List<Employee>> getAllEmployeesDividedToDeparments() {
        return es.getEmployeesBook().values().stream().
                collect(Collectors.groupingBy(Employee::getUnit));
    }

    /**
     * Булево значение на вопрос "пустой ли список?"
     * @param departmentId ID департамента
     * @return true, если в департаменте никого
     */
    private boolean isEmptyList(int departmentId) {
        if (es.getEmployeesBook().values().stream()
                .filter(employee -> employee.getUnit() == departmentId)
                .collect(Collectors.toList()).isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}


