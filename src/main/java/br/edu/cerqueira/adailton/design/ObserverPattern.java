package br.edu.cerqueira.adailton.design;

import br.edu.cerqueira.adailton.design.observer.Estoque;
import br.edu.cerqueira.adailton.design.observer.EmailEstoque;
import br.edu.cerqueira.adailton.design.observer.LogEstoque;
import br.edu.cerqueira.adailton.design.observer.MarketingEstoque;
import br.edu.cerqueira.adailton.exception.EstoqueException;
import br.edu.cerqueira.adailton.util.Menu;

import java.util.Scanner;

public class ObserverPattern implements Pattern {
    private final Estoque estoque;
    private final Scanner scanner;
    private EmailEstoque emailAlert;

    public ObserverPattern() {
        estoque = new Estoque();
        scanner = new Scanner(System.in);
        estoque.registrar(new LogEstoque());
        estoque.registrar(new MarketingEstoque());
    }

    @Override
    public void executar() {
        Menu menu = new Menu();
        this.explicacao();
        boolean isRunning = true;
        while(isRunning) {
            menu.menuEstoque();
            System.out.println("Digite a opção desejada: ");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    estoque.adicionarProduto(getNome().toUpperCase(), getQuantidade());
                    System.out.println("Produto adicionado ao estoque.");
                    break;
                case 2:
                    try {
                        estoque.removerProduto(getNome().toUpperCase(), getQuantidade());
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
                    if (emailAlert == null) {
                        System.out.println("Registrando email.");
                        emailAlert = new EmailEstoque();
                        estoque.registrar(emailAlert);
                    } else {
                        System.out.println("Cancelando registro.");
                        estoque.remover(emailAlert);
                        emailAlert = null;
                    }
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
        System.out.println("O padrão Observer define uma dependência um-para-muitos entre objetos," +
                " de forma que quando um objeto muda de estado, todos os seus dependentes são notificados" +
                " e atualizados automaticamente.");
    }

    private String getNome() {
        System.out.println("Digite o nome do produto: ");
        return scanner.next();
    }

    private Integer getQuantidade() {
        System.out.println("Digite a quantidade do produto: ");
        return scanner.nextInt();
    }
}
