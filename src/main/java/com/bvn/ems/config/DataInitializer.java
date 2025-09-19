package com.bvn.ems.config;

import com.bvn.ems.entity.Employee;
import com.bvn.ems.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {
        return args -> {
            repository.save(new Employee("John Doe", "IT", 50000, "9876543210", "john@example.com"));
            repository.save(new Employee("Alice Smith", "HR", 45000, "9876501234", "alice@example.com"));
            repository.save(new Employee("Robert Brown", "Finance", 60000, "8765432109", "robert@example.com"));
            repository.save(new Employee("Emily Johnson", "Marketing", 48000, "7654321098", "emily@example.com"));
            repository.save(new Employee("Michael Lee", "Operations", 55000, "6543210987", "michael@example.com"));
        };
    }
}