package com.management.attendance.services;

import com.management.attendance.dtos.LeaveDto;

import java.util.List;

public interface LeaveService {
    LeaveDto createLeave(LeaveDto leaveDto,String empId);
    LeaveDto updateLeave(LeaveDto leaveDto,long leaveId);
    LeaveDto getLeaveById(Long leaveId);
    List<LeaveDto> getAllLeaves();
    void deleteLeave();
}
