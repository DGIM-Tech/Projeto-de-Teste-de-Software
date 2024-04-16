/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loja;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gerso
 */
public class GerenciarContas {
     private static List<Cliente> clientesCadastrados = new ArrayList<>();
     private static List<Gerente> gerentesCadastrados = new ArrayList<>();


    // Método para adicionar um cliente
    public static void adicionarCliente(Cliente cliente) {
        for (Cliente c : clientesCadastrados) {
            if (c.getCpf().equals(cliente.getCpf()) || c.getLogin().equals(cliente.getLogin())) {
                System.out.println("Erro: CPF ou login ja foi cadastrado no sistema. Escolha outro CPF ou outro login.");
                return;
            }
        }
        clientesCadastrados.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    // Método para validar o login de um cliente
    public static Cliente validarCliente(String login, String senha) {
        for (Cliente cliente : clientesCadastrados) {
            if (cliente.getLogin().equals(login) && cliente.getSenha().equals(senha)) {
                System.out.println("Login realizado com sucesso!");
                return cliente;
            }
        }
        System.out.println("Erro: Login ou senha inválidos.");
        return null;
    }
    // metodos do gerente 
    public static void adicionarGerente(Gerente gerente) {
        for (Gerente g : gerentesCadastrados) {
            if (g.getCpf().equals(gerente.getCpf()) || g.getLogin().equals(gerente.getLogin())) {
                System.out.println("Erro: CPF ou login já foi cadastrado no sistema. Escolha outro cpf ou outro login.");
                return;
            }
        }
        gerentesCadastrados.add(gerente);
        System.out.println("Gerente cadastrado com sucesso!");
    }

    // Método para validar o login de um gerente
    public static Gerente validarGerente(String login, String senha) {
        for (Gerente gerente : gerentesCadastrados) {
            if (gerente.getLogin().equals(login) && gerente.getSenha().equals(senha)) {
                System.out.println("Login de gerente realizado com sucesso!");
                return gerente;
            }
        }
        System.out.println("Erro: Login ou senha inválidos para gerente.");
        return null;
    }
    
}
