package com.management.attendance.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceDto {
    private Long id;
    private LocalDate date;
    private LocalTime check_in;
    private LocalTime check_out;
    @NotEmpty
    private String type;
    private EmployeeDto employee;

}
