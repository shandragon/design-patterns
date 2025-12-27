package br.edu.cerqueira.adailton.design.strategy;

import java.util.HashMap;

public class Strategies {
    public static int ADICAO = 1;
    public static int SUBTRACAO = 2;
    public static int MULTIPLICACAO = 3;
    public static int DIVISAO = 4;

    private HashMap<Integer, String> strategies;

    public Strategies() {
        strategies = new HashMap<>();
        strategies.put(Strategies.ADICAO, "AdicaoStrategy");
        strategies.put(Strategies.SUBTRACAO, "SubtracaoStrategy");
        strategies.put(Strategies.MULTIPLICACAO, "MultiplicacaoStrategy");
        strategies.put(Strategies.DIVISAO, "DivisaoStrategy");
    }

    public OperacaoStrategy getStrategy(int key) {
        String nome = this.strategies.get(key);
        try {
            Class<?> classe = Class.forName("br.edu.cerqueira.adailton.design.strategy." + nome);
            return (OperacaoStrategy) classe.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException e) {
            System.err.println("Erro: A classe " + nome + " não foi encontrada.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
