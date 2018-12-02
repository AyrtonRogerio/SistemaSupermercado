/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemasupermercado.sql;

import jdk.internal.dynalink.beans.StaticClass;

public class SQLUtil {

    public static class Produto {

        public static final String NOME_TABELA = "produto";
        public static final String NOME_PRODUTO = "nome";
        public static final String MARCA = "marca";
        public static final String DESCRICAO = "descricao";
        public static final String INSERT = "insert into " + NOME_TABELA + "(" + NOME_PRODUTO + ","
        + MARCA + "," + DESCRICAO + ") values (?,?,?)";
    }

    public static class Item_Produto {
    	
    	public static final String NOME_TABELA = "item_produto";
    	public static final String COL_STATUS = "status";
    	public static final String COL_PORC_VAREJ = "porc_varej";
    	public static final String COL_PROMOCAO = "promocao";
    	public static final String COL_QUANTIDADE = "quantidade";
    	public static final String COL_PORC_ATACAD = "porc_atacad";
    	public static final String COL_COD_BARRAS = "cod_barras";
    	public static final String COL_UNIADE_MEDIDA = "unidade_medida";
    	public static final String COL_DATA_VALIDADE = "data_validade";
    	public static final String COL_DATA_COMPRA = "data_compra";
    	public static final String COL_FORNECEDOR_ID = "fornecedor_id";
    	public static final String COL_PRODUTO_ID = "produto_id";
    	
    	public static final String INSERT = "insert into" + NOME_TABELA + "(" 
    	+ COL_STATUS + "," + COL_PORC_VAREJ	+ "," + COL_PROMOCAO + "," + COL_QUANTIDADE +
    	"," + COL_PORC_ATACAD + "," + COL_COD_BARRAS + "," + COL_UNIADE_MEDIDA + "," + COL_DATA_VALIDADE +
    	"," + COL_DATA_COMPRA + "," + COL_FORNECEDOR_ID + "," + COL_PRODUTO_ID 
    	+ ") values (?,?,?,?,?,?,?,?,?,?,?) returning id";
    	
    }
    
    public static class Endereco {

        public static final String NOME_TABELA = "endereco";
        public static final String COL_RUA = "rua";
        public static final String COL_CEP = "cep";
        public static final String COL_NUMERO = "numero";
        public static final String COL_BAIRRO = "bairro";
        public static final String COL_CIDADE = "cidade";
        public static final String COL_ESTADO = "estado";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_RUA + ","
        + COL_CEP + "," + COL_NUMERO + "," + COL_BAIRRO + "," + COL_CIDADE + "," + COL_ESTADO
        + " ) values (?,?,?,?,?,?) returning id";
        
        //public static final String SELECT = " select * from " + NOME_TABELA + " where id = ?";
    }

    public static class Contato {

        public static final String NOME_TABELA = "contato";
        public static final String COL_TIPO = "tipo";
        public static final String COL_DESCRICAO = "descricao";
        public static final String COL_CLIENTE_ID = "cliente_id";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_TIPO + ","
        + COL_DESCRICAO + "," + COL_CLIENTE_ID + " ) values (?,?,?)";
    }

    public static class Cliente {

        public static final String NOME_TABELA = "cliente";
        public static final String COL_NOME = "nome";
        public static final String COL_CPF = "cpf";
        public static final String COL_ENDERECO_ID = "endereco_id";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_NOME + ","
        + COL_CPF + "," + COL_ENDERECO_ID + " ) values (?,?,?) returning id";
    }

    public static class Funcionario {

        public static final String NOME_TABELA = "funcionario";
        public static final String COL_NOME = "nome";
        public static final String COL_CPF = "cpf";
        public static final String COL_CARGO = "cargo";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" 
        + COL_NOME + "," + COL_CPF + "," + COL_CARGO + " ) values (?,?,?) returning id";
        
        public static final String UPDATE = "update funcionario set nome = ?, cpf = ?,cargo = ? where funcionario.id";
        			
    }
    
    public static class Caixa {
    	
    	public static final String NOME_TABELA = "caixa";
    	public static final String COL_ENTRADA = "entrada";
    	public static final String COL_SAIDA = "saida";
    	public static final String COL_SALDO = "saldo";
    	
    	public static final String INSERT = "insert into " + NOME_TABELA + "(" 
    	+ COL_ENTRADA + ","	+ COL_SAIDA + "," + COL_SALDO + " ) values (?,?,?) ";
    	
    }

    public static class Pagamento {

        public static final String NOME_TABELA = "pagamento";
        public static final String COL_FORMA_PAGAMENTO = "forma_pagamento";
        public static final String COL_VALOR = "valor";
        public static final String COL_TROCO = "troco";
        public static final String COL_DESCONTO = "desconto";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" 
        + COL_FORMA_PAGAMENTO + "," + COL_VALOR + "," + COL_TROCO + "," + COL_DESCONTO +
        " ) values (?,?,?,?) returning id";

    }

    public static class Fornecedor {

        public static final String NOME_TABELA = "fornecedor";
        public static final String COL_NOME = "nome";
        public static final String COL_RAZAO_SOCIAL = "razao_social";
        public static final String COL_CNPJ = "cnpj";
        public static final String COL_ESTADO = "estado";
        public static final String COL_CIDADE = "cidade";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_NOME + 
        "," + COL_RAZAO_SOCIAL + "," + COL_CNPJ + "," + COL_ESTADO + ","
        + COL_CIDADE + " ) values (?,?,?,?,?) returning id ";

    }
    
    public static class Venda {
    	
    	
    	public static final String NOME_TABELA = "venda";
    	public static final String COL_DESC_GERAL = "desc_geral";
    	public static final String COL_QUANT_PARC = "quant_parc";
    	public static final String COL_VALOR_TOTAL = "valor_total";
    	public static final String COL_DATA_VENDA = "data_venda";
    	public static final String COL_PAGAMENTO_ID = "pagamento_id";
    	public static final String COL_CLIENTE_ID = "cliente_id";
    	public static final String COL_FUNCIONARIO_ID = "funcionario_id";
    	
    	public static final String INSERT = "insert into" + NOME_TABELA + "(" + COL_DESC_GERAL + 
    	"," + COL_QUANT_PARC + "," + COL_VALOR_TOTAL + "," + COL_DATA_VENDA + "," + 
    	COL_PAGAMENTO_ID + "," + COL_CLIENTE_ID + "," + COL_FUNCIONARIO_ID +
    	" ) values (?,?,?,?,?,?,?) returning id";
    	
    	
    }
    
    public static class Item_Venda {
    	
    	public static final String NOME_TABELA = "item_venda";
    	public static final String COL_VALOR_DESC = "valor_desc";
    	public static final String COL_PORC_PROMOC = "porc_promoc";
    	public static final String COL_PROMOCAO = "promocao";
    	public static final String COL_TIPO = "tipo";
    	public static final String COL_QUANT = "quant";
    	public static final String COL_VALOR_ITEM = "valor_item";
    	public static final String COL_DESCONTO = "desconto";
    	public static final String COL_VENDA_ID = "venda_id";
    	public static final String COL_ITEM_PRODUTO_ID = "item_produto_id";
    	
    	public static final String INSERT = " insert into " 
    	+ NOME_TABELA + "(" + COL_VALOR_DESC + 	"," + COL_PORC_PROMOC + "," + COL_PROMOCAO +
    	"," + COL_TIPO + "," + COL_QUANT + "," + COL_VALOR_ITEM + "," + COL_DESCONTO + "," +
    	COL_VENDA_ID + "," + COL_ITEM_PRODUTO_ID +
    	" ) values (?,?,?,?,?,?,?,?,?) returning id";
    }
    
    public static class Parcela {
    	
    	public static final String NOME_TABELA = "parcela";
    	public static final String COL_VALOR = "valor";
    	public static final String COL_TIPO = "tipo";
    	public static final String COL_NUMERO = "numero";
    	public static final String COL_DATA_VENCIMENTO = "data_vencimento";
    	public static final String COL_CLIENTE_ID = "cliente_id";
    	public static final String COL_FUNCIONARIO_ID = "funcionario_id";
    	public static final String COL_VENDA_ID = "venda_id";
    	
    	public static final String INSERT = "insert into" + NOME_TABELA + 
    	"(" + COL_VALOR + 	"," + COL_TIPO + "," + COL_NUMERO + "," + COL_DATA_VENCIMENTO 
    	+ "," + COL_CLIENTE_ID + "," + COL_FUNCIONARIO_ID + "," + COL_VENDA_ID + 
    	" ) values (?,?,?,?,?,?,?) returning id";
    	
    }

    public static String selectAll(String nomeTabela) {
        return "select * from " + nomeTabela;
    }

    public static String selectById(String nomeTabela, int id) {
        return "select * from " + nomeTabela + " where id = " + id;
    }

}
