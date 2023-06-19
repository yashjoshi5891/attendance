package com.management.attendance.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Employees")
public class Employee {
    private Long id;
    private String username;
    private String email;
    private String password;
}
