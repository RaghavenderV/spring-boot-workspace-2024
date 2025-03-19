package com.vodapally.service;

import com.vodapally.entity.Department;
import com.vodapally.repositry.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    public Department createDepartment(Department department){
        return repository.save(department);
    }

    public Department getDepartmentById(Long id){
        return repository.findById(id).orElse(null);
    }

}
