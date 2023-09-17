package com.heroku.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heroku.java.model.Bibliotecario;
import com.heroku.java.model.Conta;
import com.heroku.java.model.ResponseBase;
import com.heroku.java.model.UsuarioRequest;
import com.heroku.java.repository.interfaces.IBibliotecarioRepository;
import com.heroku.java.repository.interfaces.IContaRepository;
import com.heroku.java.service.intefaces.IUsuarioService;

@Service
public class BibliotecarioService extends UsuarioService implements IUsuarioService{

    private final IBibliotecarioRepository _bibliotecarioRepository;
    @Autowired
    private final IContaRepository _contaRepository;

    public BibliotecarioService(IBibliotecarioRepository bibliotecarioRepository, IContaRepository contaRepository){
        super(contaRepository);
_bibliotecarioRepository = bibliotecarioRepository;
_contaRepository = contaRepository;
    }
 
      public ResponseBase CriarUsuario(UsuarioRequest request, String email) {
        try {
            var bibliotecario = create(request, email);
            var conta = createConta(request, bibliotecario);
            VerificarContaExiste(request);
            _bibliotecarioRepository.save(bibliotecario);
            _contaRepository.save(conta);
            return new ResponseBase().Sucesso();
        } catch (Exception ex) {
            // Em caso de erro, criar uma resposta de falha
            return new ResponseBase(false, "Erro ao criar o usuário: " + ex.getMessage());
        }
    }

    // public ResponseBase EditarUsuario(UsuarioRequest request,Conta conta, String email){
    //     try {
    //         var bibliotecario = create(request, email);
    //         bibliotecario.setRole(conta.getRole());
    //         conta = createConta(request, bibliotecario);
    //         VerificarContaExiste(request);
    //         _bibliotecarioRepository.update(bibliotecario.getId(), bibliotecario);
    //         _contaRepository.update(conta.getId(), conta);
    //         return new ResponseBase().Sucesso();
    //     } catch (Exception ex) {
    //         // Em caso de erro, criar uma resposta de falha
    //         return new ResponseBase(false, "Erro ao criar o usuário: " + ex.getMessage());
    //     }
    // }

    private Bibliotecario create(UsuarioRequest request, String email) {
        var bibliotecario = new Bibliotecario();
        bibliotecario.setCampos(request, email);
        return bibliotecario;
    }



}