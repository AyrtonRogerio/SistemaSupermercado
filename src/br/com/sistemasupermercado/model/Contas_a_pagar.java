package br.com.sistemasupermercado.model;

import java.util.Date;

public class Contas_a_pagar {

    private Integer id;
    private double valor;
    private double valor_quitado;
    private Date data_vencimento;
    private int qtd_pgmt;
    private int qtd_paga;
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

    public double getValor_quitado() {
        return valor_quitado;
    }

    public void setValor_quitado(double valor_quitado) {
        this.valor_quitado = valor_quitado;
    }

    public Date getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(Date data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public int getQtd_pgmt() {
        return qtd_pgmt;
    }

    public void setQtd_pgmt(int qtd_pgmt) {
        this.qtd_pgmt = qtd_pgmt;
    }

    public int getQtd_paga() {
        return qtd_paga;
    }

    public void setQtd_paga(int qtd_paga) {
        this.qtd_paga = qtd_paga;
    }
}
