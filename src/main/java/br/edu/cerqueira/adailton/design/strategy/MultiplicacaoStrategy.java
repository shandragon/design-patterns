package br.edu.cerqueira.adailton.design.strategy;

public class MultiplicacaoStrategy implements OperacaoStrategy {
    @Override
    public double calcular(double a, double b) {
        return a * b;
    }
}
