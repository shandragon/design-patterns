package br.edu.cerqueira.adailton.design;

import br.edu.cerqueira.adailton.design.observer.Estoque;
import br.edu.cerqueira.adailton.exception.EstoqueException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ObserverPatternTest {
    @Test
    public void deveAdicionarProdutoEstoque() {
        // Arrange
        Estoque estoque = new Estoque();
        String nome = "CANETA";
        int quantidade = 100;

        // Act
        int quantidadeAtual = estoque.adicionarProduto(nome, quantidade);

        // Assert
        assertEquals(quantidade, quantidadeAtual);
    }

    @Test
    public void deveAdicionarQuantidadeProdutoEstoque() {
        // Arrange
        Estoque estoque = new Estoque();
        String nome = "CADERNO";
        int quantidadeInicial = 50;
        int quantidadeAdicionar = 30;

        // Act
        estoque.adicionarProduto(nome, quantidadeInicial);
        int quantidadeAtual = estoque.adicionarProduto(nome, quantidadeAdicionar);

        // Assert
        assertEquals(80, quantidadeAtual);
    }

    @Test
    public void deveRemoverProdutoEstoque() {
        // Arrange
        Estoque estoque = new Estoque();
        String nome = "LAPIS";
        int quantidadeInicial = 70;
        int quantidadeRemover = 20;

        try {
            // Act
            estoque.adicionarProduto(nome, quantidadeInicial);
            int quantidadeAtual = estoque.removerProduto(nome, quantidadeRemover);

            // Assert
            assertEquals(50, quantidadeAtual);
        } catch (EstoqueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void naoDeveRemoverProdutoInexistente() {
        // Arrange
        Estoque estoque = new Estoque();
        String nome = "LAPIS";
        int quantidade = 70;

        try {
            // Act
            estoque.removerProduto(nome, quantidade);
        } catch (EstoqueException e) {
            assertEquals(EstoqueException.PRODUTO_NAO_ENCONTRADO, e.getCode());
        }
    }

    @Test
    public void naoDeveRemoverNegativo() {
        // Arrange
        Estoque estoque = new Estoque();
        String nome = "LAPIS";
        int quantidadeInicial = 70;
        int quantidade = 100;
        estoque.adicionarProduto(nome, quantidadeInicial);

        try {
            // Act
            int quantidadeAtual = estoque.removerProduto(nome, quantidade);
            assertTrue(quantidadeAtual >= 0);
        } catch (EstoqueException e) {
            assertEquals(EstoqueException.ESTOQUE_NEGATIVO, e.getCode());
        }
    }
}
