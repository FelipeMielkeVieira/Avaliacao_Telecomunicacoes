package br.senai.sc.avaliacao_telecomunicacoes.model.exception;

public class ErroPreparacao extends Exception {

    public ErroPreparacao() {
        super("Houve um erro na preparação do comando SQL!");
    }
}
