package com.management.attendance.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceDto {
    private long id;
    private Date date;
    private LocalDateTime check_in;
    private LocalDateTime check_out;
    private String type;
    private EmployeeDto employee;

}
