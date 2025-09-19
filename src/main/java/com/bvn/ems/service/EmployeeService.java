package com.bvn.ems.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.bvn.ems.entity.Employee;
import com.bvn.ems.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAllEmployees() { return repository.findAll(); }
    public Employee getEmployeeById(Long id) { return repository.findById(id).orElse(null); }
    public Employee saveEmployee(Employee employee) { return repository.save(employee); }
    public void deleteEmployee(Long id) { repository.deleteById(id); }
}
