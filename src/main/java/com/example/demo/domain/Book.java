package com.example.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "books", cascade = CascadeType.ALL)
    private List<Student> users;

    public Book(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
