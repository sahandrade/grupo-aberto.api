package com.heroku.java.service.intefaces;

import com.heroku.java.model.Conta;
import com.heroku.java.model.LoginRequest;
import com.heroku.java.model.ResponseBase;
import com.heroku.java.model.UsuarioRequest;

public interface IUsuarioService {
    public ResponseBase CriarUsuario(UsuarioRequest request, String email);
    public ResponseBase Login(LoginRequest request, Conta conta);
    //public ResponseBase EditarUsuario(UsuarioRequest request, Conta conta, String email);
    //ResponseBase BuscarUsuarioPorId(String id);
}
