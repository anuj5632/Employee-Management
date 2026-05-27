package com.microservices.employee.service;

import com.microservices.employee.entity.Employee;
import com.microservices.employee.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Employee createEmployee(Employee employee) {

        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {

        return employeeRepo.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer id) {

        return employeeRepo.findById(id).orElse(null);
    }
}
