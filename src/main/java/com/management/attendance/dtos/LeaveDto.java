package com.management.attendance.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class LeaveDto {
    private long id;
    private Date fromDate;
    private Date toDate;
    private String leaveType;
    private String reason;
    private String status;
    private EmployeeDto employee;
}
