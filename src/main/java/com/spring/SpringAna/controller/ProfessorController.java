package com.spring.springana.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "/professor")
public class ProfessorController {
    
    @GetMapping( value = "/imprimir")
    public void imprimir() {
        System.out.println("chamou o método imprimir");
    }

    @GetMapping( value = "/ola")
    public String ola(){
        return "<h1>Ana</h1>";
    }

@GetMapping( value = "/insert")    
public static String insert() {
    return "<h1>Tentando salvar o professor dos alunos</h1>";
}


}
