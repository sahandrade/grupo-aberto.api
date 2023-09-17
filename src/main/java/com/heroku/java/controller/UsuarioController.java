package com.heroku.java.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.heroku.java.enuns.TipoRole;
import com.heroku.java.model.Conta;
import com.heroku.java.model.GroceryItem;
import com.heroku.java.repository.interfaces.IContaRepository;

@RestController
@RequestMapping(value="/usuario")
public class UsuarioController {
    private final IContaRepository _contaRepository;

	public UsuarioController(IContaRepository contaRepository) {
		_contaRepository = contaRepository;
	}

    @GetMapping(value="/hello")
    public String hello(){
        return "hello";
    }
    @GetMapping(value="")
public List<Conta> getAllUsers() {
	return _contaRepository.findAll();
}

    @GetMapping(value = "/criar")
public Conta addNewUsers() {
    System.out.println("Saving user.");
	return _contaRepository.save(new Conta(TipoRole.ALUNO, "Whole Wheat Biscuit", "Whole Wheat Biscuit", null, null));

}
    
}
