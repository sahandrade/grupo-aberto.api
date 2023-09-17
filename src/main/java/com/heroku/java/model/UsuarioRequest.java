package com.heroku.java.model;

import com.heroku.java.enuns.TipoPermissao;
import com.heroku.java.enuns.TipoRole;

public class UsuarioRequest {
    public String Nome;

    public String Sobrenome;
    public String Celular;

    public String Email;

    public TipoRole Role;
    public String Senha;
    public String Tia;
    public TipoPermissao Permissao;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getSobrenome() {
        return Sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        Sobrenome = sobrenome;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public TipoRole getRole() {
        return Role;
    }

    public void setRole(TipoRole role) {
        Role = role;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public String getTia() {
        return Tia;
    }

    public void setTia(String tia) {
        Tia = tia;
    }

    public TipoPermissao getPermissao() {
        return Permissao;
    }

    public void setPermissao(TipoPermissao permissao) {
        Permissao = permissao;
    }

}