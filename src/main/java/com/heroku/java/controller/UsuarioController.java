package com.heroku.java.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.heroku.java.enuns.TipoRole;
import com.heroku.java.model.Conta;
import com.heroku.java.model.GroceryItem;
import com.heroku.java.model.LoginRequest;
import com.heroku.java.model.UsuarioRequest;
import com.heroku.java.repository.interfaces.IContaRepository;
import com.heroku.java.service.UsuarioServiceFactory;
import com.heroku.java.util.ValidatorsUtil;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/usuario")
public class UsuarioController {

    @Autowired
    IContaRepository _contaRepository;

    @Autowired
    ValidatorsUtil validators;

    @Autowired
    UsuarioServiceFactory _usuarioServiceFactory;

    @GetMapping(value="/hello")
    public String hello(){
        return "hello";
    }
    @GetMapping(value="")
public List<Conta> getAllUsers() {
	return _contaRepository.findAll();
}
  @PostMapping(value = "/login") // Defina o caminho correto aqui
    public ResponseEntity<?> Login(@RequestBody LoginRequest request) {
        try {
            // Primeiro, verifique se a conta existe com base no email
            System.out.println("kkkk"+ request.getEmail());
            var conta = _contaRepository.findByEmail(request.getEmail());

            if (conta == null) {
                
                return ResponseEntity.badRequest().body("Usuário não encontrado");
            }


            // Agora que temos a conta, crie o serviço de usuário com base na função/role da conta
            var _service = _usuarioServiceFactory.criarUsuarioService(conta.getRole());

            // Chame o método de login do serviço de usuário
            var response = _service.Login(request, conta);

            // Retorne uma resposta bem-sucedida com os dados de resposta
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body("Erro: " + e.getMessage());
        }
    }

@PostMapping(value = "/criar")
    public ResponseEntity<?> CadastrarUsuario(@RequestHeader("ContaId") String ContaId,
            @RequestBody UsuarioRequest request) {

        try {
            var conta = validators.BuscarContaPorId(ContaId);

            validators.AlunoNaoAutorizado(conta);

            validators.BibliotecarioAutorizado(request.getPermissao(), conta);

            var _service = _usuarioServiceFactory.criarUsuarioService(request.getRole());
            var response = _service.CriarUsuario(request, conta.getEmail());
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body("Erro: " + e.getMessage());
        }
    }
    @GetMapping(value = "/criar")
public Conta addNewUsers() {
    System.out.println("Saving user.");
	return _contaRepository.save(new Conta(TipoRole.ALUNO, "Whole Wheat Biscuit", "Whole Wheat Biscuit", null, null));

}
    
}
