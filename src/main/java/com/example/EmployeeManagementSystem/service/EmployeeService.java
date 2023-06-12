package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee registerEmployee(Employee employee);

    List<Employee> getAllEmployees();

//    Employee updateEmployee(Long employeeID, Employee employee);
    Employee getEmployee(Long employeeID);

    void deleteEmployee(Long employeeID);
}
