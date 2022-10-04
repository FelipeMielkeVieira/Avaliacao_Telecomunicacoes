package br.senai.sc.avaliacao_telecomunicacoes.model.exception;

/**
 * Exceção Checada que é emitida quando o sistema falha ao consultar o banco de dados MySQL, seja em qualquer mudança
 * feita nele. Os problemas no geral ocorrem quando há alguma palavra-chave incorreta ou o código SQL em si está
 * incorreto.
 */
public class ErroExecucao extends Exception {

    public ErroExecucao() {
        super("Houve um erro na execução do comando SQL!");
    }
}
