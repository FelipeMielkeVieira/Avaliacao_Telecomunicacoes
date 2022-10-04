package br.senai.sc.avaliacao_telecomunicacoes.model.service;

import br.senai.sc.avaliacao_telecomunicacoes.model.dao.PlanoDAO;
import br.senai.sc.avaliacao_telecomunicacoes.model.entities.Operadora;
import br.senai.sc.avaliacao_telecomunicacoes.model.entities.Plano;

import java.util.Collection;

/**
 * Classe usada como intermediadora entre PlanoController e PlanoDAO.
 * Possui semelhantes funções à PlanoDAO, criando uma nova instância a cada função, além de tratar exceções advindas
 * dos métodos da DAO, transformando-as em RuntimeExceptions.
 */
public class PlanoService {

    public void cadastrarPlano(Plano plano) {
        try {
            new PlanoDAO().cadastrarPlano(plano);
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    public void removerPlano(Integer idPlano) {
        try {
            new PlanoDAO().removerPlano(idPlano);
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    public void atualizarPlano(Integer idPlano, Plano novoPlano) {
        try {
            new PlanoDAO().atualizarPlano(idPlano, novoPlano);
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    public Collection<Plano> selecionarTodos() {
        try {
            return new PlanoDAO().selecionarTodos("OPERADORA");
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    public Collection<Plano> selecionarPorOperadora(Operadora operadora) {
        try {
            return new PlanoDAO().selecionarPorOperadora(operadora);
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    public Plano selecionarPlano(Integer idPlano) {
        try {
            return new PlanoDAO().selecionarPlano(idPlano);
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }
}
