package com.heroku.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heroku.java.model.Aluno;
import com.heroku.java.model.Conta;
import com.heroku.java.model.ResponseBase;
import com.heroku.java.model.UsuarioRequest;
import com.heroku.java.repository.interfaces.IAlunoRepository;
import com.heroku.java.repository.interfaces.IContaRepository;
import com.heroku.java.service.intefaces.IUsuarioService;

@Service
public class AlunoService extends UsuarioService implements IUsuarioService{

    private final  IAlunoRepository _alunoRepository;
     private final IContaRepository _contaRepository;

    public AlunoService(IAlunoRepository alunoRepository,IContaRepository contaRepository){
        super(contaRepository);
        _alunoRepository = alunoRepository;
        _contaRepository = contaRepository;

    }
     public ResponseBase CriarUsuario(UsuarioRequest request, String email) {
         try {
             var aluno = createAluno(request, email);
             var conta = createConta(request, aluno);
             VerificarContaExiste(request);
             _alunoRepository.save(aluno);
             _contaRepository.save(conta);
             return new ResponseBase().Sucesso();
         } catch (Exception ex) {
         //     Em caso de erro, criar uma resposta de falha
             return new ResponseBase(false, "Erro ao criar o usuário: " + ex.getMessage());
         }
     }

    private Aluno createAluno(UsuarioRequest request, String email) {
        var aluno = new Aluno();
        aluno.setCampos(request, email);
        return aluno;
    }

    // public ResponseBase EditarUsuario(UsuarioRequest request,Conta conta, String email){
    //     try {
    //         var aluno = createAluno(request, email);
    //         aluno.setRole(conta.getRole());
    //         conta = createConta(request, aluno);
    //         VerificarContaExiste(request);
    //         this.alunoRepository.update(aluno.getId(), aluno);
    //         this.contaRepository.update(conta.getId(), conta);
    //         return new ResponseBase().Sucesso();
    //     } catch (Exception ex) {
    //         // Em caso de erro, criar uma resposta de falha
    //         return new ResponseBase(false, "Erro ao editar o usuário: " + ex.getMessage());
    //     }
    // }

    // public ResponseBase BuscarUsuarioPorId(String id) {
    // var usuario = _usuarioRepository.buscarPorId(id);
    // if (usuario == null)
    // return new ResponseBase(false, "não encontrado");
    // return new ResponseBase(true, usuario, "Ok");
    // }  

}
