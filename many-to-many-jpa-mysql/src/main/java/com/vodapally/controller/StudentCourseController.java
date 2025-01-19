package com.vodapally.controller;

import com.vodapally.entity.Course;
import com.vodapally.entity.Student;
import com.vodapally.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/course")
public class StudentCourseController {

    @Autowired
    private StudentCourseService service;

    @PostMapping
    public Student saveStudentWithCourse(@RequestBody Student student){
        return service.saveStudentWithCourse(student);
    }

    @GetMapping
    public List<Student> findAllStudents(){
        return service.findAllStudents();
    }

    @GetMapping("/{studentId}")
    public Student findStudent(@PathVariable int studentId){

        return service.findStudent(studentId);
    }

    @GetMapping("/{name}")
    public List<Student> findStudentsContainingByName(@PathVariable String name){
        return service.findStudentsContainingByName(name);
    }

    @GetMapping("/{price}")
    public List<Course> findCourseLessThanPrice(@PathVariable double price){
        return service.findCourseLessThanPrice(price);
    }
}
