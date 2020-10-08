package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Grop grop;

    @ManyToMany
    @JoinTable(name = "students_books",
            joinColumns = @JoinColumn (name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Book> books;

}
