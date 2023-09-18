package com.heroku.java.repository.interfaces;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.heroku.java.model.Conta;
import com.heroku.java.model.GroceryItem;

public interface IContaRepository extends MongoRepository<Conta, String>{
    
    @Query("{email:'?0'}")
    Conta findByEmail(String email);

    @Query("{id:'?0'}")
    Conta getById(String id);

    @Query("{tia:'?0'}")
    Conta findByTia(String tia);

    @Query("{celular:'?0'}")
    Conta findByCel(String celular);
    
    @Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
    List<Conta> findAll(String category);

    public long count();


    Page<Conta> findAllPage(Pageable pageable);

     @Query(value="{nome:'?0'}")
    Page<Conta> findByNomeContaining(String nome, Pageable pageable);
  
         @Query(value="{nome:'?0'}")

    List<Conta> findByNomeContaining(String nome, Sort sort);
}
