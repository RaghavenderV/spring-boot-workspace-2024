package com.vodapally.controller;

import com.vodapally.dto.EmployeeDepartmentDTO;
import com.vodapally.entity.Employee;
import com.vodapally.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    List<Employee> getEmployeesByDepartmentName(@RequestParam("departmentName") String departmentName){
        return employeeService.getEmployeesByDepartmentName(departmentName);
    }

    @GetMapping("/custom")
    List<EmployeeDepartmentDTO> getEmployeesByDepartmentNameCustomized(@RequestParam("departmentName") String departmentName){
        return employeeService.getEmployeesByDepartmentNameCustomized(departmentName);
    }
}
