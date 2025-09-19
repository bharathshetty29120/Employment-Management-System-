package com.bvn.ems.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bvn.ems.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> { }
