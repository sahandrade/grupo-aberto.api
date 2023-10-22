package com.heroku.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.heroku.java.model.Livro;
import com.heroku.java.repository.interfaces.ILivroRepository;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value="/livros")
public class LivroController {

    @Autowired
    ILivroRepository livroRepository;
    
    @GetMapping(value="")
    public List<Livro> BuscarTodosLivros() {
        return livroRepository.findAll();
    }


    
}
