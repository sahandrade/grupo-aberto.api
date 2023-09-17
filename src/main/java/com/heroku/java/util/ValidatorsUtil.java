package com.heroku.java.util;


import org.springframework.stereotype.Component;

import com.heroku.java.enuns.TipoPermissao;
import com.heroku.java.enuns.TipoRole;
import com.heroku.java.model.Bibliotecario;
import com.heroku.java.model.Conta;
import com.heroku.java.repository.interfaces.IContaRepository;


@Component
public class ValidatorsUtil {
    private final IContaRepository _contaRepository;
    public ValidatorsUtil(IContaRepository contaRepository){
        _contaRepository = contaRepository;
    }

    public Conta BuscarContaPorId(String contaId){
        var conta = _contaRepository.getById(contaId);
        if (conta == null)
            throw new IllegalArgumentException("Erro. Usuário não encontrado");
        return conta;
    }

    public void AlunoNaoAutorizado(Conta conta){
        if(conta.getRole() == TipoRole.ALUNO)
                    throw new IllegalArgumentException("Erro. Usuário não autorizado");
    }

 

    public void BibliotecarioAutorizado(TipoPermissao permissaoRequest, Conta conta) {
        if (permissaoRequest == null) return;
        var admin = (Bibliotecario) conta.getUsuario();
    
        try {
            // ObjectMapper objectMapper = new ObjectMapper();
            // objectMapper.enable(SerializationFeature.INDENT_OUTPUT); // Formatação bonita do JSON
            // String adminJson = objectMapper.writeValueAsString(admin);
    
            // System.out.println(adminJson);
    
            if (admin.getPermissao() != TipoPermissao.ADMIN && permissaoRequest == TipoPermissao.ADMIN)
                throw new IllegalArgumentException("Erro. Usuário não autorizado a criar Administrador");
        } catch (Exception e) {
            // Lide com exceções de serialização aqui, se necessário
            e.printStackTrace();
        }
    }
}