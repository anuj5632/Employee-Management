package com.microservices.employee.repository;

import com.microservices.employee.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceRepo
        extends JpaRepository<Attendance,Integer> {

    List<Attendance> findByEmployeeId(int employeeId);
}
