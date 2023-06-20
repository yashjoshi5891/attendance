package com.management.attendance.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Employees")
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy ="employee",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Attendance> attendanceList;

    @OneToMany(mappedBy = "employee",cascade =CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Leave>leaves;

}
