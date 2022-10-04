package br.senai.sc.avaliacao_telecomunicacoes.model.exception;

public class ErroConexao extends Exception {

    public ErroConexao() {
        super("Erro na conexão com o Banco!");
    }
}
