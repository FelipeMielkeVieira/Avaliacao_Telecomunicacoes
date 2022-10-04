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
        return "Plano{" +
                "idPlano=" + idPlano +
                ", nomePlano='" + nomePlano + '\'' +
                ", beneficiosPlano='" + beneficiosPlano + '\'' +
                ", qtdDadosPlano=" + qtdDadosPlano +
                ", qtdDadosBonusPlano=" + qtdDadosBonusPlano +
                ", valorPlano=" + valorPlano +
                ", operadoraPlano=" + operadoraPlano +
                '}';
    }

    public static Plano cadastrar(String nomePlano, String beneficiosPlano, Double qtdDadosPlano, Double qtdDadosBonusPlano, Double valorPlano, Operadora operadoraPlano) {
        return new PlanoFactory().getPlano(null, nomePlano, beneficiosPlano, qtdDadosPlano, qtdDadosBonusPlano, valorPlano, operadoraPlano.toString());
    }

    public Integer getIdPlano() {
        return idPlano;
    }

    public void setIdPlano(Integer idPlano) {
        this.idPlano = idPlano;
    }

    public String getNomePlano() {
        return nomePlano;
    }

    public void setNomePlano(String nomePlano) {
        this.nomePlano = nomePlano;
    }

    public String getBeneficiosPlano() {
        return beneficiosPlano;
    }

    public void setBeneficiosPlano(String beneficiosPlano) {
        this.beneficiosPlano = beneficiosPlano;
    }

    public Double getQtdDadosPlano() {
        return qtdDadosPlano;
    }

    public void setQtdDadosPlano(Double qtdDadosPlano) {
        this.qtdDadosPlano = qtdDadosPlano;
    }

    public Double getQtdDadosBonusPlano() {
        return qtdDadosBonusPlano;
    }

    public void setQtdDadosBonusPlano(Double qtdDadosBonusPlano) {
        this.qtdDadosBonusPlano = qtdDadosBonusPlano;
    }

    public Double getValorPlano() {
        return valorPlano;
    }

    public void setValorPlano(Double valorPlano) {
        this.valorPlano = valorPlano;
    }

    public Operadora getOperadoraPlano() {
        return operadoraPlano;
    }

    public void setOperadoraPlano(Operadora operadoraPlano) {
        this.operadoraPlano = operadoraPlano;
    }
}
