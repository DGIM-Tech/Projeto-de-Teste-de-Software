/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loja;
import java.util.Scanner;
/**
 *
 * @author iandr
 */
// Classe Gerente, herda de Usuario
class Gerente extends Usuario {


    public Gerente(String login, String senha, String cpf) {
        super(login, senha, cpf);
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public String getCpf(){
        return super.getCpf(); 
    }




}