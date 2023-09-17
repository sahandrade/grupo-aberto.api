package com.heroku.java.model;

import org.bson.Document;

import com.heroku.java.enuns.TipoRole;

public class Aluno extends Usuario {

    private String tia;

    public Aluno(){}

    public Aluno(String nome, String sobrenome, TipoRole role, String celular, String email, String senha,
            String tia) {
        super(nome, sobrenome, role , celular, email, senha);
        this.tia = tia;
    }

    public String getTia() {
        return tia;
    }

    public void setTia(String Tia) {
        // Verifica se Tia é nula ou em branco antes de atribuir
        if (Tia == null || Tia.isBlank()) {
            throw new IllegalArgumentException("O campo Tia não pode ser nulo nem em branco");
        }
        this.tia = Tia;
    }


    @Override
    public void setPorTipoUsuario(UsuarioRequest request){
        setTia(request.Tia);
    }
}
