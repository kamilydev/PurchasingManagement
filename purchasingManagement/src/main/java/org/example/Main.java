package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n### Carrinho de compras ###");
            System.out.println("_____________________________________________________________________________________________________");
            System.out.println("## O que deseja executar? ##");
            System.out.println("Opção 1 - Cadastro de produto");
            System.out.println("Opção 2 - Alterar um produto");
            System.out.println("Opção 3 - Excluir um produto");
            System.out.println("Opção 4 - Consultar produtos no carrinho");
            System.out.println("Opção 5 - Realizar compra");
            System.out.println("Opção 0 - Encerrar programa");
            System.out.println("_____________________________________________________________________________________________________");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // limpeza de buffer

            switch (opcao) {
                case 1:
                    cadastrarProduto(carrinho, scanner);
                    break;
                case 2:
                    alterarProduto(carrinho, scanner);
                    break;
                case 3:
                    excluirProduto(carrinho, scanner);
                    break;
                case 4:
                    consultarProdutos(carrinho);
                    break;
                case 5:
                    realizarCompra(carrinho);
                    break;
                case 0:
                    System.out.println("Obrigado pela compra :)\nVolte sempre!");
                    return;
                default:
                    System.out.println("Ainda não temos essa opção :( \nMas iremos trabalhar para implementá-la!");
            }
        }
    }

    private static void cadastrarProduto(CarrinhoDeCompras carrinho, Scanner scanner) {

        System.out.print("Quantos produtos deseja cadastrar? ");
        int quantidadeProdutos = scanner.nextInt();
        scanner.nextLine(); // limpeza de buffer

        for (int i = 0; i < quantidadeProdutos; i++) {
            System.out.println("\n### Carrinho de compras ###");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Cadastro de produtos\n");

            System.out.print("Nome do produto: ");
            String nome = scanner.nextLine();

            System.out.print("Preço do produto: ");
            double preco = scanner.nextDouble();
            scanner.nextLine(); // limpeza de buffer

            System.out.print("Quantidade do produto: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine(); // limpeza de buffer


            Produto produto = new Produto(nome, preco, quantidade);
            carrinho.adicionarProduto(produto);

            System.out.println("Produto cadastrado com sucesso!");
            System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }

    }

    private static void alterarProduto(CarrinhoDeCompras carrinho, Scanner scanner) {
        System.out.println("\n### Carrinho de compras ###");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Alterar de produtos\n");

        System.out.print("Nome do produto que deseja alterar: ");
        String nome = scanner.nextLine();

        System.out.print("Novo preço do produto: ");
        double novoPreco = scanner.nextDouble();
        scanner.nextLine(); // limpeza de buffer

        System.out.print("Nova quantidade do produto: ");
        int novaQuantidade = scanner.nextInt();
        scanner.nextLine(); // limpeza de buffer

        carrinho.alterarProduto(nome, novoPreco, novaQuantidade);
        System.out.println("Produto alterado com sucesso!");
        System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

    }

    private static void excluirProduto(CarrinhoDeCompras carrinho, Scanner scanner) {
        System.out.println("\n### Carrinho de compras ###");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Exclusão de produtos\n");

        System.out.print("Nome do produto que deseja excluir: ");
        String nome = scanner.nextLine();

        carrinho.deletarProduto(nome);
        System.out.println("Produto excluído com sucesso!");
        System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

    }

    private static void consultarProdutos(CarrinhoDeCompras carrinho) {
        System.out.println("\n### Carrinho de compras ###");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Produtos no carrinho:\n");
        carrinho.listarProdutos();
    }

    private static void realizarCompra(CarrinhoDeCompras carrinho) {
        double total = carrinho.calcularTotal();
        System.out.println("\n### Carrinho de compras ###");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        System.out.println("Total da compra: R$ " + String.format("%.2f", total));
    }
}