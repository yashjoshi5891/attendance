package com.management.attendance.services.impl;

import com.management.attendance.dtos.EmployeeDto;
import com.management.attendance.entities.Employee;
import com.management.attendance.exceptions.ResourceNotFoundException;
import com.management.attendance.repositories.EmployeeRepo;
import com.management.attendance.services.EmployeeService;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee=modelMapper.map(employeeDto,Employee.class);
        Employee savedEmployee=employeeRepo.save(employee);
        return modelMapper.map(savedEmployee,EmployeeDto.class);
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto, long emp_id) {
        Employee employee= employeeRepo.findById(emp_id).orElseThrow(() -> new ResourceNotFoundException("Employee", "empID", emp_id));
        employee.setUsername(employeeDto.getUsername());
        employee.setEmail(employeeDto.getEmail());
        employee.setPassword(employeeDto.getPassword());
        Employee updatedEmployee=employeeRepo.save(employee);
        return modelMapper.map(updatedEmployee,EmployeeDto.class);
    }


    @Override
    public EmployeeDto getEmployeeById(Long emp_id) {
        Employee employee= employeeRepo.findById(emp_id).orElseThrow(() -> new ResourceNotFoundException("Employee", "empID", emp_id));

        return modelMapper.map(employee,EmployeeDto.class);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees=employeeRepo.findAll();
        List<EmployeeDto> employeeDto=employees.stream().map(employee -> modelMapper.map(employee,EmployeeDto.class)).collect(Collectors.toList());
        return employeeDto;
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee=employeeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","empID",id));
        employeeRepo.deleteById(id);
    }
}
