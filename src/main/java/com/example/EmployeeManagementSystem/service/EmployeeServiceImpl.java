package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee registerEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

//    @Override
//    public Employee updateEmployee(Long employeeID, Employee employee) {
////        Optional<Employee> employeeToUpdate = employeeRepository.findById(employeeID);
////        if (employeeToUpdate.isPresent()){
////            employeeToUpdate.setName(employee.getName());
////            employeeToUpdate.setAddress(employee.getAddress());
////            employeeToUpdate.setEmail(employee.getEmail());
////            employeeToUpdate.setPhoneNumber(employee.getPhoneNumber());
////            employeeToUpdate.setSalary(employee.getSalary());
////        }
////
////        return employeeRepository.save(employeeToUpdate);
//        return
//    }

    @Override
    public Employee getEmployee(Long employeeID) {
        Optional<Employee> employeeToFind = employeeRepository.findById(employeeID);
        return employeeToFind.orElse(null);
    }

    @Override
    public void deleteEmployee(Long employeeID) {
        employeeRepository.deleteById(employeeID);
    }
}
