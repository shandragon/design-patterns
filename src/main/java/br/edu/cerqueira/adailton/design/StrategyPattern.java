package br.edu.cerqueira.adailton.design;

import br.edu.cerqueira.adailton.design.strategy.CalculadoraContext;
import br.edu.cerqueira.adailton.util.Menu;

import java.util.Scanner;

public class StrategyPattern implements Pattern {
    @Override
    public void executar() {
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        this.explicacao();
        while(true) {
            menu.menuCalculadora();
            System.out.println("Digite a operacao desejada: ");
            int opcao = scanner.nextInt();
            if (opcao == 5) {
                System.out.println("Retornando ao menu principal...");
                break;
            }
            System.out.println("Digite o primeiro número: ");
            double a = scanner.nextDouble();
            System.out.println("Digite o segundo número: ");
            double b = scanner.nextDouble();
            CalculadoraContext calculadora = new CalculadoraContext(opcao);
            try {
                System.out.println("Resultado: " + calculadora.executarCalculo(a, b));
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    @Override
    public void explicacao() {
        System.out.println("O padrão Strategy (ou Estratégia) é um padrão de projeto comportamental que define " +
                "uma família de algoritmos, encapsula cada um deles e os torna intercambiáveis.");
        System.out.println("Strategy permite que o algoritmo varie independentemente dos clientes que o utilizam.");
    }
}
