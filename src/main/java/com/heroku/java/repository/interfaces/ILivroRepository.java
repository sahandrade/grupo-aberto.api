package com.heroku.java.repository.interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.heroku.java.model.Livro;

public interface ILivroRepository extends MongoRepository<Livro, String>{
    
}
