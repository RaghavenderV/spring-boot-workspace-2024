package com.vodapally.controller;

import com.vodapally.entity.Department;
import com.vodapally.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/create")
    public Department createDepartment(@RequestBody Department department){
        return departmentService.createDepartment(department);
    }

    @GetMapping("/id/{deptId}")
    public Department getDepartmentById(@PathVariable(name = "deptId") Long id){
        return departmentService.getDepartmentById(id);
    }

}
