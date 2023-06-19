package com.management.attendance.services;

import com.management.attendance.dtos.AttendanceDto;

import java.util.List;


public interface AttendanceService {
    AttendanceDto createAttendance(AttendanceDto attendanceDto,Long empId);
    AttendanceDto updateAttendance(AttendanceDto attendanceDto,long id);

    AttendanceDto getAttendance(int id);

    List<AttendanceDto> getAllAttendance();

    void deleteAttendance();

}
