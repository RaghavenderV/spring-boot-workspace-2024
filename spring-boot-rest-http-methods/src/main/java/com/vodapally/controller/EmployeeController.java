package com.vodapally.controller;

import com.vodapally.entity.Employee;
import com.vodapally.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
        Employee employeeData = employeeService.createEmployee(employee);
        //return ResponseEntity.ok(employeeData);
        return new ResponseEntity<>(employeeData, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }


    //PUT: Uses @Valid to enforce all constraints since it’s a full update.
    @PutMapping("/update/{id}") // PUT: replace entire resource
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee(id, employee);

        return ResponseEntity.ok(updatedEmployee);
    }



    //PATCH: Manually checks constraints only for provided fields, as partial updates don’t require all fields to be present. We can’t use @Valid directly here because it would reject the request if required fields are missing.
    @PatchMapping("/update/patch/{id}") // PATCH: partial update
    public ResponseEntity<Employee> partialUpdatePEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.partialUpdateEmployee(id, employee);

        return ResponseEntity.ok(updatedEmployee);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee successfully deleted with id: " + id);
    }
}

