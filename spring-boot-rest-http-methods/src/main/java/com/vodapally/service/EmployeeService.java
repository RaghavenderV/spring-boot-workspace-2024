package com.vodapally.service;

import com.vodapally.entity.Employee;
import com.vodapally.exceptions.ResourceNotFoundException;
import com.vodapally.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;


    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }


    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }


    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with the id: " + id));
    }


    public Employee updateEmployee(Long id, Employee employeeDetails) {

        /* As we handled validations in Employee entity, below code not required, else you can use
        if (employeeDetails.getName() == null || employeeDetails.getSalary() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name and salary are required for a full update");
        }
         */


        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee Not Found with id: " + id));

        // Replace all fields
        employee.setName(employeeDetails.getName());
        employee.setSalary(employeeDetails.getSalary());

        return employeeRepository.save(employee);
    }

    public Employee partialUpdateEmployee(Long id, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee Not Found with id: " + id));

        if (employeeDetails.getName() != null) {
            if (employeeDetails.getName().length() < 2 || employeeDetails.getName().length() > 50) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name must be between 2 and 50 characters");
            }
            employee.setName(employeeDetails.getName());
        }
        if (employeeDetails.getSalary() != null) {
            if (employeeDetails.getSalary() <= 0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Salary must be positive");
            }
            employee.setSalary(employeeDetails.getSalary());
        }

        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee Not Found with id: " + id));

        employeeRepository.deleteById(id);
    }

}
