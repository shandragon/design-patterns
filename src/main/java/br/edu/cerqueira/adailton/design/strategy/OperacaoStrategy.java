package br.edu.cerqueira.adailton.design.strategy;

import br.edu.cerqueira.adailton.exception.CalculadoraException;

public interface OperacaoStrategy {
    double calcular(double a, double b) throws CalculadoraException;
}
