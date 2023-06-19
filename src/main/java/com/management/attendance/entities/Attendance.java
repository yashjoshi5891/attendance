package com.management.attendance.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Attendance")
@Getter
@Setter
public class Attendance {
    @Id
    private Long id;
    private Date date;
    private Date check_in;
    private Date check_out;
    private String type;
    @OneToOne
    @JoinColumn(name="emp_id")
    private Employee employee;
}
