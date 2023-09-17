package com.heroku.java.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import com.heroku.java.model.Conta;
import com.heroku.java.model.LoginRequest;
import com.heroku.java.model.ResponseBase;
import com.heroku.java.model.Usuario;
import com.heroku.java.model.UsuarioRequest;
import com.heroku.java.repository.interfaces.IContaRepository;

@Service
public class UsuarioService {
    // private final IContaRepository _contaRepository;

    // public UsuarioService(IContaRepository contaRepository) {
    //     _contaRepository = contaRepository;
    // }

    // public void VerificarContaExiste(UsuarioRequest request) {
    //     if (buscarPorEmail(request.getEmail()) != null)
    //         throw new IllegalArgumentException("O email fornecido já em está em uso. Por favor, escolha outro email.");
    //     if (buscarPorTia(request.getTia()) != null)
    //         throw new IllegalArgumentException("O tia fornecido já está em uso. Por favor, escolha outro tia.");
    //     if (buscarPorcelular(request.getCelular()) != null)
    //         throw new IllegalArgumentException(
    //                 "O número de celular fornecido já está em uso. Por favor, informe outro número.");
    // }

    
    // public void VerificarContaExiste(UsuarioRequest request, String id) {
    //     var conta = buscarPorEmail(request.getEmail());
    //     if (conta != null && !conta.getId().equals(id) )
    //         throw new IllegalArgumentException("O email fornecido já em está em uso. Por favor, escolha outro email.");
    //     if (buscarPorTia(request.getTia()) != null)
    //         throw new IllegalArgumentException("O tia fornecido já está em uso. Por favor, escolha outro tia.");
    //     if (buscarPorcelular(request.getCelular()) != null)
    //         throw new IllegalArgumentException(
    //                 "O número de celular fornecido já está em uso. Por favor, informe outro número.");
    // }

    // public ResponseBase Login(LoginRequest request, Conta conta) {
    //     if (!verificarSenha(request, conta)) {
    //         throw new IllegalArgumentException("Senha inválida");
    //     }
    //     Map<String, Object> response = new HashMap<>();
    //     response.put("contaId", conta.getId());
    //     response.put("role", conta.getRole().getNome());
    //     return new ResponseBase(true, "Ok", response);
    // }

    // private Conta buscarPorEmail(String email) {
    //     return _contaRepository.getByKey("Email", email);
    // }

    // private Conta buscarPorTia(String tia) {
    //     if (tia == null)
    //         return null;
    //     return _contaRepository.getByKey("Tia", tia);
    // }

    // private Conta buscarPorcelular(String celular) {
    //     return _contaRepository.getByKey("Celular", celular);
    // }

    // public Conta createConta(UsuarioRequest request, Usuario usuario) {
    //     var conta = new Conta(request.getRole(), request.getCelular(), request.getEmail(), request.getSenha(), usuario);
    //     conta.generateSenha();
    //     return conta;
    // }

    // private boolean verificarSenha(LoginRequest request, Conta conta) {
    //     return conta.validarSenha(request.Senha, request.Email);
    // }

    // // cria um novo bibliotecario
    // // public ResponseBase CriarUsuario(UsuarioRequest request) {
    // // try {
    // // //buscar por email
    // // validarEntradas(request);
    // // var aluno = createAluno(request);
    // // aluno.setSenha(getSenha(aluno));
    // // _usuarioRepository.addNew(aluno);
    // // return new ResponseBase().Sucesso();
    // // } catch (Exception ex) {
    // // // Em caso de erro, criar uma resposta de falha
    // // return new ResponseBase(false, "Erro ao criar o usuário: " +
    // // ex.getMessage());
    // // }
    // // }

    // private Usuario createAluno(UsuarioRequest request){
    // return null;
    // }

    // private void validarEntradas(UsuarioRequest request){
    // if(buscarPorEmail(request.getEmail()) != null)
    // throw new IllegalArgumentException("O email fornecido já em está em uso. Por
    // favor, escolha outro email.");
    // if(buscarPorTia(request.getTia()) != null)
    // throw new IllegalArgumentException("O tia fornecido já está em uso. Por
    // favor, escolha outro tia.");
    // if(buscarPorcelular(request.getCelular()) != null)
    // throw new IllegalArgumentException("O número de celular fornecido já está em
    // uso. Por favor, informe outro número.");

    // }

    // public ResponseBase EditarUsuario(UsuarioRequest request, Usuario aluno){
    // try {
    // //buscar por email
    // validarEntradas(request);
    // _usuarioRepository.update(aluno.getId(), aluno);
    // return new ResponseBase().Sucesso();
    // } catch (Exception ex) {
    // // Em caso de erro, criar uma resposta de falha
    // return new ResponseBase(false, "Erro ao criar o usuário: " +
    // ex.getMessage());
    // }
    // }

    // private Usuario buscarPorEmail(String email){
    // return _usuarioRepository.getByKey("Email", email);
    // }

    // private Usuario buscarPorTia(String tia){
    // return _usuarioRepository.getByKey("Tia", tia);
    // }

    // private Usuario buscarPorcelular(String celular){
    // return _usuarioRepository.getByKey("Celular", celular);
    // }

    // public ResponseBase Login(LoginRequest request) {
    // return null;
    // }

}