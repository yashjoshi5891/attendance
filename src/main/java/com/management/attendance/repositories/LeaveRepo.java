package com.management.attendance.repositories;

import com.management.attendance.entities.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepo extends JpaRepository<Leave, Long> {
}
