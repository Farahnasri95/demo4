package com.example.demo;
// JUnit 5 annotations and Spring Boot testing utilities
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
// AssertJ for fluent assertions
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
// Indicates this is a Spring Boot test that loads the full application context
@SpringBootTest
// Specifies the order in which test methods will be executed
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ControllerTest {
    // Injects the StudentRepository bean from the Spring context
    @Autowired
    private StudentRepository studentRepository;
    // First test: verifies that a student can be saved to the repository
    @Test
    @Order(1) // Ensures this test runs first
    void shouldSaveStudent(){
        // Create a new student object
        Student student =new Student();
        student.setName("ali");
        student.setAddress("algeria");
        studentRepository.save(student);
        assertThat(studentRepository.count()).isEqualTo(1);
    
    }
    @Test 
    @Order(2) // Ensures this test runs after shouldSaveStudent() 
    void shouldFindAllStudents() { 
        // Fetch all students from the repository 
        List<Student> students = studentRepository.findAll(); 
 
        // Assert that there is exactly one student in the list 
        assertThat(students).hasSize(1);
        // Assert that the student's name is "Charlie" 
        assertThat(students.get(0).getName()).isEqualTo("Charlie"); 
    }
}