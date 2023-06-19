package com.management.attendance.services.impl;

import com.management.attendance.dtos.LeaveDto;
import com.management.attendance.repositories.EmployeeRepo;
import com.management.attendance.repositories.LeaveRepo;
import com.management.attendance.services.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LeaveServiceImpl implements LeaveService {
    @Autowired
    LeaveRepo leaveRepo;

    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public LeaveDto createLeave(LeaveDto leaveDto, String empId) {

        return null;
    }

    @Override
    public LeaveDto updateLeave(LeaveDto leaveDto, long leaveId) {
        return null;
    }

    @Override
    public LeaveDto getLeaveById(Long leaveId) {
        return null;
    }

    @Override
    public List<LeaveDto> getAllLeaves() {
        return null;
    }

    @Override
    public void deleteLeave() {

    }
}
