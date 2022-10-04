package br.senai.sc.avaliacao_telecomunicacoes.model.factory;

import br.senai.sc.avaliacao_telecomunicacoes.model.entities.Operadora;
import br.senai.sc.avaliacao_telecomunicacoes.model.entities.Plano;

/**
 * Classe usada para criar uma nova instância da Classe Plano.
 * Dependendo dos parâmetros recebidos, ela criará um Plano através de um dos seus diferentes construtores, pois alguns
 * dos dados acabam não sendo necessários em determinado processo do sistema.
 */
public class PlanoFactory {

    public Plano getPlano(Integer idPlano, String nomePlano, String beneficiosPlano, Double qtdDadosPlano, Double qtdDadosBonusPlano, Double valorPlano, String operadoraPlano) {
        if(idPlano != null) {
            if(beneficiosPlano != null) {
                if(qtdDadosBonusPlano != null) {
                    return new Plano(idPlano, nomePlano, beneficiosPlano, qtdDadosPlano, qtdDadosBonusPlano, valorPlano, Operadora.valueOf(operadoraPlano));
                } else {
                    return new Plano(idPlano, nomePlano, beneficiosPlano, qtdDadosPlano, valorPlano, Operadora.valueOf(operadoraPlano));
                }
            } else {
                return new Plano(idPlano, nomePlano, qtdDadosPlano, valorPlano, Operadora.valueOf(operadoraPlano));
            }
        } else {
            if(qtdDadosBonusPlano != null) {
                return new Plano(nomePlano, beneficiosPlano, qtdDadosPlano, qtdDadosBonusPlano, valorPlano, Operadora.valueOf(operadoraPlano));
            } else {
                return new Plano(nomePlano, beneficiosPlano, qtdDadosPlano, valorPlano, Operadora.valueOf(operadoraPlano));
            }
        }
    }
}
