package com.example.EmployeeManagementSystem.controller;

import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public String getHome(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "index";
    }

    @GetMapping("/addEmp")
    public String addEmployee() {
        return "add_emp";
    }

    @PostMapping("/register")
    public String registerEmployee(@ModelAttribute Employee employee, HttpSession httpSession) {
        employeeService.registerEmployee(employee);
        String msg = (String) httpSession.getAttribute("msg");
        if (msg != null) {
            // Set the attribute value in the model for rendering in Thymeleaf
            httpSession.setAttribute("msg", msg);
            // Remove the session attribute
            httpSession.removeAttribute("msg");
        }
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String getEmployee(@PathVariable("id") Long employeeId, Model model) {
        Employee employeeToGet = employeeService.getEmployee(employeeId);
        model.addAttribute("employee", employeeToGet);
        return "edit_emp";
    }

    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute Employee employee) {
        employeeService.registerEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return "redirect:/";
    }
}
