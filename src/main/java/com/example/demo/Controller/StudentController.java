package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // 🔹 Ajouter un nouvel étudiant
    @PostMapping("/add")
    public String add(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "New student is added";
    }

    // 🔹 Récupérer tous les étudiants
    @GetMapping("/getAll")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // 🔹 Récupérer tous les étudiants avec leur université
    @GetMapping("/getAllUniv")
    public List<Object> getAllStudentsUniversity() {
        return studentService.getAllStudentsUniversity();
    }    

    // 🔹 Trouver les étudiants par nom d’université
    @GetMapping("/findStudUniv")
    public List<Object> findStudentsByUniversity(@RequestParam String univName) {
        return studentService.findStudentsByUniversity(univName);
    }
}
