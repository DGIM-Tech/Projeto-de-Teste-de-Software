/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loja;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author iandr
 */

// Classe GerenciarSistema

public class GerenciarSistema {
    private List<Categoria> categorias;
    private List<Produto> produtos;
    
    public GerenciarSistema() {
        this.categorias = new ArrayList<>();
        this.produtos = new ArrayList<>();
    }
  
    // Método para adicionar uma categoria
    public void adicionarCategoria(Categoria categoria) {
        for (Categoria c : categorias) {
            if (categoria.getCodico() == c.getCodico()) {
                System.out.println("Erro: Não é possível cadastrar categorias com códigos iguais");
                return;
            }
        }
        categorias.add(categoria);
    }

    // Método para remover uma categoria pelo índice

    // Método para listar todas as categorias
    public void listarCategorias() {
        for (Categoria categoria : categorias) {
            System.out.println("Código: " + categoria.getCodico() + " | Nome: " + categoria.getNomeCategoria());
        }
    }
      public void buscarProduto(int codigoProduto) {
    for (Produto produto : produtos) {
        if (produto.getCodigo() == codigoProduto) {
            System.out.println("Produto encontrado:\n" + produto.toString());
            return;
        }
    }
    System.out.println("Produto não encontrado.");
}
    // Método para adicionar um produto
    public void adicionarProduto(Produto produto) {
        for (Produto p : produtos) {
            if (produto.getCodigo() == p.getCodigo()) {
                System.out.println("Erro: Não é possível cadastrar produtos com códigos iguais");
                return;
            }
        }
        produtos.add(produto);
    }
    
    // Método para remover um produto pelo código
    public void removerProduto(int codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                produtos.remove(produto);
                System.out.println("Produto removido com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado!");
    }

public void editarPrecoProduto(int codigoProduto, double novoPreco) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigoProduto) {
                produto.editarPreco(novoPreco);
                return;
            }
        }
        System.out.println("Produto não encontrado. Não foi possível editar o preço.");
    }
    // Método para listar todos os produtos
    public void listarProdutos() {
        for (Produto produto : produtos) {
           System.out.println(produto.toString());
        }
    }
    
    public void MenuCategoria() {
        System.out.println("Menu de Gerenciamento de Categorias:");
        System.out.println("1 - Adicionar Categoria");
        System.out.println("2 - Remover Categoria");
        System.out.println("3 - Listar Categorias");
        System.out.println("5 - Voltar");
        System.out.print("Escolha uma opção: ");
    }
    
    public void MenuProduto() {
        System.out.println("Menu de Gerenciamento de Produto:");
        System.out.println("1 - Adicionar Produto");
        System.out.println("2 - Remover Produto");
        System.out.println("3 - Listar Categorias e Produtos");
        System.out.println("4 - Editar Produto");
        System.out.println("5 - Voltar");
        System.out.print("Escolha uma opção: ");
    }
    
    // menus dos usuarios
    
        public void MenuGerente() {
            System.out.println("Menu do Gerente:");
            System.out.println("1 - Produto");
            System.out.println("2 - Categoria ");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
    }
    
     public  void  MenuPrincipal(){
          System.out.println("Bem-vindo a loja!");
            System.out.println("1 - Area de Cadastro Cliente");
            System.out.println("2 - Area de Cadastro Gerente");
            System.out.println("3 - Realizar Login Cliente");
            System.out.println("4 - Realizar Login Gerente");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
     }
     public  void MenuCliente() {
        System.out.println("Menu do Cliente:");
        System.out.println("1 - Ver Produtos Disponivel");
        System.out.println("2 - busca produto");
        System.out.println("3 - adcionar ao carrinho");
         System.out.println("4 - Realizar comprar");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
        // Lógica do menu do cliente
    }
    public Produto buscarProdutoPorCodigo(int codigoProduto) {
    for (Produto produto : produtos) {
        if (produto.getCodigo() == codigoProduto) {
            return produto;
        }
    }
    return null; // Retorna null se o produto não for encontrado
}
public void removerCategoriaProdutos(int codigo) {
    Iterator<Categoria> iterator = categorias.iterator();
    List<Produto> produtosARemover = new ArrayList<>();

    while (iterator.hasNext()) {
        Categoria categoria = iterator.next();

        if (categoria.getCodico() == codigo) {
            // Identificar produtos associados à categoria
            for (Produto produto : produtos) {
                if (produto.getCategoria() != null && produto.getCategoria().equals(categoria)) {
                    produtosARemover.add(produto);
                }
            }

            // Remover a categoria
            iterator.remove();
            System.out.println("Categoria removida com sucesso!");

            // Remover produtos associados à categoria
            for (Produto produto : produtosARemover) {
                produtos.remove(produto);
            }

            System.out.println("Produtos associados à categoria removidos com sucesso!");
            return;
        }
    }

    System.out.println("Categoria não encontrada!");
}
public Categoria encontrarCategoriaPorCodigo(int codigoCategoria) {
    for (Categoria categoria : categorias) {
        if (categoria.getCodico() == codigoCategoria) {
            return categoria;
        }
    }
    return null; // Retorna null se a categoria não for encontrada
}

}
    


