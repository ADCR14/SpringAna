package com.spring.springana.controller;



import java.net.URI;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.springana.springanaApplication;
import com.spring.springana.dto.ProfessorDto;
import com.spring.springana.modelo.Professor;
import com.spring.springana.repository.ProfessorRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



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



    @GetMapping( value = "/listaprofessor")
    public List<Professor> findAll(){
        return professorRepository.findAll();

    }



    @DeleteMapping (value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        professorRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }



    @GetMapping( value = "/{id}")
    public ResponseEntity<Professor> buscarProfessorPor(@PathVariable Long id) {
        Optional<Professor> professorBanco = professorRepository.findById(id);

        Professor professor = professorBanco.get();

        return ResponseEntity.ok(professorBanco.get());

        
    }




    @PostMapping(value = "/insert")        
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