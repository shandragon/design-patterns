package br.edu.cerqueira.adailton.design;

import br.edu.cerqueira.adailton.design.strategy.*;

import br.edu.cerqueira.adailton.exception.CalculadoraException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StrategyPatternTest {
    @Test
    public void deveSomarDoisNumeros() {
        // Arrange
        AdicaoStrategy adicao = new AdicaoStrategy();
        double a = 5.0;
        double b = 3.0;

        // Act
        double resultado = adicao.calcular(a, b);

        // Assert
        assertEquals(8.0, resultado, 0.001);
    }

    @Test
    public void deveSubtrairDoisNumeros() {
        // Arrange
        SubtracaoStrategy subtracao = new SubtracaoStrategy();
        double a = 5.0;
        double b = 3.0;

        // Act
        double resultado = subtracao.calcular(a, b);

        // Assert
        assertEquals(2.0, resultado, 0.001);
    }

    @Test
    public void deveMultiplicarDoisNumeros() {
        // Arrange
        MultiplicacaoStrategy multiplicacao = new MultiplicacaoStrategy();
        double a = 5.0;
        double b = 3.0;

        // Act
        double resultado = multiplicacao.calcular(a, b);

        // Assert
        assertEquals(15.0, resultado, 0.001);
    }

    @Test
    public void deveDividirDoisNumeros() {
        // Arrange
        DivisaoStrategy divisao = new DivisaoStrategy();
        double a = 15.0;
        double b = 3.0;

        try {
            // Act
            double resultado = divisao.calcular(a, b);

            // Assert
            assertEquals(5.0, resultado, 0.001);
        } catch (CalculadoraException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void naoDeveDividirPorZero() {
        // Arrange
        DivisaoStrategy divisao = new DivisaoStrategy();
        double a = 15.0;
        double b = 0.0;

        // Act & Assert
        try {
            divisao.calcular(a, b);
        } catch (CalculadoraException e) {
            assertEquals(CalculadoraException.DIVISAO_POR_ZERO, e.getCode());
        }
    }

    @Test
    public void deveCalcularSoma() {
        // Arrange
        CalculadoraContext calculadora = new CalculadoraContext(Strategies.ADICAO);
        double a = 5.0;
        double b = 3.0;

        try {
            // Act
            double resultado = calculadora.executarCalculo(a, b);

            // Assert
            assertEquals(8.0, resultado, 0.001);
        } catch (CalculadoraException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deveCalcularSubtracao() {
        // Arrange
        CalculadoraContext calculadora = new CalculadoraContext(Strategies.SUBTRACAO);
        double a = 5.0;
        double b = 3.0;

        try {
            // Act
            double resultado = calculadora.executarCalculo(a, b);

            // Assert
            assertEquals(2.0, resultado, 0.001);
        } catch (CalculadoraException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deveCalcularMultiplicao() {
        // Arrange
        CalculadoraContext calculadora = new CalculadoraContext(Strategies.MULTIPLICACAO);
        double a = 5.0;
        double b = 3.0;

        try {
            // Act
            double resultado = calculadora.executarCalculo(a, b);

            // Assert
            assertEquals(15.0, resultado, 0.001);
        } catch (CalculadoraException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deveCalcularDivisao() {
        // Arrange
        CalculadoraContext calculadora = new CalculadoraContext(Strategies.DIVISAO);
        double a = 15.0;
        double b = 3.0;

        try {
            // Act
            double resultado = calculadora.executarCalculo(a, b);

            // Assert
            assertEquals(5.0, resultado, 0.001);
        } catch (CalculadoraException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void naoDeveCalcularDivisaoPorZero() {
        // Arrange
        CalculadoraContext calculadora = new CalculadoraContext(Strategies.DIVISAO);
        double a = 15.0;
        double b = 0;

        // Act & Assert
        try {
            double resultado = calculadora.executarCalculo(a, b);
        } catch (CalculadoraException e) {
            assertEquals(CalculadoraException.DIVISAO_POR_ZERO, e.getCode());
        }
    }
}
