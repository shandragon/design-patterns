package br.edu.cerqueira.adailton.exception;

public class CalculadoraException extends Exception {
    public static int DIVISAO_POR_ZERO = 1;
    public static int OPERACAO_INVALIDA = 2;

    private int code;

    public CalculadoraException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
