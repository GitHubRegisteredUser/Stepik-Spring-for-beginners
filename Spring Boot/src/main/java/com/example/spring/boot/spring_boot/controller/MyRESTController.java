package com.example.spring.boot.spring_boot.controller;

import com.example.spring.boot.spring_boot.entity.Employee;
import com.example.spring.boot.spring_boot.service.EmployeeService;
//import com.example.spring.rest.exception_handling.NoSuchEmployeeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllemployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
//        if (employee == null) {
//            throw new NoSuchEmployeeException("There is no employee with ID = " + id);
//        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
//        if (employee == null) {
//            throw new NoSuchEmployeeException("There is no employee with ID = " + id);
//        }
        employeeService.deleteEmployee(id);
        return "Employee with ID = " + id + " was deleted";
    }

}
