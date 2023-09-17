package com.heroku.java.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.heroku.java.model.Aluno;
import com.heroku.java.model.Bibliotecario;
import com.heroku.java.model.Conta;
import com.heroku.java.repository.interfaces.IAlunoRepository;
import com.heroku.java.repository.interfaces.IBibliotecarioRepository;
import com.heroku.java.repository.interfaces.IContaRepository;
import com.heroku.java.service.UsuarioService;
import com.heroku.java.service.UsuarioServiceFactory;

@Configuration
public class AppConfig {
    @Bean
    Class<Aluno> alunoClass() {
        return Aluno.class;
    }

    @Bean
    Class<Bibliotecario> bibliotecarioClass() {
        return Bibliotecario.class;
    }

    @Bean
    Class<Conta> contaClass() {
        return Conta.class;
    }

    // @Autowired
    // private UsuarioFactory usuarioFactory;

    @Autowired
    private IAlunoRepository alunoRepository;

    @Autowired
    private IContaRepository contaRepository;

    @Autowired
    private IBibliotecarioRepository bibliotecarioRepository;

  
}