package com.management.attendance.services;

import com.management.attendance.dtos.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto updateEmployee(EmployeeDto employeeDto, long emp_id);
    EmployeeDto getEmployeeById(Long emp_id);
    List<EmployeeDto> getAllEmployee();
    void deleteEmployee(Long empId);


}
