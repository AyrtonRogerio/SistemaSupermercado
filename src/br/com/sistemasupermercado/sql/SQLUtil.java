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
        													+ MARCA + "," + 
        													DESCRICAO + ") values (?,?,?)";
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
                + COL_CEP + "," + COL_NUMERO + "," + COL_BAIRRO + "," + COL_CIDADE + "," + COL_ESTADO + ""
                + " ) values (?,?,?,?,?,?) returning id";
        
        //public static final String SELECT = " select * from " + NOME_TABELA + " where id = ?";
    }

    public static class Contato {

        public static final String NOME_TABELA = "contato";
        public static final String COL_TIPO = "tipo";
        public static final String COL_DESCRICAO = "descricao";
        public static final String COL_CLIENTE_ID = "cliente_id";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_TIPO + ","
                + COL_DESCRICAO + ","
                + COL_CLIENTE_ID + " ) values (?,?,?)";
    }

    public static class Cliente {

        public static final String NOME_TABELA = "cliente";
        public static final String COL_NOME = "nome";
        public static final String COL_CPF = "cpf";
        public static final String COL_ENDERECO_ID = "endereco_id";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_NOME + ","
                + COL_CPF + ","
                + COL_ENDERECO_ID + " ) values (?,?,?) returning id";
    }

    public static class Funcionario {

        public static final String NOME_TABELA = "funcionario";
        public static final String COL_NOME = "nome";
        public static final String COL_CPF = "cpf";
        public static final String COL_CARGO = "cargo";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" 
        						+ COL_NOME + "," + COL_CPF + "," + COL_CARGO
        						+ " ) values (?,?,?) returning id";
        
        public static final String UPDATE = "update funcionario set nome = ?, cpf = ?,cargo = ? where funcionario.id";
        			
    }
    
    public static class Caixa {
    	
    	public static final String NOME_TABELA = "caixa";
    	public static final String COL_ENTRADA = "entrada";
    	public static final String COL_SAIDA = "saida";
    	public static final String COL_SALDO = "saldo";
    	
    	public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_ENTRADA + ","
    										+ COL_SAIDA + "," + COL_SALDO + " ) values (?,?,?) ";
    	
    }

    public static class Pagamento {

        public static final String NOME_TABELA = "pagamento";
        public static final String COL_FORMA_PAGAMENTO = "forma_pagamento";
        public static final String COL_VALOR = "valor";
        public static final String COL_TROCO = "troco";
        public static final String COL_DESCONTO = "desconto";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_FORMA_PAGAMENTO + "," + COL_VALOR + ","
                + COL_TROCO + "," + COL_DESCONTO + " ) values (?,?,?,?) ";

    }

    public static class Fornecedor {

        public static final String NOME_TABELA = "fornecedor";
        public static final String COL_NOME = "nome";
        public static final String COL_RAZAO_SOCIAL = "razao_social";
        public static final String COL_CNPJ = "cnpj";
        public static final String COL_ESTADO = "estado";
        public static final String COL_CIDADE = "cidade";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_NOME + "," + COL_RAZAO_SOCIAL + ","
                + COL_CNPJ + "," + COL_ESTADO + "," + COL_CIDADE + " ) values (?,?,?,?,?) ";

    }

    public static String selectAll(String nomeTabela) {
        return "select * from " + nomeTabela;
    }

    public static String selectById(String nomeTabela, int id) {
        return "select * from " + nomeTabela + " where id = " + id;
    }

}
