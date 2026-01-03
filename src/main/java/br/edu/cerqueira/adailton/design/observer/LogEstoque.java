package br.edu.cerqueira.adailton.design.observer;

public class LogEstoque implements Subscriber {

    @Override
    public void atualizar(EstoqueEvent evento, String mensagem) {
        System.out.println("Registrando o evento " + evento + " com a mensagem " + mensagem);
    }
}
