package com.heroku.java.enuns;

public enum TipoPermissao {
    ADMIN("Administrador", "Permissão para administrar o sistema"),
    COMUM("Comum", "Permissão comum de usuário");

    private final String descricao;
    private final String detalhes;

    TipoPermissao(String descricao, String detalhes) {
        this.descricao = descricao;
        this.detalhes = detalhes;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDetalhes() {
        return detalhes;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
