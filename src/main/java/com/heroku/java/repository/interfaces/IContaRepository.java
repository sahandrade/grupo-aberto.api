package com.heroku.java.repository.interfaces;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.heroku.java.model.Conta;
import com.heroku.java.model.GroceryItem;

public interface IContaRepository extends MongoRepository<Conta, String>{
    
    @Query("{name:'?0'}")
    Conta findItemByName(String name);

    @Query("{id:'?0'}")
    Conta getById(String id);

    @Query("{key:'?0'}")
    Conta getBykey(String id);
    
    
    @Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
    List<Conta> findAll(String category);
    

    public long count();
}
