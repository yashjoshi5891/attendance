package com.management.attendance.repositories;

import com.management.attendance.dtos.AttendanceDto;
import com.management.attendance.entities.Attendance;
import com.management.attendance.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceRepo extends JpaRepository<Attendance, Long> {

    List<Attendance> findByDate(LocalDate date);
    List<Attendance> findByEmployee(Employee employee);

    @Query(value = "select * from attendance a WHERE a.emp_id= :emp_id and a.date= :date",nativeQuery = true)
    Attendance findByEmployeeAndDate(@Param("emp_id") Long emp_id,@Param("date") LocalDate date);


}
