package br.edu.cerqueira.adailton.design.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Publisher {
    protected List<Subscriber> subscribers = new ArrayList<>();

    public void registrar(Subscriber subscriber) {
        subscribers.add(subscriber);
    }
    public void remover(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notificar(EstoqueEvent evento, String mensagem) {
        System.out.println("Notificando " + subscribers.size() + " assinantes.");
        for (Subscriber subscriber : subscribers) {
            subscriber.atualizar(evento, mensagem);
        }
    }
}
