package com.microservices.employee.service;

import com.microservices.employee.entity.Department;

import java.util.List;

public interface DepartmentService {

    Department createDepartment(Department department);

    List<Department> getAllDepartments();

    Department getDepartmentById(int id);
}
