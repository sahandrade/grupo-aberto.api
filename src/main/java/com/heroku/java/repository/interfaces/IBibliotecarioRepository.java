package com.heroku.java.repository.interfaces;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.heroku.java.model.Bibliotecario;

public interface IBibliotecarioRepository extends MongoRepository<Bibliotecario, String>{
    
    @Query("{name:'?0'}")
    Bibliotecario findItemByName(String name);

    @Query("{id:'?0'}")
    Bibliotecario getById(String id);

    
    @Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
    List<Bibliotecario> findAll(String category);
    

    public long count();
}
