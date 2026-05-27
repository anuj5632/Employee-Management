package com.microservices.employee.repository;

import com.microservices.employee.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo
        extends JpaRepository<Department,Integer> {
}
