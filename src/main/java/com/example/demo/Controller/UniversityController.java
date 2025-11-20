package com.example.demo.controller;

import com.example.demo.model.University;
import com.example.demo.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/university")
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    @PostMapping("/add")
    public University addUniversity(@RequestBody University university) {
        return universityService.addUniversity(university);
    }

    @GetMapping("/all")
    public List<University> getAllUniversities() {
        return universityService.getAllUniversities();
    }
}
