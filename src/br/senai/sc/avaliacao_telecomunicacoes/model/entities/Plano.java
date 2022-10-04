package br.senai.sc.avaliacao_telecomunicacoes.model.entities;

import br.senai.sc.avaliacao_telecomunicacoes.model.factory.PlanoFactory;

/**
 * Classe que representa um Plano de Operadoras de Telecomunicação, com seus atributos necessários (ID, nome,
 * benefícios, quantidade de dados, dados bônus, valor e operadora).
 * Usada para maior parte das transações no sistema e transformada em instâncias na tabela "plano" no banco de dados.
 */
public class Plano {

    private Integer idPlano;
    private String nomePlano, beneficiosPlano;
    private Double qtdDadosPlano, qtdDadosBonusPlano, valorPlano;
    private Operadora operadoraPlano;

    public Plano(Integer idPlano, String nomePlano, String beneficiosPlano, Double qtdDadosPlano, Double qtdDadosBonusPlano, Double valorPlano, Operadora operadoraPlano) {
        this.idPlano = idPlano;
        this.nomePlano = nomePlano;
        this.beneficiosPlano = beneficiosPlano;
        this.qtdDadosPlano = qtdDadosPlano;
        this.qtdDadosBonusPlano = qtdDadosBonusPlano;
        this.valorPlano = valorPlano;
        this.operadoraPlano = operadoraPlano;
    }

    public Plano(Integer idPlano, String nomePlano, String beneficiosPlano, Double qtdDadosPlano, Double valorPlano, Operadora operadoraPlano) {
        this.idPlano = idPlano;
        this.nomePlano = nomePlano;
        this.beneficiosPlano = beneficiosPlano;
        this.qtdDadosPlano = qtdDadosPlano;
        this.valorPlano = valorPlano;
        this.operadoraPlano = operadoraPlano;
    }

    public Plano(Integer idPlano, String nomePlano, Double qtdDadosPlano, Double valorPlano, Operadora operadoraPlano) {
        this.idPlano = idPlano;
        this.nomePlano = nomePlano;
        this.qtdDadosPlano = qtdDadosPlano;
        this.valorPlano = valorPlano;
        this.operadoraPlano = operadoraPlano;
    }

    public Plano(String nomePlano, String beneficiosPlano, Double qtdDadosPlano, Double qtdDadosBonusPlano, Double valorPlano, Operadora operadoraPlano) {
        this.nomePlano = nomePlano;
        this.beneficiosPlano = beneficiosPlano;
        this.qtdDadosPlano = qtdDadosPlano;
        this.qtdDadosBonusPlano = qtdDadosBonusPlano;
        this.valorPlano = valorPlano;
        this.operadoraPlano = operadoraPlano;
    }

    public Plano(String nomePlano, String beneficiosPlano, Double qtdDadosPlano, Double valorPlano, Operadora operadoraPlano) {
        this.nomePlano = nomePlano;
        this.beneficiosPlano = beneficiosPlano;
        this.qtdDadosPlano = qtdDadosPlano;
        this.valorPlano = valorPlano;
        this.operadoraPlano = operadoraPlano;
    }

    @Override
    public String toString() {
        return "ID do Plano: " + this.getIdPlano() +
                "\nNome do Plano: " + this.getNomePlano() +
                "\nQuantidade de Dados: " + this.getQtdDadosPlano() +
                "\nQuantidade de Dados Bônus: " + this.getQtdDadosBonusPlano() +
                "\nBenefícios do Plano: " + this.getBeneficiosPlano() +
                "\nOperadora do Plano: " + this.getOperadoraPlano().toString() +
                "\nValor do Plano: " + this.getValorPlano();
    }

    public static Plano cadastrar(String nomePlano, String beneficiosPlano, Double qtdDadosPlano, Double qtdDadosBonusPlano, Double valorPlano, Operadora operadoraPlano) {
        return new PlanoFactory().getPlano(null, nomePlano, beneficiosPlano, qtdDadosPlano, qtdDadosBonusPlano, valorPlano, operadoraPlano.toString());
    }

    public Integer getIdPlano() {
        return idPlano;
    }

    public String getNomePlano() {
        return nomePlano;
    }

    public String getBeneficiosPlano() {
        return beneficiosPlano;
    }

    public Double getQtdDadosPlano() {
        return qtdDadosPlano;
    }

    public Double getQtdDadosBonusPlano() {
        return qtdDadosBonusPlano;
    }

    public Double getValorPlano() {
        return valorPlano;
    }

    public Operadora getOperadoraPlano() {
        return operadoraPlano;
    }
}
