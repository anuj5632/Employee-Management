package com.microservices.employee.service;

import com.microservices.employee.entity.Department;
import com.microservices.employee.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public Department createDepartment(Department department) {

        return departmentRepo.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }

    @Override
    public Department getDepartmentById(int id) {
        return departmentRepo.findById(id).orElse(null);
    }
}
