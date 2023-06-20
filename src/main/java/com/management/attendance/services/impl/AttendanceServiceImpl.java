package com.management.attendance.services.impl;

import com.management.attendance.dtos.AttendanceDto;
import com.management.attendance.entities.Attendance;
import com.management.attendance.entities.Employee;
import com.management.attendance.exceptions.ResourceNotFoundException;
import com.management.attendance.repositories.AttendanceRepo;
import com.management.attendance.repositories.EmployeeRepo;
import com.management.attendance.services.AttendanceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.LocalDate.*;

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
        Date date=new Date();
        Calendar c=Calendar.getInstance();
        c.setTime(date);
        String day=new SimpleDateFormat("EEEE").format(date);



        Employee employee=employeeRepo.findById(empId).orElseThrow(()->new ResourceNotFoundException("Employee","empId",empId));
        Attendance attendance=modelMapper.map(attendanceDto,Attendance.class);

        if(day.equals("Sunday")){
            attendance.setDate(now());
            attendance.setCheck_in(null);
            attendance.setCheck_out(null);
            attendance.setType("Holiday");

            Attendance savedAttendance=attendanceRepo.save(attendance);
            return modelMapper.map(savedAttendance,AttendanceDto.class);
        }
        else{

            if(attendanceRepo.findByEmployeeAndDate(empId,LocalDate.now())==null){
                attendance.setDate(now());
                attendance.setCheck_in(LocalTime.now());
                attendance.setCheck_out(null);
                attendance.setEmployee(employee);
                attendance.setType(attendanceDto.getType());
                Attendance savedAttendance=attendanceRepo.save(attendance);

                return modelMapper.map(savedAttendance,AttendanceDto.class);
            }

            else{

                return modelMapper.map(attendanceRepo.findByEmployeeAndDate(empId,LocalDate.now()),AttendanceDto.class);
            }

        }
    }

    @Override
    public AttendanceDto updateAttendanceByEmployeeAndDate(long empId, LocalDate date) {
        Attendance attendance=attendanceRepo.findByEmployeeAndDate(empId,date);
        attendance.setCheck_out(LocalTime.now());
        Attendance updatedAttendance=attendanceRepo.save(attendance);
        return modelMapper.map(updatedAttendance,AttendanceDto.class);
    }


    @Override
    public AttendanceDto getAttendance(Long id) {
        return modelMapper.map(attendanceRepo.
                findById(id).
                orElseThrow(()->new ResourceNotFoundException("Attendance Record","id",id)),AttendanceDto.class);
    }

    @Override
    public List<AttendanceDto> getAllAttendance() {
        List<Attendance> attendances=attendanceRepo.findAll();
        List<AttendanceDto> attendanceDtos=attendances
                .stream()
                .map(attendance -> modelMapper.map(attendance,AttendanceDto.class))
                .collect(Collectors.toList());
        return attendanceDtos;
    }

    @Override
    public void deleteAttendance(Long id) {
        Attendance attendance=attendanceRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Attendance Record","id :",id));
        attendanceRepo.deleteById(id);
    }

    @Override
    public List<AttendanceDto> getAttendanceByEmployee(Long empId) {
        Employee employee=employeeRepo.findById(empId).orElseThrow(()->new ResourceNotFoundException("Employee","empId :",empId));
        List<Attendance> attendances=attendanceRepo.findByEmployee(employee);

        return attendances.stream().map(attendance -> modelMapper.map(attendance,AttendanceDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<AttendanceDto> getAttendanceByDate(LocalDate date) {
        List<Attendance> attendances=attendanceRepo.findByDate(date);

        return attendances.stream().map(attendance -> modelMapper.map(attendance,AttendanceDto.class)).collect(Collectors.toList());
    }




}
