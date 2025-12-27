package br.edu.cerqueira.adailton.design.strategy;

import br.edu.cerqueira.adailton.exception.CalculadoraException;

public class DivisaoStrategy implements OperacaoStrategy {
    @Override
    public double calcular(double a, double b) throws CalculadoraException {
        if (b == 0) {
            throw new CalculadoraException(CalculadoraException.DIVISAO_POR_ZERO, "Divisão por zero não é permitida.");
        }
        return a / b;
    }
}
