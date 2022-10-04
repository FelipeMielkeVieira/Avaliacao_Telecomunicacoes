package br.senai.sc.avaliacao_telecomunicacoes.model.entities;

/**
 * Classe ENUM usada para definição da Operadora de um Plano, necessária para sua criação.
 */
public enum Operadora {

    CLARO("CLARO"), VIVO("VIVO"), TIM("TIM"), OI("OI");

    String nome;

    Operadora(String nome) {
        this.nome = nome;
    }
}
