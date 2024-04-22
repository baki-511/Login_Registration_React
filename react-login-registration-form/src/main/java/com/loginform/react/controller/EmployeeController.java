package com.loginform.react.controller;

import com.loginform.react.dto.EmployeeDto;
import com.loginform.react.dto.LoginDto;
import com.loginform.react.payload.response.LoginMessage;
import com.loginform.react.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    
    @PostMapping(path = "/save")
    public String saveEmployee(@RequestBody EmployeeDto employeeDTO) {
        return employeeService.addEmployee(employeeDTO);
    }
    
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDto loginDTO) {
        LoginMessage loginMessage = employeeService.loginEmployee(loginDTO);
        return ResponseEntity.ok(loginMessage);
    }
    
    
}
