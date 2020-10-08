package com.example.demo.repository;

import com.example.demo.domain.Grop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Grop, Long> {

    Grop findByNumber(Integer number);
}
