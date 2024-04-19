/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.loja;

import java.util.Scanner;
import sun.jvm.hotspot.code.Location;

/**
 *
 * @author iandr
 */
public class Loja {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcao = 0;
        int op1;
        int opcaoCliente = 0;
        int opcaoGerente = 0;

        GerenciarContas gc = new GerenciarContas();
        GerenciarSistema gs = new GerenciarSistema();
        Carrinho carrinho = new Carrinho();
        Cliente cliente = null;
        Gerente gerente = null;
        Categoria categoria = null;
        Produto produto = null;

        // Menu
        do {
            try {
                gs.MenuPrincipal();

                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer

                switch (opcao) {
                    case 1:
                        System.out.print("Crie seu login: ");
                        String loginCliente = scanner.nextLine();
                        System.out.print("Crie sua senha: ");
                        String senhaCliente = scanner.nextLine();
                        System.out.print("Digite seu CPF: ");
                        String cpfCliente = scanner.nextLine();
                        if (loginCliente.trim().isEmpty() || senhaCliente.trim().length() < 8) {
                            System.out.println("Erro: O cadastro de login ou cpf  não pode estar em branco e a senha deve ter pelo menos 8 caracteres.");
                        } else {
                            cliente = new Cliente(loginCliente, senhaCliente, cpfCliente);
                            gc.adicionarCliente(cliente);
                        }
                        break;
                    case 2:
                        System.out.print("Crie seu login de Gerente: ");
                        String loginGerente = scanner.nextLine();
                        System.out.print("Crie sua senha de Gerente: ");
                        String senhaGerente = scanner.nextLine();
                        System.out.print("Digite seu CPF: ");
                        String cpfGerente = scanner.nextLine();
                        if (loginGerente.trim().isEmpty() || senhaGerente.trim().length() < 8) {
                            System.out.println("Erro: O login não pode estar em branco e a senha deve ter pelo menos 8 caracteres.");
                        } else {
                            gerente = new Gerente(loginGerente, senhaGerente, cpfGerente);
                            gc.adicionarGerente(gerente);
                        }
                        break;
                    case 3:
                        // Login Cliente
                        System.out.print("Digite o login do cliente: ");
                        String loginClienteLogin = scanner.nextLine();
                        System.out.print("Digite a senha do cliente: ");
                        String senhaClienteLogin = scanner.nextLine();
                        cliente = gc.validarCliente(loginClienteLogin, senhaClienteLogin);

                        // Se o login for bem-sucedido, exibir menu do cliente
                        if (cliente != null) {
                            do {
                                try {
                                    gs.MenuCliente();
                                    opcaoCliente = scanner.nextInt();
                                    scanner.nextLine(); // Limpar o buffer
                                    switch (opcaoCliente) {
                                        case 1:
                                            gs.listarProdutos();
                                            break;
                                        case 2:
                                            System.out.print("Digite o código do produto para busca: ");
                                            int codigoProdutoBusca = scanner.nextInt();
                                            gs.buscarProduto(codigoProdutoBusca);
                                            break;
                                        case 3:
                                            System.out.print("Digite o código do produto que deseja adicionar ao carrinho: ");
                                            int codigoProduto = scanner.nextInt();
                                            scanner.nextLine(); // Limpar o buffer

                                            // Chama o método buscarProduto para obter os detalhes do produto
                                            Produto produtoSelecionado = gs.buscarProdutoPorCodigo(codigoProduto);

                                            if (produtoSelecionado != null) {
                                                // Verifica se o produto já está no carrinho
                                                if (carrinho.contemItemComCodigo(codigoProduto)) {
                                                    System.out.println("Este produto já foi adicionado ao carrinho.");
                                                } else {
                                                    carrinho.adicionarItem(produtoSelecionado);
                                                    System.out.println("Produto adicionado ao carrinho com sucesso.");
                                                }
                                            } else {
                                                System.out.println("Produto não encontrado.");
                                            }
                                            break;
                                        case 4:
                                            carrinho.comprar(gs);
                                            break;
                                        case 0:
                                            System.out.println("Saindo...");
                                            break;
                                        default:
                                            System.out.println("Opção inválida!");
                                    }
                                } catch (java.util.InputMismatchException e) {
                                    System.out.println("Por favor, digite um número válido.");
                                    scanner.nextLine(); // Limpar o buffer
                                }
                            } while (opcaoCliente != 0);
                        }
                        break;
                    case 4:
                        // Login Gerente
                        System.out.print("Digite o login do Gerente: ");
                        String loginGerenteLogin = scanner.nextLine();
                        System.out.print("Digite a senha do Gerente: ");
                        String senhaGerenteLogin = scanner.nextLine();
                        gerente = gc.validarGerente(loginGerenteLogin, senhaGerenteLogin);

                        // Se o login for bem-sucedido, exibir menu do gerente
                        if (gerente != null) {
                            do {
                                try {
                                    gs.MenuGerente();
                                    opcaoGerente = scanner.nextInt();
                                    scanner.nextLine(); // Limpar o buffer
                                    switch (opcaoGerente) {
                                        case 1:
                                            do {
                                                gs.MenuProduto();
                                                op1 = scanner.nextInt();
                                                switch (op1) {
                                                    case 1:
                                                        System.out.print("Digite o nome do produto: ");
                                                        String nome = scanner.next();
                                                      
                                                        System.out.print("Digite o preço do produto: ");
                                                        double preco = scanner.nextDouble();
                                                        scanner.nextLine(); // Limpeza do buffer

                                                        System.out.print("Digite a descrição do produto: ");
                                                        String descricao = scanner.nextLine();

                                                        System.out.print("Digite o código da categoria para adicionar o produto a essa categoria: ");
                                                        int codigoCategoriaProduto = scanner.nextInt();
                                                        scanner.nextLine(); 

                                                        Categoria categoriaProduto = gs.encontrarCategoriaPorCodigo(codigoCategoriaProduto);

                                                        System.out.print("Digite o código do produto: ");
                                                        int codigoProduto = scanner.nextInt();
                                                        scanner.nextLine(); 

                                                        if (nome.trim().isEmpty() || descricao.trim().isEmpty()) {
                                                            System.out.println("Erro: Nome do produto ou Descrição do produto não pode ter campos em branco");
                                                        } else {
                                                            if (categoriaProduto != null) {
                                                                produto = new Produto(nome, preco, descricao, codigoProduto, categoriaProduto);
                                                                gs.adicionarProduto(produto);
                                                                System.out.println("Produto adicionado com sucesso à categoria " + categoriaProduto.getNomeCategoria());
                                                            } else {
                                                                System.out.println("Categoria não encontrada. Produto não adicionado.");
                                                            }
                                                        }
                                                        break;
                                                    case 2:
                                                        System.out.print("Digite o código do produto para remover: ");
                                                        int codigoProdutoRemover = scanner.nextInt();
                                                        gs.removerProduto(codigoProdutoRemover);
                                                        break;
                                                    case 3:
                                                        gs.listarProdutos();
                                                        break;
                                                    case 4:
                                                        System.out.print("Digite o código do produto para editar o preço: ");
                                                        int codigoEditar = scanner.nextInt();
                                                        System.out.print("Digite o novo preço: ");
                                                        float novoPreco = scanner.nextFloat();
                                                        gs.editarPrecoProduto(codigoEditar, novoPreco);
                                                        break;
                                                    case 5:
                                                        System.out.println("Saindo...");
                                                        break;
                                                    default:
                                                        System.out.println("Opção inválida!");
                                                }
                                            } while (op1 != 5);
                                            break;
                                        case 2:
                                            int op2;
                                            do {
                                                gs.MenuCategoria(); // menu de categorias
                                                op2 = scanner.nextInt();
                                                switch (op2) {
                                                    case 1:
                                                        System.out.print("Digite o nome da categoria: ");
                                                        String nomeCategoria = scanner.next();

                                                        System.out.print("Digite o código da categoria: ");
                                                        int codigoCategoria = scanner.nextInt();
                                                        categoria = new Categoria(nomeCategoria, codigoCategoria);
                                                        gs.adicionarCategoria(categoria);
                                                        break;
                                                    case 2:
                                                        System.out.print("Digite o código da categoria para remover: ");
                                                        int codigoCategoriaRemover = scanner.nextInt();
                                                        gs.removerCategoriaProdutos(codigoCategoriaRemover);
                                                        break;
                                                    case 3:
                                                        System.out.println("Listando todas as categorias \n\n");
                                                        gs.listarCategorias();
                                                        break;
                                                    case 5:
                                                        System.out.println("Voltando...");
                                                        break;
                                                    default:
                                                        System.out.println("Opção inválida!");
                                                }
                                            } while (op2 != 5);
                                            break;
                                        case 0:
                                            System.out.println("Saindo...");
                                            break;
                                        default:
                                            System.out.println("Opção inválida!");
                                    }
                                } catch (java.util.InputMismatchException e) {
                                    System.out.println("Por favor, digite um número válido.");
                                    scanner.nextLine(); // Limpar o buffer
                                }
                            } while (opcaoGerente != 0);
                        }
                        break;
                    case 5:
                        System.out.println("Saindo...");
                        System.exit(0);
                    default:
                        System.out.println("Opção inválida!");
                }

            } catch (java.util.InputMismatchException e) {
                System.out.println("Por favor, digite um número válido.");
                scanner.nextLine(); // Limpar o buffer
            }
        } while (opcao != 5);
    }
}
