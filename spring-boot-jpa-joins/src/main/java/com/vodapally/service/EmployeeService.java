package com.vodapally.service;

import com.vodapally.dto.EmployeeDepartmentDTO;
import com.vodapally.entity.Employee;
import com.vodapally.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // fetch all employees by department name
    public List<Employee> getEmployeesByDepartmentName(String departmentName){
        return employeeRepository.getEmployeesByDepartmentName(departmentName);
    }

    public List<EmployeeDepartmentDTO> getEmployeesByDepartmentNameCustomized(String departmentName){
        return employeeRepository.getEmployeesByDepartmentNameCustomized(departmentName);
    }

}
