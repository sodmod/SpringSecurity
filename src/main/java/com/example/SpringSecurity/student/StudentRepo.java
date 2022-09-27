package com.example.SpringSecurity.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Students, Long> {

    Optional<Students> findByUsername(String username);
}
