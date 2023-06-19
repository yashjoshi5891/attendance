package com.management.attendance.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="Attendance")
@Getter
@Setter
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private java.sql.Date date;
    private java.sql.Time check_in;
    private java.sql.Time check_out;
    private String type;
    @OneToOne
    @JoinColumn(name="emp_id")
    private Employee employee;
}
