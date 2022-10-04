package br.senai.sc.avaliacao_telecomunicacoes.model.exception;

/**
 * Exceção Checada que é emitida quando um ResultSet advindo do banco de dados é transformado incorretamente em um
 * objeto, podendo ser um problema na própria função de extração ou até podendo chegar na Factory da classe em questão.
 */
public class ErroTratamento extends Exception {

    public ErroTratamento() {
        super("Houve um erro na extração do objeto!");
    }
}
