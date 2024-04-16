/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loja;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author gerso
 */
public class Carrinho {
      private List<Produto> itens;
    private final Scanner scanner;

    public Carrinho() {
        this.itens = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void adicionarItem(Produto produto) {
        itens.add(produto);
        System.out.println("Produto adicionado ao carrinho: " + produto.getNome());
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto produto : itens) {
            total += produto.getPreco();
        }
        return total;
    }

    public void comprar(GerenciarSistema gs) {
        System.out.println("Itens no Carrinho:");
        listarItens();

        System.out.print("Digite o código do produto que deseja comprar: ");
        int codigoCompra = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        Produto produtoCompra = gs.buscarProdutoPorCodigo(codigoCompra);

        if (produtoCompra != null && itens.contains(produtoCompra)) {
            System.out.println("Compra realizada! Produto comprado: " + produtoCompra.getNome() + " | Valor: R$" + produtoCompra.getPreco());
            itens.remove(produtoCompra); // Remove o produto do carrinho após a compra
        } else {
            System.out.println("Produto não encontrado no carrinho. Compra cancelada.");
        }
     
    }


    public void listarItens() {
        System.out.println("Itens no Carrinho:");
        for (Produto produto : itens) {
            System.out.println("Código: " + produto.getCodigo() + " | Nome: " + produto.getNome() + " | Preço: R$" + produto.getPreco());
        }
        System.out.println("Total da compra: R$" +  calculartotal());
    }
public  double calculartotal() {
      double total = 0;
        for (Produto produto : itens) {
            total += produto.getPreco();
        }
        return total;
}
public boolean contemItemComCodigo(int codigo) {
    for (Produto produto : itens) {
        if (produto.getCodigo() == codigo) {
            return true;
        }
    }
    return false;
}
}
