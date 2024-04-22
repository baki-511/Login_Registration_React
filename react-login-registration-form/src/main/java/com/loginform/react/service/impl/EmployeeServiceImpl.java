package com.loginform.react.service.impl;

import com.loginform.react.dto.EmployeeDto;
import com.loginform.react.dto.LoginDto;
import com.loginform.react.entity.Employee;
import com.loginform.react.payload.response.LoginMessage;
import com.loginform.react.repository.EmployeeRepository;
import com.loginform.react.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public String addEmployee(EmployeeDto employeeDTO) {
        Employee employee = new Employee();
        employee.setEmployeeid(employeeDTO.getEmployeeid());
        employee.setEmail(employeeDTO.getEmail());
        employee.setEmployeename(employeeDTO.getEmployeename());
        employee.setPassword(passwordEncoder.encode(employeeDTO.getPassword()));
        employeeRepository.save(employee);
        return employee.getEmployeename();
    }
    
    @Override
    public LoginMessage loginEmployee(LoginDto loginDTO) {
        String msg = "";
        Employee employee = employeeRepository.findByEmail(loginDTO.getEmail());
        if (employee != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = employee.getPassword();
            boolean isPasswordRight = passwordEncoder.matches(password, encodedPassword);
            if (isPasswordRight) {
                Optional<Employee> emp =
                        employeeRepository.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (emp.isPresent()) {
                    return new LoginMessage("Login Success", true);
                } else {
                    return new LoginMessage("Login Failed", false);
                }
            } else {
                return new LoginMessage("password Not Match", false);
            }
        } else {
            return new LoginMessage("Email not exits", false);
        }
    }
}
