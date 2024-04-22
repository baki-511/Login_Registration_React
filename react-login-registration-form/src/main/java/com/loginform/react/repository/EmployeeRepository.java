package com.loginform.react.repository;

import com.loginform.react.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    
    Optional<Employee> findOneByEmailAndPassword(String email, String password);
    
    Employee findByEmail(String email);
}
