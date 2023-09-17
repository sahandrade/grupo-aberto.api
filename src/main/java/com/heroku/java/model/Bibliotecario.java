package com.heroku.java.model;

import org.bson.Document;

import com.heroku.java.enuns.TipoPermissao;

public class Bibliotecario extends Usuario {
    private TipoPermissao permissao;

    public Bibliotecario() {
    }

    public TipoPermissao getPermissao() {
        return permissao;
    }

    public void setPermissao(TipoPermissao Permissao) {
        // Verifica se Permissao é nula ou em branco antes de atribuir
        if (Permissao == null)
        this.permissao = TipoPermissao.COMUM;
    }


    @Override
    public void setPorTipoUsuario(UsuarioRequest request){
        System.out.println("aqui"+ request.getPermissao());
        setPermissao(request.getPermissao());
    }
}