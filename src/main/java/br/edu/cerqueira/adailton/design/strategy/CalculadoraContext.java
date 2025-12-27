package br.edu.cerqueira.adailton.design.strategy;

import br.edu.cerqueira.adailton.exception.CalculadoraException;

public class CalculadoraContext {
    private OperacaoStrategy operacaoStrategy;

    public CalculadoraContext(int operacao) {
        Strategies strategies = new Strategies();
        this.operacaoStrategy = strategies.getStrategy(operacao);
    }

    public double executarCalculo(double a, double b) throws CalculadoraException {
        if (this.operacaoStrategy == null) {
            throw new CalculadoraException(CalculadoraException.OPERACAO_INVALIDA, "Operação inválida.");
        }
        return operacaoStrategy.calcular(a, b);
    }
}
