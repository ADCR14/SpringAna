package com.spring.springana.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.springana.modelo.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    
}
