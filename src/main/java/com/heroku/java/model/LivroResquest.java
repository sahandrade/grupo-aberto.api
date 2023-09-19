package com.heroku.java.model;

public class LivroResquest {
    private String titulo;
    private String genero;
    private String anoEdicao;
    private String editora;
    private String autor;
    private String qtdePaginas;
    private String ISBN;
    private String qtdeDisponivel;
    private String valor;
    
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getAnoEdicao() {
        return anoEdicao;
    }
    public void setAnoEdicao(String anoEdicao) {
        this.anoEdicao = anoEdicao;
    }
    public String getEditora() {
        return editora;
    }
    public void setEditora(String editora) {
        this.editora = editora;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getQtdePaginas() {
        return qtdePaginas;
    }
    public void setQtdePaginas(String qtdePaginas) {
        this.qtdePaginas = qtdePaginas;
    }
    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }
    public String getQtdeDisponivel() {
        return qtdeDisponivel;
    }
    public void setQtdeDisponivel(String qtdeDisponivel) {
        this.qtdeDisponivel = qtdeDisponivel;
    }
    public String getValor() {
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }
    public LivroResquest(String titulo, String genero, String anoEdicao, String editora, String autor,
            String qtdePaginas, String iSBN, String qtdeDisponivel, String valor) {
        this.titulo = titulo;
        this.genero = genero;
        this.anoEdicao = anoEdicao;
        this.editora = editora;
        this.autor = autor;
        this.qtdePaginas = qtdePaginas;
        ISBN = iSBN;
        this.qtdeDisponivel = qtdeDisponivel;
        this.valor = valor;
    }
}
