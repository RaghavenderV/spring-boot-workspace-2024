package com.vodapally.test;

import com.vodapally.entity.Department;
import com.vodapally.entity.Employee;
import com.vodapally.repositry.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final DepartmentRepository departmentRepository;

    public DataLoader(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Department department1 = new Department();
        department1.setId(555L);
        department1.setName("IT");

        Employee e1 = new Employee();
        e1.setId(101L);
        e1.setName("Haneesh");
        e1.setDepartment(department1);

        Employee e2 = new Employee();
        e2.setId(102L);
        e2.setName("Vihaan");
        e2.setDepartment(department1);


        department1.getEmployees().add(e1);
        department1.getEmployees().add(e2);

        departmentRepository.save(department1);

        Department department2 = new Department();
        department2.setId(666L);
        department2.setName("BPO");

        Employee e3 = new Employee();
        e3.setId(201L);
        e3.setName("Mokshith");
        e3.setDepartment(department2);

        Employee e4 = new Employee();
        e4.setId(202L);
        e4.setName("Sanvika");
        e4.setDepartment(department2);

        department2.getEmployees().add(e3);
        department2.getEmployees().add(e4);

        departmentRepository.save(department2);
    }
}
