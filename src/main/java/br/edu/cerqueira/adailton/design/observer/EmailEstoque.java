package br.edu.cerqueira.adailton.design.observer;

public class EmailEstoque implements Subscriber {

    @Override
    public void atualizar(EstoqueEvent evento, String mensagem) {
        if (evento.equals(EstoqueEvent.PRODUTO_ADICIONADO)) {
            System.out.println("Produto adicionado com a mensagem " + mensagem);
        }
    }
}
