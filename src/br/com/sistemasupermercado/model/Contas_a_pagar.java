package br.com.sistemasupermercado.model;

public class Contas_a_pagar {

    private Integer id;
    private double valor;
    private String descricao;
    private boolean status;
    private Caixa caixa_id;
    private Fornecedor fornecedor_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Caixa getCaixa_id() {
        return caixa_id;
    }

    public void setCaixa_id(Caixa caixa_id) {
        this.caixa_id = caixa_id;
    }

    public Fornecedor getFornecedor_id() {
        return fornecedor_id;
    }

    public void setFornecedor_id(Fornecedor fornecedor_id) {
        this.fornecedor_id = fornecedor_id;
    }
}
