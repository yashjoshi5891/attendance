package com.management.attendance.services.impl;

import com.management.attendance.dtos.AttendanceDto;
import com.management.attendance.entities.Attendance;
import com.management.attendance.entities.Employee;
import com.management.attendance.exceptions.ResourceNotFoundException;
import com.management.attendance.repositories.AttendanceRepo;
import com.management.attendance.repositories.EmployeeRepo;
import com.management.attendance.services.AttendanceService;
import lombok.Setter;
import net.bytebuddy.asm.Advice;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    AttendanceRepo attendanceRepo;
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    ModelMapper modelMapper;



    @Override
    public AttendanceDto createAttendance(AttendanceDto attendanceDto, Long empId) {
        long millis=System.currentTimeMillis();

        // creating a new object of the class Date
        java.sql.Date date = new java.sql.Date(millis);

        java.sql.Time time=new java.sql.Time(millis);



        Employee employee=employeeRepo.findById(empId).orElseThrow(()->new ResourceNotFoundException("Employee","empId",empId));

        Attendance attendance=modelMapper.map(attendanceDto,Attendance.class);
        attendance.setCheck_in(time);
        attendance.setCheck_in(null);
        attendance.setDate(date);
        attendance.setEmployee(employee);

        Attendance savedAttendance=attendanceRepo.save(attendance);

        return modelMapper.map(savedAttendance,AttendanceDto.class);

    }

    @Override
    public AttendanceDto updateAttendance(AttendanceDto attendanceDto, long id) {
        return null;
    }

    @Override
    public AttendanceDto getAttendance(int id) {
        return null;
    }

    @Override
    public List<AttendanceDto> getAllAttendance() {
        return null;
    }

    @Override
    public void deleteAttendance() {

    }
}
