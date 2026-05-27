package com.microservices.employee.entity;

import com.microservices.employee.entity.Employee;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate date;

    private String status;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Attendance() {
    }

//    public Attendance(int id,
//                      LocalDate date,
//                      String status,
//                      Employee employee) {
//
//        this.id = id;
//        this.date = date;
//        this.status = status;
//        this.employee = employee;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
