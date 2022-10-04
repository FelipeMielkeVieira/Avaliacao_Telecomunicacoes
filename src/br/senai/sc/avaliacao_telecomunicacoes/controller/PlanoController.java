package br.senai.sc.avaliacao_telecomunicacoes.controller;

import br.senai.sc.avaliacao_telecomunicacoes.model.entities.Operadora;
import br.senai.sc.avaliacao_telecomunicacoes.model.entities.Plano;
import br.senai.sc.avaliacao_telecomunicacoes.model.service.PlanoService;

import java.util.Collection;

/**
 * Classe usada para integrar a view com o service, realizando todas as ações necessárias para que as funções da view
 * sejam redirecionadas para a service, que fará toda a conexão com o banco de dados. As mesmas funções presentes no
 * PlanoDAO e PlanoService são transmitidas para essa classe.
 */
public class PlanoController {

    public void cadastrarPlano(String nomePlano, String beneficiosPlano, Double qtdDadosPlano, Double qtdDadosBonusPlano, Double valorPlano, Operadora operadoraPlano) {
        Plano plano = Plano.cadastrar(nomePlano, beneficiosPlano, qtdDadosPlano, qtdDadosBonusPlano, valorPlano, operadoraPlano);
        PlanoService service = new PlanoService();
        service.cadastrarPlano(plano);
    }

    public void removerPlano(Integer idPlano) {
        PlanoService service = new PlanoService();
        service.removerPlano(idPlano);
    }

    public void atualizarPlano(Integer idPlano, String nomePlano, String beneficiosPlano, Double qtdDadosPlano, Double qtdDadosBonusPlano, Double valorPlano, Operadora operadoraPlano) {
        Plano plano = Plano.cadastrar(nomePlano, beneficiosPlano, qtdDadosPlano, qtdDadosBonusPlano, valorPlano, operadoraPlano);
        PlanoService service = new PlanoService();
        service.atualizarPlano(idPlano, plano);
    }

    public Collection<Plano> buscarTodos() {
        PlanoService service = new PlanoService();
        return service.selecionarTodos();
    }

    public Collection<Plano> buscarPorOperadora(Operadora operadora) {
        PlanoService service = new PlanoService();
        return service.selecionarPorOperadora(operadora);
    }

    public Plano buscarPlano(Integer idPlano) {
        PlanoService service = new PlanoService();
        return service.selecionarPlano(idPlano);
    }
}
