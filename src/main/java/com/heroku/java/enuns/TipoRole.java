package com.heroku.java.enuns;

public enum TipoRole {
    ALUNO("Aluno", "Função de estudante"),
    BIBLIOTECARIO("Bibliotecário", "Função de bibliotecário");


    private final String nome;
    private final String descricao;

    TipoRole(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}