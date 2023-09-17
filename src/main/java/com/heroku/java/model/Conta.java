package com.heroku.java.model;

import com.heroku.java.enuns.TipoRole;
import com.heroku.java.util.UsuarioUtil;

public class Conta extends Base{
    private TipoRole role;
    private String celular;
    private String email;
    private String senha;
    private boolean habilitado = true;
    private Usuario usuario;


    public Conta(TipoRole role, String celular, String email, String senha,
           Usuario usuario) {
        this.role = role;
        this.celular = celular;
        this.email = email;
        this.senha = senha;
        this.usuario = usuario;
    }

    public Conta() {
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoRole getRole() {
        return this.role;
    }

    public void setRole(TipoRole Role) {
        if (Role == null) {
            throw new IllegalArgumentException("O campo Role não pode ser nulo");
        }
        this.role = Role;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String Celular) {
        if (Celular == null || Celular.isEmpty()) {
            throw new IllegalArgumentException("O campo Celular não pode ser nulo");
        }
        this.celular = Celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        // Verifica se Email é nulo ou em branco antes de atribuir
        if (Email == null || Email.isBlank()) {
            throw new IllegalArgumentException("O campo Email não pode ser nulo nem em branco");
        }
        this.email = Email;
    }

    public String getSenha() {
        return senha;
    }

    public void generateSenha() {
        new UsuarioUtil();
        var senha = UsuarioUtil.CriptografarSenha(this.getSenha(), this.getEmail());
        this.setSenha(senha);
    }

    public boolean validarSenha(String senha, String email) {
        var senhaReq = UsuarioUtil.CriptografarSenha(senha, email);
        return senhaReq.equals(this.getSenha());
    }

    public void setSenha(String Senha) {
        // Verifica se Senha é nula ou em branco antes de atribuir
        if (Senha == null || Senha.isBlank()) {
            throw new IllegalArgumentException("O campo Senha não pode ser nulo nem em branco");
        }
        this.senha = Senha;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public void createConta(UsuarioRequest request){
        setEmail(request.Email);
        setSenha(request.Senha);
        setRole(request.Role);
        setCelular(request.Celular);
    }
}