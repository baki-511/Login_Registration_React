package com.loginform.react.service;

import com.loginform.react.dto.EmployeeDto;
import com.loginform.react.dto.LoginDto;
import com.loginform.react.payload.response.LoginMessage;

public interface EmployeeService {
    String addEmployee(EmployeeDto employeeDTO);
    
    LoginMessage loginEmployee(LoginDto loginDTO);
}
