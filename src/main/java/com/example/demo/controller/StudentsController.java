package com.example.demo.controller;

import com.example.demo.domain.dto.StudentInPayload;
import com.example.demo.domain.dto.StudentOutPayload;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
@CrossOrigin
public class StudentsController {

    private final StudentService studentService;

    @GetMapping
    public List<StudentOutPayload> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping("/book/{book}/student/{id}")
    public String addBookToStudent(@PathVariable("book") String bookName,
                                   @PathVariable("id") Long studentId){
        return studentService.addBook(bookName, studentId);
    }

    @PostMapping("/student")
    public String addStudent(@RequestBody @NotNull @Validated StudentInPayload studentInPayload){
        return studentService.addStudent(studentInPayload);
    }
}
