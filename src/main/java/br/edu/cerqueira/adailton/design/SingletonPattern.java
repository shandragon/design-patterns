package br.edu.cerqueira.adailton.design;

import br.edu.cerqueira.adailton.design.observer.EmailEstoque;
import br.edu.cerqueira.adailton.design.singleton.ConfiguracaoSingleton;
import br.edu.cerqueira.adailton.exception.EstoqueException;
import br.edu.cerqueira.adailton.util.Menu;

import java.util.Scanner;

public class SingletonPattern implements Pattern {
    @Override
    public void executar() {
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        this.explicacao();
        boolean isRunning = true;
        while(isRunning) {
            menu.menuSingleton();
            System.out.println("Digite a opção desejada: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o título:");
                    String titulo = scanner.nextLine();
                    ConfiguracaoSingleton conf = ConfiguracaoSingleton.getInstance(titulo);
                    conf.imprimir();
                    break;
                case 2:
                    System.out.println("Digite um novo valor:");
                    String valor = scanner.nextLine();
                    ConfiguracaoSingleton.getInstance().setValor(valor);
                    break;
                case 3:
                    System.out.println("Listando valores");
                    ConfiguracaoSingleton.getInstance().imprimir();
                    break;
                case 0:
                    isRunning = false;
                    System.out.println("Retornando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    @Override
    public void explicacao() {
        System.out.println("O padrão Singleton tem como objetivo principal é garantir que uma classe tenha " +
                "apenas uma única instância durante toda a execução de um programa, fornecendo, simultaneamente, " +
                "um ponto de acesso global para essa instância.");
        System.out.println("No nosso exemplo, iremos criar uma instância de configuração com um título e tempo de criação. " +
                "Note que, mesmo chamando chamando o método getInstance várias vezes, os valores não se alteram.");
    }
}
