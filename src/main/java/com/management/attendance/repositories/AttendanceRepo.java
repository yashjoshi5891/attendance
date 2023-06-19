package com.management.attendance.repositories;

import com.management.attendance.entities.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepo extends JpaRepository<Attendance, Long> {
}
