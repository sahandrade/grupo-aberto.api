package com.heroku.java.model;

import com.heroku.java.enuns.TipoRole;

public class Usuario extends Base{
    private String nome;
    private String sobrenome;
    private TipoRole role;

    public Usuario() {
    }

    public Usuario(String id, String Nome, String Sobrenome, TipoRole Role, String Celular,
            String Email, String Senha) {
        super(id);
        this.nome = Nome;
        this.sobrenome = Sobrenome;
    }

    public Usuario(String Nome, String Sobrenome, TipoRole Role, String Celular, String Email,
            String Senha) {
        this.nome = Nome;
        this.sobrenome = Sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O campo Nome não pode ser nulo nem em branco");
        }
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        if (sobrenome == null || sobrenome.isBlank()) {
            throw new IllegalArgumentException("O campo Sobrenome não pode ser nulo nem em branco");
        }
        this.sobrenome = sobrenome;
    }

    public TipoRole getRole() {
        return role;
    }

    public void setRole(TipoRole Role) {
        if (Role == null) {
            throw new IllegalArgumentException("O campo Role não pode ser nulo");
        }
        this.role = Role;
    }

    public void setCampos(UsuarioRequest request, String email) {
        this.setNome(request.Nome);
        this.setSobrenome(request.Sobrenome);
        this.setRole(request.Role);
        this.setUsuarioCriou(email);
        setPorTipoUsuario(request);
    }

    public void setPorTipoUsuario(UsuarioRequest request) {
        // ... implementado por tido
    }

}