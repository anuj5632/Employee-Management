package com.microservices.employee.controller;

import com.microservices.employee.entity.Attendance;
import com.microservices.employee.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping
    public Attendance markAttendance(
            @RequestBody Attendance attendance){

        return attendanceService
                .markAttendance(attendance);
    }

    @GetMapping("/{employeeId}")
    public List<Attendance> getAttendance(
            @PathVariable int employeeId){

        return attendanceService
                .getEmployeeAttendance(employeeId);
    }
}
