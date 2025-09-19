package com.bvn.ems.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.bvn.ems.entity.Employee;
import com.bvn.ems.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }
    

    @GetMapping
    public List<Employee> getAllEmployees() { return service.getAllEmployees(); }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) { return service.getEmployeeById(id); }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) { return service.saveEmployee(employee); }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updated) {
        Employee emp = service.getEmployeeById(id);
        if (emp != null) {
            emp.setName(updated.getName());
            emp.setDepartment(updated.getDepartment());
            emp.setSalary(updated.getSalary());
            emp.setPhone(updated.getPhone());   
            emp.setEmail(updated.getEmail());
            return service.saveEmployee(emp);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return "Employee deleted successfully!";
    }
}
