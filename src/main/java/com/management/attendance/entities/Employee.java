package com.management.attendance.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="Employees")
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String email;
    private String password;

    @OneToOne(mappedBy ="employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Attendance attendance;

    @OneToOne(mappedBy = "employee",cascade =CascadeType.ALL,fetch = FetchType.EAGER)
    private Leave leave;

}
