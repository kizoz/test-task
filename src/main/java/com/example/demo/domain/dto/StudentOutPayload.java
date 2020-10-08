package com.example.demo.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentOutPayload {

    private Long id;

    private String name;

    private String email;

    private GroupDTO group;

    private List<BookDTO> books;
}
