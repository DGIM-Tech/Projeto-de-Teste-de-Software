/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loja;

/**
 *
 * @author iandr
 */
class Categoria {
    private String nomeCategoria;
    private int codico;

    public Categoria(String nomeCategoria, int codico) {
        this.nomeCategoria = nomeCategoria;
        this.codico = codico;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public int getCodico() {
        return codico;
    }

    @Override
    public String toString() {
        return "Categoria{" + "nomeCategoria=" + nomeCategoria + ", codico=" + codico + '}';
    }



    
} 