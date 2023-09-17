package com.heroku.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Component;

import com.heroku.java.enuns.TipoRole;
import com.heroku.java.repository.interfaces.IAlunoRepository;
import com.heroku.java.repository.interfaces.IBibliotecarioRepository;
import com.heroku.java.repository.interfaces.IContaRepository;
import com.heroku.java.service.intefaces.IUsuarioService;

@Component
public class UsuarioServiceFactory{
    private final IContaRepository _contaRepository;
    private final IAlunoRepository alunoRepository;
    private final IBibliotecarioRepository bibliotecarioRepository;

    public UsuarioServiceFactory(IAlunoRepository alunoRepository, IBibliotecarioRepository bibliotecarioRepository, IContaRepository contaRepository) {
        this.alunoRepository = alunoRepository;
        this.bibliotecarioRepository = bibliotecarioRepository;
        _contaRepository = contaRepository;

    }

    public IUsuarioService criarUsuarioService(TipoRole role) {
        if (role == TipoRole.ALUNO) {
            return new AlunoService(alunoRepository, _contaRepository);
        } else if (role == TipoRole.BIBLIOTECARIO) {
            return new BibliotecarioService(bibliotecarioRepository, _contaRepository);
        }
        throw new IllegalArgumentException("Papel inválido: " + role);
    }
}