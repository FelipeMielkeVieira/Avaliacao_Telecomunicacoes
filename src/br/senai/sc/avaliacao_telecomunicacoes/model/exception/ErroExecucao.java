package br.senai.sc.avaliacao_telecomunicacoes.model.exception;

public class ErroExecucao extends Exception {

    public ErroExecucao() {
        super("Houve um erro na execução do comando SQL!");
    }
}
