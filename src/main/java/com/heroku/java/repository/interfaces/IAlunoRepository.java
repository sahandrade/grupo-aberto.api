package com.heroku.java.repository.interfaces;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.heroku.java.model.Aluno;

public interface IAlunoRepository extends MongoRepository<Aluno, String>{
    
    @Query("{name:'?0'}")
    Aluno findItemByName(String name);

    @Query("{id:'?0'}")
    Aluno getById(String id);

    
    @Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
    List<Aluno> findAll(String category);
    

    public long count();
}
