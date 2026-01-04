package br.edu.cerqueira.adailton;

import br.edu.cerqueira.adailton.design.ObserverPattern;
import br.edu.cerqueira.adailton.design.Pattern;
import br.edu.cerqueira.adailton.design.SingletonPattern;
import br.edu.cerqueira.adailton.design.StrategyPattern;
import br.edu.cerqueira.adailton.util.Menu;
import br.edu.cerqueira.adailton.util.MenuOpcao;

import java.util.HashMap;
import java.util.Scanner;

public class DesignPatterns {
    private HashMap<Integer, Pattern> padroes;

    public DesignPatterns() {
        this.padroes = new HashMap<>();
        this.padroes.put(MenuOpcao.STRATEGY.getCodigo(), new StrategyPattern());
        this.padroes.put(MenuOpcao.OBSERVER.getCodigo(), new ObserverPattern());
        this.padroes.put(MenuOpcao.SINGLETON.getCodigo(), new SingletonPattern());
    }

    public static void main(String[] args) {
        DesignPatterns app = new DesignPatterns();
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);

        while (true)  {
            menu.menuPrincipal();
            System.out.println("Digite a opção desejada: ");
            int opcao = scanner.nextInt();
            if (MenuOpcao.SAIR.equals(opcao)) {
                System.out.println("Encerrando o programa...");
                break;
            }

            Pattern padrao = app.getPadrao(opcao);
            if (padrao != null) {
                padrao.executar();
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public Pattern getPadrao(int codigo) {
        return this.padroes.get(codigo);
    }
}
