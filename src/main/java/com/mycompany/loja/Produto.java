/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loja;

/**
 *
 * @author iandr
 */
class Produto {
    private String nome;
    private double preco;
    private String descricao;
    private int codigo;
    private Categoria categoria;

    public Produto( String nome, double preco, String descricao, int codigo, Categoria categoria) {
       
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.codigo = codigo;
        this.categoria = categoria;
    }



    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Categoria getCategoria() {
        return categoria;
    }
 public void editarPreco(double novoPreco) {
        this.preco = novoPreco;
        System.out.println("Preço do produto editado com sucesso. Novo preço: " + this.preco);
    }

    @Override
    public String toString() {
        return "Produto{" + "nome=" + nome + ", preco=" + preco + ", descricao=" + descricao + ", codigo=" + codigo +  ", categoria=" + categoria.getNomeCategoria() +  '}';
    }
    
}
