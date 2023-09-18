package com.heroku.java.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.data.domain.Sort.Order;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import com.heroku.java.enuns.TipoRole;
import com.heroku.java.model.Conta;
import com.heroku.java.model.GroceryItem;
import com.heroku.java.model.LoginRequest;
import com.heroku.java.model.UsuarioRequest;
import com.heroku.java.repository.interfaces.IContaRepository;
import com.heroku.java.service.UsuarioServiceFactory;
import com.heroku.java.util.ValidatorsUtil;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    IContaRepository _contaRepository;

    @Autowired
    ValidatorsUtil validators;

    @Autowired
    UsuarioServiceFactory _usuarioServiceFactory;

    @GetMapping(value = "/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping(value = "")
    public List<Conta> getAllUsers() {
        return _contaRepository.findAll();
    }

    @PostMapping(value = "/login") // Defina o caminho correto aqui
    public ResponseEntity<?> Login(@RequestBody LoginRequest request) {
        try {
            // Primeiro, verifique se a conta existe com base no email
            System.out.println("kkkk" + request.getEmail());
            var conta = _contaRepository.findByEmail(request.getEmail());

            if (conta == null) {

                return ResponseEntity.badRequest().body("Usuário não encontrado");
            }

            // Agora que temos a conta, crie o serviço de usuário com base na função/role da
            // conta
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

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getAllTutorialsPage(
            @RequestParam(required = false) String nome,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "id,desc") String[] sort) {

        try {
            List<Sort.Order> orders = new ArrayList<>();

            for (String sortOrder : sort) {
                String[] _sort = sortOrder.split(",");
                if (_sort.length == 2) {
                    orders.add(new Sort.Order(getSortDirection(_sort[1]), _sort[0]));
                }
            }

            Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));

            Page<Conta> pageTuts;

            if (nome == null || nome.isEmpty()) {
                pageTuts = _contaRepository.findAll(pagingSort);
            } else {
                pageTuts = _contaRepository.findByNomeContaining(nome, pagingSort);
            }

            List<Conta> tutorials = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("tutorials", tutorials);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else {
            return Sort.Direction.DESC;
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> getContaById(@PathVariable("id") String id) {
        Optional<Conta> conta = _contaRepository.findById(id);

        if (conta.isPresent()) {
            return new ResponseEntity<>(conta.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
