package com.example.demo.service;

import com.example.demo.domain.Book;
import com.example.demo.domain.Grop;
import com.example.demo.domain.Student;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.GroupRepository;
import com.example.demo.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @MockBean
    StudentRepository studentRepository;

    private final Grop group = new Grop(1L, 228);

    private final Student student1 = new Student(1L, "name1", "email1", group,
            List.of(new Book(2L, "book2")));

    private final Student student2 = new Student(2L, "name2", "email2", group,
            List.of(new Book(1L, "book1"), new Book(3L, "book3")));

    @Test
    void getAllStudents() {

        when(studentRepository.findAll()).thenReturn(
                List.of(student1, student2));

        assertEquals(studentService.getAllStudents().toString(), "[" +
                "StudentOutPayload(id=1, name=name1, email=email1, group=GroupDTO(number=228), books=[BookDTO(name=book2)]), " +
                "StudentOutPayload(id=2, name=name2, email=email2, group=GroupDTO(number=228), books=[BookDTO(name=book1), BookDTO(name=book3)])]");
    }
}
