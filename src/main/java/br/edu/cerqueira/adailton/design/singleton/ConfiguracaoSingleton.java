package br.edu.cerqueira.adailton.design.singleton;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConfiguracaoSingleton {
    private static ConfiguracaoSingleton instance;

    private String titulo;
    private LocalDateTime criado_em;
    private String valor;

    private ConfiguracaoSingleton(String titulo) {
        System.out.println("Criação de um novo objeto!");
        this.titulo = titulo;
        this.criado_em = LocalDateTime.now();
        this.valor = "";
    }

    public static ConfiguracaoSingleton getInstance(String titulo) {
        System.out.println("Buscando a instância.");
        if (instance == null) {
            instance = new ConfiguracaoSingleton(titulo);
        }
        return instance;
    }

    public static ConfiguracaoSingleton getInstance() {
        return ConfiguracaoSingleton.getInstance("");
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void imprimir() {
        System.out.println("Título: " + this.titulo);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println("Criado em: " + this.criado_em.format(formato));
        System.out.println("Valor: " + this.valor);
    }
}
