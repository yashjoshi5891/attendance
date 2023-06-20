package com.management.attendance.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Leaves")
public class Leave {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Date fromDate;
    private Date toDate;
    private String leaveType;
    private String reason;
    private String status;

    @ManyToOne 
    @JoinColumn(name = "emp_id")
    private Employee employee;
}
