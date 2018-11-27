package br.com.sistemasupermercado.enuns;

public enum TipoDocumento {
    RG("RG"),
    CPF("CPF");
    private String descricao;

    private TipoDocumento(String descricao) {
        this.descricao = descricao;
    }

    public String getValor() {
        return this.descricao;
    }

}
