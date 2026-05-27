package com.microservices.employee.service;

import com.microservices.employee.entity.Employee;
import com.microservices.employee.repository.EmployeeRepo;
import com.microservices.employee.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Integer id);
}
