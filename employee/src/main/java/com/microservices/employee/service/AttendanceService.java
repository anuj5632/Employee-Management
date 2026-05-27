package com.microservices.employee.service;

import com.microservices.employee.entity.Attendance;

import java.util.List;

public interface AttendanceService {

    Attendance markAttendance(
            Attendance attendance);

    List<Attendance> getEmployeeAttendance(
            int employeeId);
}
