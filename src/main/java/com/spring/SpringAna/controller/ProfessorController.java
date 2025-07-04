package com.spring.springana.controller;



import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.springana.springanaApplication;
import com.spring.springana.dto.ProfessorDto;
import com.spring.springana.modelo.Professor;
import com.spring.springana.repository.ProfessorRepository;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping( value = "/professor")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;
    
    @GetMapping( value = "/imprimir")
        public void imprimir() {
            System.out.println("chamou o método imprimir");
        }

    @GetMapping( value = "/ola")
        public String ola(){
            return "<h1>Ana</h1>";
        }

        @PostMapping(value = "/insert")
        public String postMethodName(@RequestBody String entity) {
            //TODO: process POST request
            
            return entity;
        }
        
        public ResponseEntity<?> insert(@RequestBody ProfessorDto professorDto ) {
        
            Professor professor = professorDto.novoProfessor();
              
            professorRepository.save(professor);
              
              
            System.out.println(professor.toString());

            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                                                 .path("id")
                                                 .buildAndExpand(professor.getId())
                                                 .toUri();
           

            return ResponseEntity.created(uri).body(professor);
        
    }

}