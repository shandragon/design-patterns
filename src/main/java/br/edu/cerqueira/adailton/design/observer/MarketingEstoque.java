package br.edu.cerqueira.adailton.design.observer;

public class MarketingEstoque implements Subscriber {
    @Override
    public void atualizar(EstoqueEvent evento, String mensagem) {
        System.out.println("Notificando a equipe de marketing sobre mudança de estoque!");
    }
}
