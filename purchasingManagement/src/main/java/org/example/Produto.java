package org.example;

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getSubTotal() {
        return preco * quantidade;
    }

    @Override
    public String toString() {
        return nome + " - Valor Unit: R$ " + String.format("%.2f", preco) + " - Qtd: " + quantidade + " - Sub-total: R$ " + String.format("%.2f", getSubTotal());
    }
}