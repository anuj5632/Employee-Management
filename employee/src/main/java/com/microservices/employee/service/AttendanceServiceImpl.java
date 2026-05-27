package com.microservices.employee.service;

import com.microservices.employee.entity.Attendance;
import com.microservices.employee.entity.Employee;
import com.microservices.employee.repository.AttendanceRepo;
import com.microservices.employee.repository.EmployeeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepo attendanceRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Attendance markAttendance(Attendance attendance) {

        Integer employeeId =
                attendance.getEmployee().getId();

        Employee employee =
                employeeRepo.findById(employeeId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Employee not found"));

        attendance.setEmployee(employee);

        return attendanceRepo.save(attendance);
    }

    @Override
    public List<Attendance> getEmployeeAttendance(int employeeId) {

        return attendanceRepo
                .findByEmployeeId(employeeId);
    }
}