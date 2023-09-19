package com.heroku.java.model;

public class Livro extends Base{
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
        if (titulo == null) {
            throw new IllegalArgumentException("O campo titulo não pode ser nulo");
        }
        this.titulo = titulo;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        if (genero == null) {
            throw new IllegalArgumentException("O campo genero não pode ser nulo");
        }
        this.genero = genero;
    }
    public String getAnoEdicao() {
        return anoEdicao;
    }
    public void setAnoEdicao(String anoEdicao) {
        if (anoEdicao == null) {
            throw new IllegalArgumentException("O campo anoEdicao não pode ser nulo");
        }
        this.anoEdicao = anoEdicao;
    }
    public String getEditora() {
        return editora;
    }
    public void setEditora(String editora) {
        if (editora == null) {
            throw new IllegalArgumentException("O campo editora não pode ser nulo");
        }
        this.editora = editora;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        if (autor == null) {
            throw new IllegalArgumentException("O campo Autor não pode ser nulo");
        }
        this.autor = autor;
    }
    public String getQtdePaginas() {
        return qtdePaginas;
    }
    public void setQtdePaginas(String qtdePaginas) {
         if (qtdePaginas == null) {
            throw new IllegalArgumentException("O campo qtdePaginas não pode ser nulo");
        }
        this.qtdePaginas = qtdePaginas;
    }

    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String iSBN) {
        if (iSBN == null) {
            throw new IllegalArgumentException("O campo isbn não pode ser nulo");
        }
        ISBN = iSBN;
    }
    public String getQtdeDisponivel() {
        return qtdeDisponivel;
    }
    public void setQtdeDisponivel(String qtdeDisponivel) {
        if (qtdeDisponivel == null) {
            throw new IllegalArgumentException("O campo qtdeDisponivel não pode ser nulo");
        }
        this.qtdeDisponivel = qtdeDisponivel;
    }
    public String getValor() {
        return valor;
    }
    public void setValor(String valor) {
        if (valor == null) {
            throw new IllegalArgumentException("O campo valor não pode ser nulo");
        }
        this.valor = valor;
    }
    public Livro(String titulo, String genero, String anoEdicao, String editora, String autor,
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
