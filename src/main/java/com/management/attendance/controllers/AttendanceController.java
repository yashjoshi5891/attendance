package com.management.attendance.controllers;

import com.management.attendance.dtos.AttendanceDto;
import com.management.attendance.services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {
    @Autowired
    AttendanceService attendanceService;

    @PostMapping("/mark/{empId}")
    public ResponseEntity<AttendanceDto> markAttendance(@RequestBody AttendanceDto attendanceDto,@PathVariable Long empId){
        return new ResponseEntity<>(attendanceService.createAttendance(attendanceDto,empId), HttpStatus.CREATED);
    }
}


