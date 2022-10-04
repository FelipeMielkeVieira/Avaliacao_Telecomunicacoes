package br.senai.sc.avaliacao_telecomunicacoes.model.exception;

/**
 * Exceção Checada que é emitida quando a conexão ao banco de dados SQL falha, com o sistema não conseguindo usar os
 * parâmetros definidos (url, user e password) para a conexão, ou havendo algum problema interno (como nas bibliotecas).
 */
public class ErroConexao extends Exception {

    public ErroConexao() {
        super("Erro na conexão com o Banco!");
    }
}
