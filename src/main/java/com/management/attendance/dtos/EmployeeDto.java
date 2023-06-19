package com.management.attendance.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {
    private Long id;
    private String username;
    private String email;
    private String password;
}
