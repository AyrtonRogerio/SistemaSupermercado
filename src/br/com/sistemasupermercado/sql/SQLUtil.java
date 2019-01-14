/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemasupermercado.sql;

import jdk.internal.dynalink.beans.StaticClass;

public class SQLUtil {

	/*
	 * itemProduto é o estoque
	*/
    public static class Produto {

        public static final String NOME_TABELA = "produto";
        public static final String NOME_PRODUTO = "nome";
        public static final String MARCA = "marca";
        public static final String DESCRICAO = "descricao";
        public static final String INSERT = "insert into " + NOME_TABELA + "(" + NOME_PRODUTO + ","
        + MARCA + "," + DESCRICAO + ") values (?,?,?) returning id";

        public static final String UPDATE = "update produto set nome = ?, marca = ?, descricao = ?";

    }

    public static class Item_Produto {
    	
    	public static final String NOME_TABELA = "item_produto";
    	public static final String COL_COD_BARRAS = "cod_barras";
    	public static final String COL_UNIADE_MEDIDA = "unidade_medida";
    	public static final String COL_DATA_FABRICACAO = "data_fabricacao";
    	public static final String COL_DATA_VALIDADE = "data_validade";
    	public static final String COL_DATA_COMPRA = "data_compra";
    	public static final String COL_PRECO_UNIDADE = "preco_unidade";
    	public static final String COL_PORC_ATACADO = "porc_atacado";
    	public static final String COL_PORC_VAREJO = "porc_varejo";
        public static final String COL_QUANTIDADE = "quantidade";
        public static final String COL_VENDIDOS = "vendidos";
        public static final String COL_PERECIVEL = "perecivel";
        public static final String COL_STATUS = "status";
    	public static final String COL_FORNECEDOR_ID = "fornecedor_id";
    	public static final String COL_PRODUTO_ID = "produto_id";




        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_COD_BARRAS + "," + COL_UNIADE_MEDIDA + ","  +
                COL_DATA_FABRICACAO + "," + COL_DATA_VALIDADE + "," + COL_DATA_COMPRA + "," + COL_PRECO_UNIDADE + ","
                + COL_PORC_ATACADO + "," + COL_PORC_VAREJO + "," + COL_QUANTIDADE + "," + COL_VENDIDOS + "," + COL_PERECIVEL + "," +
                COL_STATUS + "," + COL_FORNECEDOR_ID + "," + COL_PRODUTO_ID + ") values (?,?,?,?,?,?,?,?,?,?,?,?,?,?) returning id";

        public static final String SELECT_PRODUTO_ALL = "select p.descricao, p.marca, i.cod_barras, " +
                "i.porc_varejo, i.quantidade, i.data_compra, i.status from item_produto i inner join produto p " +
                "on i.produto_id = p.id and i.status = true and i.vendidos < i.quantidade";

        public static final String SELECT_PROD_LIST_EST_ALL = "select i.id, i.cod_barras, " +
                "i.quantidade, i.porc_varejo, p.descricao from item_produto i inner join produto p " +
                "on i.produto_id = p.id and i.status = true and i.vendidos < i.quantidade";

        public static final String SELECT_PROD_LIST_VEND = "select i.id, i.cod_barras, " +
                "i.quantidade, i.porc_varejo, p.descricao from item_produto i inner join produto p on i.produto_id = p.id " +
                "where i.id = ? and i.status = true and i.vendidos < i.quantidade";

        public static  final String UPDATE = "update item_produto set perecivel = ?, status = ?, quantidade = ?, cod_barras = ?, " +
                "unidade_medida = ?, data_fabricacao = ?, data_validade = ?, data_compra = ?, preco_unidade = ?," +
                "porc_atacado = ?, porc_varejo = ?";

        public static final String SELECT_VENDIDOS = "select i.vendidos from item_produto i " +
                "where id = ? and i.status = true and i.vendidos < i.quantidade";

        public static final String UPDATE_VENDIDOS = "update item_produto set vendidos = ?";
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

        public static final String UPDATE = "update endereco set rua = ?, cep = ?, numero = ?, bairro = ?, cidade = ?, estado = ?";
    }

    public static class Contato {

        public static final String NOME_TABELA = "contato";
        public static final String COL_TIPO = "tipo";
        public static final String COL_DESCRICAO = "descricao";
        public static final String COL_CLIENTE_ID = "cliente_id";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_TIPO + ","
        + COL_DESCRICAO + "," + COL_CLIENTE_ID + " ) values (?,?,?)";

        public static  final  String UPDATE = "update contato set tipo = ?, descricao = ?";
    }

    public static class Cliente {

        public static final String NOME_TABELA = "cliente";
        public static final String COL_NOME = "nome";
        public static final String COL_CPF = "cpf";
        public static final String COL_SEXO = "sexo";
        public static final String COL_ESTADO_CIVIL = "estado_civil";
        public static final String COL_OCUPACAO = "ocupacao";
        public static final String COL_DATA_NASCIMENTO = "data_nascimento";
        public static final String COL_ENDERECO_ID = "endereco_id";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_NOME + ","
        + COL_CPF + "," + COL_SEXO + "," + COL_ESTADO_CIVIL + "," +
        COL_OCUPACAO + "," + COL_DATA_NASCIMENTO + "," +
        COL_ENDERECO_ID + " ) values (?,?,?,?,?,?,?) returning id";

        public static final String SELECT_CPF = "select c. id, c.nome, c.cpf, c.data_nascimento, " +
                "e.rua, e.bairro, e.numero, f.tipo, f.descricao from cliente c inner join endereco e " +
                "on c.endereco_id = e.id inner join contato f on f.cliente_id = c.id where c.cpf = ?";

        public static final String SELECT_ALL_ADAPTER = "select c. id, c.nome, c.cpf, c.data_nascimento, " +
                "e.rua, e.bairro, e.numero, f.tipo, f.descricao from cliente c inner join endereco e " +
                "on c.endereco_id = e.id inner join contato f on f.cliente_id = c.id";

        public static  final  String UPDATE = "update cliente set nome = ?, cpf = ?, sexo = ?, estado_civil = ?," +
                "ocupacao = ?, data_nascimento = ?";

    }

    public static class Funcionario {

        public static final String NOME_TABELA = "funcionario";
        public static final String COL_NOME = "nome";
        public static final String COL_CPF = "cpf";
        public static final String COL_CARGO = "cargo";
        public static final String COL_LOGIN = "login";
        public static final String COL_SENHA = "senha";
        

        public static final String INSERT = "insert into " + NOME_TABELA + "(" 
        + COL_NOME + "," + COL_CPF + "," + COL_CARGO + "," + COL_LOGIN + "," + 
        COL_SENHA + " ) values (?,?,?,?,?) returning id";
        
        public static final String UPDATE = "update funcionario set nome = ?, cpf = ?,cargo = ?, login = ?, senha = ?";
        	
        public static final String SELECT_LOGIN = "select * from funcionario where login = ?  and senha = ?";


    }
    
    public static class Caixa {
    	
    	public static final String NOME_TABELA = "caixa";
    	public static final String COL_ENTRADA = "entrada";
    	public static final String COL_SAIDA = "saida";
    	public static final String COL_SALDO = "saldo";
    	public static final String COL_FUNCIONARIO = "funcionario_id";
    	public static final String COL_DATA_ABERTURA = "data_abertura";
        public static final String COL_DATA_FECHAMENTO = "data_fechamento";
    	
    	public static final String INSERT = "insert into " + NOME_TABELA + "(" 
    	+ COL_ENTRADA + ","	+ COL_SAIDA + "," + COL_SALDO + "," + COL_FUNCIONARIO + ","
                + COL_DATA_ABERTURA + "," + COL_DATA_FECHAMENTO + " ) values (?,?,?,?,?,?) ";

    	public static final String SELECT_DATA = "select * from caixa where data_abertura = ?";

    	public static final String SELECT_ANTERIOR = "select * from caixa where id = (select max(id) from caixa)";

    	public static final String UPDATE = "update caixa set entrada = ?, saida = ?, saldo = ?";
        public static final String UPDATE_DATA = "update caixa set entrada = ?, saldo = ?";
    	
    }

    public static class Pagamento {

        public static final String NOME_TABELA = "pagamento";

        public static final String COL_VALOR = "valor";
        public static final String COL_DATA_VENCIMENTO = "data_vencimento";
        public static final String COL_NUMERO = "numero";
        public static final String COL_FORMA_PAGAMENTO = "forma_pagamento";
        public static final String COL_CLIENTE_ID = "cliente_id";
        public static final String COL_VENDA_ID = "venda_id";
        public static final String COL_STATUS = "status";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" 
        + COL_VALOR + "," + COL_DATA_VENCIMENTO + "," + COL_NUMERO + "," + COL_FORMA_PAGAMENTO +
        "," + COL_CLIENTE_ID + "," + COL_VENDA_ID + "," + COL_STATUS +" ) values (?,?,?,?,?,?,?) returning id";

        public static final String UPDATE = "update pagamento set valor = ?, data_vencimento = ?, numero = ?," +
                "forma_pagamento = ?, status = ?";

    }

    public static class Fornecedor {

        public static final String NOME_TABELA = "fornecedor";
        public static final String COL_NOME = "nome_fantasia";
        public static final String COL_RAZAO_SOCIAL = "razao_social";
        public static final String COL_CNPJ = "cnpj";
        public static final String COL_ESTADO = "estado";
        public static final String COL_CIDADE = "cidade";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" + COL_NOME + 
        "," + COL_RAZAO_SOCIAL + "," + COL_CNPJ + "," + COL_ESTADO + ","
        + COL_CIDADE + " ) values (?,?,?,?,?) returning id ";

        public static final String SELECT_NOME = "select * from fornecedor where nome_fantasia = ?";

        public static  final String UPDATE = "update fornecedor set nome_fantasia = ?, razao_social = ?, cnpj = ?," +
                "estado = ?, cidade = ?";

    }
    
    public static class Venda {
    	
    	
    	public static final String NOME_TABELA = "venda";
        public static final String COL_VALOR_TOTAL = "valor_total";
    	public static final String COL_DESC_GERAL = "desc_geral";
        public static final String COL_VALOR_TROCO = "valor_troco";
        public static final String COL_VALOR_RECEBIDO = "valor_recebido";
    	public static final String COL_DATA_VENDA = "data_venda";
    	public static final String COL_CLIENTE_ID = "cliente_id";
    	public static final String COL_FUNCIONARIO_ID = "funcionario_id";
    	public static final String COL_CAIXA_ID = "caixa_id";
    	
    	public static final String INSERT = "insert into " + NOME_TABELA +
        "(" + COL_VALOR_TOTAL + "," + COL_DESC_GERAL + "," + COL_VALOR_TROCO +
                "," + COL_VALOR_RECEBIDO + "," + COL_DATA_VENDA + "," +  COL_CLIENTE_ID +
                "," + COL_FUNCIONARIO_ID + "," + COL_CAIXA_ID +
         " ) values (?,?,?,?,?,?,?,?) returning id";

    	public static final String SELECT_VENDA = "select v.valor_total, v.desc_geral, v.valor_troco, v.valor_recebido" +
                " from venda v where id = ?";

        public static final String UPDATE_VENDA = "update venda set valor_total = ?, desc_geral = ?," +
                "valor_troco = ?, valor_recebido = ?";

    	public static final String UPDATE_VENDA_CLI_ID = "update venda set cliente_id = ?";
    	
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

    	public static final String UPDATE = "update item_venda set valor_desc = ?, porc_promoc = ?, promocao = ?, tipo = ?," +
                "quant = ?, valor_item = ?, desconto = ?";
    }


    public static class Contas_a_Receber{


        public static final String NOME_TABELA = "contas_a_receber";
        public static final String COL_DESCRICAO = "descricao";
        public static final String COL_VALOR = "valor";
        public static final String COL_VALOR_QUITADO = "valor_quitado";
        public static final String COL_QTD_PGMT = "qtd_pgmt";
        public static final String COL_QTD_PAGA = "qtd_paga";
        public static final String COL_SALDO = "saldo";
        public static final String COL_CAIXA_ID = "caixa_id";
        public static final String COL_VENDA_ID = "venda_id";
        public static final String COL_STATUS = "status";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" +
                COL_DESCRICAO + "," + COL_VALOR + "," + COL_VALOR_QUITADO + "," +
                COL_QTD_PGMT + "," + COL_QTD_PAGA + "," + COL_SALDO + "," + COL_CAIXA_ID + "," +
                COL_VENDA_ID + "," + COL_STATUS + ") values (?,?,?,?,?,?,?,?,?) returning id";
        
        public static final String SELECT_ALL_ADAPTER = "select c.id, c.descricao, c.valor, c.valor_quitado,"
        		+ "c.qtd_pgmt, c.qtd_paga from contas_a_receber c ";
        
        public static final String SELECT_A_RECEB_ADAPTER = "select c.id, c.descricao, c.valor, c.valor_quitado,"
        		+ "c.qtd_pgmt, c.qtd_paga from contas_a_receber c where c.status = true";
        
        public static final String SELECT_RECEBIDA_ADAPTER = "select c.id, c.descricao, c.valor, c.valor_quitado,"
        		+ "c.qtd_pgmt, c.qtd_paga from contas_a_receber c where c.status = false";

        public static final String UPDATE = " update contas_a_receber set descricao = ?, valor = ?, qtd_pgmt = ?, valor_quitado = ?," +
                "saldo = ?, status = ?";

    }

    public static  class Contas_a_Pagar{

        public static final String NOME_TABELA = "contas_a_pagar";
        public static final String COL_DESCRICAO = "descricao";
        public static final String COL_VALOR = "valor";
        public static final String COL_VALOR_QUITADO = "valor_quitado";
        public static final String COL_QTD_PGMT = "qtd_pgmt";
        public static final String COL_QTD_PAGA = "qtd_paga";
        public static final String COL_DATA_VENC = "data_vencimento";
        public static final String COL_CAIXA_ID = "caixa_id";
        public static final String COL_FORNEC_ID = "fornecedor_id";
        public static final String COL_STATUS = "status";

        public static final String INSERT = "insert into " + NOME_TABELA + "(" +
                COL_DESCRICAO + "," + COL_VALOR + "," + COL_VALOR_QUITADO + "," + COL_QTD_PGMT + "," +
                COL_QTD_PAGA + "," + COL_DATA_VENC + "," + COL_CAIXA_ID + "," +
                COL_FORNEC_ID + "," + COL_STATUS + ") values (?,?,?,?,?,?,?,?,?) returning id";

        public static final String SELECT_ALL_ADAPTER = "select c.id, c.descricao, c.valor, c.valor_quitado,"
        		+ "c.qtd_pgmt, c.qtd_paga, c.data_vencimento from contas_a_pagar c ";
        
        public static final String SELECT_A_PAG_ADAPTER = "select c.id, c.descricao, c.valor, c.valor_quitado,"
        		+ "c.qtd_pgmt, c.qtd_paga, c.data_vencimento from contas_a_pagar c where c.status = true";
        
        public static final String SELECT_PAGA_ADAPTER = "select c.id, c.descricao, c.valor, c.valor_quitado,"
        		+ "c.qtd_pgmt, c.qtd_paga, c.data_vencimento from contas_a_pagar c where c.status = false";
        
        public static final String UPDATE = " update contas_a_receber set valor = ?, descricao = ?, fornecedor_id = ?, status = ?";
    }

    public static String selectAll(String nomeTabela) {
        return "select * from " + nomeTabela;
    }

    public static String selectById(String nomeTabela, int id) {
        return "select * from " + nomeTabela + " where id = " + id;
    }

}
