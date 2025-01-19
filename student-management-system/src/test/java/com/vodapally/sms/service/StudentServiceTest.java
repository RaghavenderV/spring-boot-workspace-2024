package com.vodapally.sms.service;

import com.vodapally.sms.entity.Student;
import com.vodapally.sms.repository.StudentRepository;
import com.vodapally.sms.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @InjectMocks
    StudentServiceImpl service;
    @Mock
    StudentRepository repository;

    private static Student student = null;

    @BeforeAll
    public static void initSetUp(){
        student = new Student(101L, "Vihaan", "Vodapally", "vihaan.v@gmail.com");
    }

    @Test
    public void  getAllStudentsTest(){

        List<Student> list = new ArrayList<>();
        list.add(student);

        when(repository.findAll()).thenReturn(list);

        List<Student> students = service.getAllStudents();

        assertEquals(list.get(0), students.get(0));
        assertNotNull(students);

    }

    @Test
    public void deleteStudentById(){
        service.deleteStudentById(student.getId());
        verify(repository,times(1)).deleteById(student.getId());
    }

    @Test
    public void saveStudent(){
        when(repository.save(student)).thenReturn(student);

        assertEquals(student, service.saveStudent(student));
    }
}
