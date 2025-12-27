package br.edu.cerqueira.adailton.util;

public enum MenuOpcao {
    STRATEGY(1, "Strategy"),
    SAIR(2, "Sair");

    private final int codigo;
    private final String descricao;

    MenuOpcao(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean equals(int codigo) {
        return this.codigo == codigo;
    }

    public static MenuOpcao fromCodigo(int codigo) {
        for (MenuOpcao opcao : values()) {
            if (opcao.getCodigo() == codigo) {
                return opcao;
            }
        }
        return null;
    }
}
