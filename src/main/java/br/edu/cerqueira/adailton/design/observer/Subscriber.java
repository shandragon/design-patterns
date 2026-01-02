package br.edu.cerqueira.adailton.design.observer;

public interface Subscriber {
    void atualizar(EstoqueEvent evento, String mensagem);
}
