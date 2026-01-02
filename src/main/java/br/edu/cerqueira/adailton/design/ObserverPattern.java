package br.edu.cerqueira.adailton.design;

import br.edu.cerqueira.adailton.design.observer.Estoque;
import br.edu.cerqueira.adailton.exception.EstoqueException;
import br.edu.cerqueira.adailton.util.Menu;

import java.util.Locale;
import java.util.Scanner;

public class ObserverPattern implements Pattern {
    @Override
    public void executar() {
        Estoque estoque = new Estoque();
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        this.explicacao();
        boolean isRunning = true;
        while(isRunning) {
            menu.menuEstoque();
            System.out.println("Digite a opção desejada: ");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    estoque.adicionarProduto(getNome(scanner).toUpperCase(), getQuantidade(scanner));
                    System.out.println("Produto adicionado ao estoque.");
                    break;
                case 2:
                    try {
                        estoque.removerProduto(getNome(scanner).toUpperCase(), getQuantidade(scanner));
                    } catch (EstoqueException e) {
                        System.out.println("Erro: " + e.getMessage());
                        break;
                    }
                    System.out.println("Produto removido do estoque.");
                    break;
                case 3:
                    estoque.listarProdutos();
                    break;
                case 4:
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
        System.out.println("O padrão Observer define uma dependência um-para-muitos entre objetos," +
                " de forma que quando um objeto muda de estado, todos os seus dependentes são notificados" +
                " e atualizados automaticamente.");
    }

    private String getNome(Scanner scanner) {
        System.out.println("Digite o nome do produto: ");
        return scanner.next();
    }

    private Integer getQuantidade(Scanner scanner) {
        System.out.println("Digite a quantidade do produto: ");
        return scanner.nextInt();
    }
}
