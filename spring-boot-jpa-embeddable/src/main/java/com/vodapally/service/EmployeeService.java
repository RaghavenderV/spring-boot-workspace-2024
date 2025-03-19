package com.vodapally.service;

import com.vodapally.entity.Address;
import com.vodapally.entity.Employee;
import com.vodapally.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(String name, Address address){
        Employee employee = new Employee(name, address);
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
}
