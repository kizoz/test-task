package com.example.demo.service;

import com.example.demo.domain.Student;
import com.example.demo.domain.dto.BookDTO;
import com.example.demo.domain.dto.GroupDTO;
import com.example.demo.domain.dto.StudentInPayload;
import com.example.demo.domain.dto.StudentOutPayload;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.GroupRepository;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    private final GroupRepository groupRepository;

    private final BookRepository bookRepository;

    private final ModelMapper modelMapper;

    public List<StudentOutPayload> getAllStudents(){
        List<Student> students = studentRepository.findAll();

        return students.stream()
                .map(student -> {
                    StudentOutPayload outPayload = modelMapper.map(student, StudentOutPayload.class);
                    outPayload.setGroup(modelMapper.map(student.getGrop(), GroupDTO.class));
                    outPayload.setBooks(student.getBooks().stream()
                            .map(book -> modelMapper.map(book, BookDTO.class))
                            .collect(Collectors.toList()));
                    return outPayload;
                })
                .collect(Collectors.toList());
    }

    public String addBook(String bookName, Long studentId){
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student does not exist!"));

        if(bookRepository.existsByName(bookName))
            student.getBooks().add(bookRepository.findByName(bookName));
        else
            throw new IllegalArgumentException("Book does not exist!");

        return String.format("Book was added to %s", student.getName());
    }

    public String addStudent(StudentInPayload studentInPayload){
        Student student = modelMapper.map(studentInPayload, Student.class);
        student.setGrop(groupRepository.findByNumber(studentInPayload.getGroupNumber()));
        studentRepository.save(student);
        return "Student was created";
    }

}
