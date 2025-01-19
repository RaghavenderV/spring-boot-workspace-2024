package com.vodapally.sms.repository;

import com.vodapally.sms.entity.Student;
import com.vodapally.sms.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase
public class StudentRepositoryTest {
//    @Autowired
//    private StudentRepository repository;
//
//    @Test
//    public void save(){
//        //Arrange
//        Student student = new Student();
//        student.setFirstName("Narendra");
//        student.setLastName("Modi");
//        student.setEmail("modi@gmail.com");
//
//        //Act
//        Student newStudent = repository.save(student);
//
//        //Assert
//        assertNotNull(newStudent);
//        assertNotNull(newStudent.getId());
//    }
}
