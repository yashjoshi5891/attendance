package com.management.attendance.controllers;

import com.management.attendance.dtos.AttendanceDto;
import com.management.attendance.services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {
    @Autowired
    AttendanceService attendanceService;

    @PostMapping("/mark/{empId}")
    public ResponseEntity<AttendanceDto> markAttendance(@Valid @RequestBody AttendanceDto attendanceDto, @PathVariable Long empId){
        return new ResponseEntity<>(attendanceService.createAttendance(attendanceDto,empId), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<AttendanceDto>> getAll(){
        return new ResponseEntity<>(attendanceService.getAllAttendance(),HttpStatus.OK);
    }

    @GetMapping("/employees/{empId}")
    public ResponseEntity<List<AttendanceDto>> getAttendanceByEmployee(@PathVariable Long empId){
        return new ResponseEntity<>(attendanceService.getAttendanceByEmployee(empId),HttpStatus.OK);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<AttendanceDto>> getAttendanceByDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return new ResponseEntity<>(attendanceService.getAttendanceByDate(date),HttpStatus.OK);
    }
    @PutMapping("/employee/{empId}/date/{date}")
    public ResponseEntity<AttendanceDto> updateCheckout(@PathVariable Long empId,@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return new ResponseEntity<>(attendanceService.updateAttendanceByEmployeeAndDate(empId,date),HttpStatus.OK);
    }
}


