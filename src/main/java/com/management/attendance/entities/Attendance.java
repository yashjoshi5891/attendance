package com.management.attendance.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="Attendance")
@Getter
@Setter
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;


    private LocalTime check_in;
    private LocalTime check_out;

    private String type;
    @ManyToOne
    @JoinColumn(name="emp_id")
    private Employee employee;
}
