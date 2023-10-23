package com.heroku.java.repository.interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.heroku.java.model.Conta;
import com.heroku.java.model.Livro;

public interface ILivroRepository extends MongoRepository<Livro, String>{
    @Query(value="{id:'?0'}")
    Livro getById(String id);
}
