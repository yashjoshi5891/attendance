package com.management.attendance.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class EmployeeDto {
    private Long id;
    @NotEmpty
    @Size(min=4, message = "Username must be min of 4 chars")
    private String username;
    @Email(message = "Email is not valid")
    private String email;

    @NotEmpty
    @Size(min = 4,max = 8, message = "Password must be min of 4 chars and max of 8 chars")
    private String password;
}
