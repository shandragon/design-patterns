package br.edu.cerqueira.adailton.design.observer;

import br.edu.cerqueira.adailton.exception.EstoqueException;

import java.util.Map;

public class Estoque {
    private Map<String, Integer> produtos;

    public Estoque() {
        produtos = new java.util.HashMap<>();
    }

    public int adicionarProduto(String nome, int quantidade) {
        if (produtos.containsKey(nome)) {
            int quantidadeAtual = produtos.get(nome);
            quantidadeAtual += quantidade;
            produtos.put(nome, quantidadeAtual);
            return quantidadeAtual;
        } else {
            produtos.put(nome, quantidade);
        }
        return produtos.get(nome);
    }

    public int removerProduto(String nome, int quantidade) throws EstoqueException {
        if (produtos.containsKey(nome)) {
            int quantidadeAtual = produtos.get(nome);
            quantidadeAtual -= quantidade;
            if (quantidadeAtual < 0) {
                throw new EstoqueException(EstoqueException.ESTOQUE_NEGATIVO,
                        "Não é possível remover " + quantidade + " unidades do produto " + nome +
                                ". Estoque insuficiente.");
            }
            produtos.put(nome, quantidadeAtual);
        } else {
            throw new EstoqueException(EstoqueException.PRODUTO_NAO_ENCONTRADO,
                    "Produto " + nome + " não encontrado no estoque.");
        }
        return produtos.get(nome);
    }

    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("O estoque está vazio.");
            return;
        }
        for (Map.Entry<String, Integer> entry : produtos.entrySet()) {
            System.out.println("Produto: " + entry.getKey() + ", Quantidade: " + entry.getValue());
        }
    }
}
