package com.vodapally.service;

import com.vodapally.entity.Course;
import com.vodapally.entity.Student;
import com.vodapally.repository.CourseRepository;
import com.vodapally.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCourseService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Student saveStudentWithCourse(Student student){
        return studentRepository.save(student);
    }

    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    public Student findStudent(int studentId){
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student Id does not exist."));
    }

    public List<Student> findStudentsContainingByName(String name){
        return studentRepository.findByNameContaining(name);
    }

    public List<Course> findCourseLessThanPrice(double price){
        return courseRepository.findByFeeLessThan(price);
    }

}
