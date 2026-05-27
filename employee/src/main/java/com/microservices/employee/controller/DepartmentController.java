package com.microservices.employee.controller;

import com.microservices.employee.entity.Department;
import com.microservices.employee.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public Department createDepartment(@RequestBody Department department){

        return departmentService.createDepartment(department);
    }

    @GetMapping
    public List<Department> getAllDepartments(){

        return departmentService
                .getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(
            @PathVariable int id){

        return departmentService
                .getDepartmentById(id);
    }
}
