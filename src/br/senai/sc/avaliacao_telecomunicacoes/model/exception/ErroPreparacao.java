package br.senai.sc.avaliacao_telecomunicacoes.model.exception;

/**
 * Exceção Checada que é emitida quando há problema na criação de um PreparedStatement. Muitas vezes advinda de um dado
 * incorreto que será implementado na requisição ao banco.
 */
public class ErroPreparacao extends Exception {

    public ErroPreparacao() {
        super("Houve um erro na preparação do comando SQL!");
    }
}
