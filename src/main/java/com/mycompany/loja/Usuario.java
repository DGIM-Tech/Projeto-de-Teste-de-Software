/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loja;

/**
 *
 * @author iandr
 */
public abstract class Usuario  {
    protected String login;
    protected String senha;
    private  String cpf;

    public Usuario(String login, String senha, String cpf) {
        this.login = login;
        this.senha = senha;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    
}