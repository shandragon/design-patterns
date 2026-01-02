package br.edu.cerqueira.adailton.exception;

public class EstoqueException extends Exception {
    public static int ESTOQUE_NEGATIVO = 1;
    public static int PRODUTO_NAO_ENCONTRADO = 2;

    private final int code;

    public EstoqueException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
