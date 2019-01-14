package br.com.sistemasupermercado.model;

public class Contas_a_receber {

    private Integer id;
    private double valor;
    private double valor_quitado;
    private double saldo;
    private String descricao;
    private boolean status;
    private Caixa caixa_id;
    private int qtd_pgmt;
    private int qtd_paga;
    private Venda venda_id;

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

    public Venda getVenda_id() {
        return venda_id;
    }

    public void setVenda_id(Venda venda_id) {
        this.venda_id = venda_id;
    }

    public double getValor_quitado() {
        return valor_quitado;
    }

    public void setValor_quitado(double valor_quitado) {
        this.valor_quitado = valor_quitado;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
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
