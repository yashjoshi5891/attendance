package com.management.attendance.services;

import com.management.attendance.dtos.AttendanceDto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public interface AttendanceService {
    AttendanceDto createAttendance(AttendanceDto attendanceDto,Long empId);
    AttendanceDto updateAttendanceByEmployeeAndDate(long empId,LocalDate date);

    AttendanceDto getAttendance(Long id);

    List<AttendanceDto> getAllAttendance();

    void deleteAttendance(Long id);

    List<AttendanceDto> getAttendanceByEmployee(Long empId);

    List<AttendanceDto> getAttendanceByDate(LocalDate date);


}
