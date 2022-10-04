package br.senai.sc.avaliacao_telecomunicacoes.model.dao;

import br.senai.sc.avaliacao_telecomunicacoes.model.entities.Operadora;
import br.senai.sc.avaliacao_telecomunicacoes.model.entities.Plano;
import br.senai.sc.avaliacao_telecomunicacoes.model.exception.*;
import br.senai.sc.avaliacao_telecomunicacoes.model.factory.ConexaoFactory;
import br.senai.sc.avaliacao_telecomunicacoes.model.factory.PlanoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Classe usada para conexão com o banco em todas as transações envolvendo planos, como cadastro, remoção, edição e
 * seleção de diferentes maneiras (lista com todos os planos, lista com planos de somente uma operadora e seleção
 * de um único plano).
 */
public class PlanoDAO {

    Connection conn;

    public PlanoDAO() throws ErroConexao {
        this.conn = new ConexaoFactory().conectaDB();
    }

    public void cadastrarPlano(Plano plano) throws Exception {
        String sql = "INSERT INTO PLANO (NOME, QTD_DADOS, QTD_DADOS_BONUS, BENEFICIOS, VALOR, OPERADORA) VALUES (?,?,?,?,?,?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, plano.getNomePlano());
            stmt.setDouble(2, plano.getQtdDadosPlano());
            if (plano.getQtdDadosBonusPlano() != null) {
                stmt.setDouble(3, plano.getQtdDadosBonusPlano());
            } else {
                stmt.setString(3, null);
            }
            stmt.setString(4, plano.getBeneficiosPlano());
            stmt.setDouble(5, plano.getValorPlano());
            stmt.setString(6, plano.getOperadoraPlano().toString());

            try {
                stmt.execute();
            } catch (Exception exception) {
                throw new ErroExecucao();
            }
        } catch (Exception exception) {
            if (exception instanceof ErroExecucao) {
                throw exception;
            }
            throw new ErroPreparacao();
        }
    }

    public void removerPlano(Integer identificador) throws Exception {
        String sql = "DELETE FROM PLANO WHERE ID = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, identificador);

            try {
                stmt.execute();
            } catch (Exception exception) {
                throw new ErroExecucao();
            }
        } catch (Exception exception) {
            if (exception instanceof ErroExecucao) {
                throw exception;
            }
            throw new ErroPreparacao();
        }
    }

    public void atualizarPlano(Integer identificador, Plano planoNovo) throws Exception {
        String sql = "UPDATE PLANO SET NOME = ?, " +
                "QTD_DADOS = ?, " +
                "QTD_DADOS_BONUS = ?, " +
                "BENEFICIOS = ?, " +
                "VALOR = ?, " +
                "OPERADORA = ? WHERE ID = ?;";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            //Dados
            stmt.setString(1, planoNovo.getNomePlano());
            stmt.setDouble(2, planoNovo.getQtdDadosPlano());
            if (planoNovo.getQtdDadosBonusPlano() != null) {
                stmt.setDouble(3, planoNovo.getQtdDadosBonusPlano());
            } else {
                stmt.setString(3, null);
            }
            stmt.setString(4, planoNovo.getBeneficiosPlano());
            stmt.setDouble(5, planoNovo.getValorPlano());
            stmt.setString(6, planoNovo.getOperadoraPlano().toString());
            stmt.setInt(7, identificador);

            try {
                stmt.execute();
            } catch (Exception exception) {
                throw new ErroExecucao();
            }
        } catch (Exception exception) {
            if (exception instanceof ErroExecucao) {
                throw exception;
            }
            throw new ErroPreparacao();
        }
    }

    public Collection<Plano> selecionarTodos(String ordenacao) throws Exception {
        String sql = "SELECT ID, NOME, QTD_DADOS, VALOR, OPERADORA FROM PLANO ORDER BY ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ordenacao);

            try (ResultSet resultSet = stmt.executeQuery()) {
                Collection<Plano> listaPlanos = new ArrayList<>();
                while (resultSet != null && resultSet.next()) {
                    listaPlanos.add(extrairObjetoIncompleto(resultSet));
                }
                return listaPlanos;
            } catch (Exception exception) {
                if (exception instanceof ErroTratamento) {
                    throw exception;
                }
                throw new ErroExecucao();
            }
        } catch (Exception exception) {
            if (exception instanceof ErroExecucao || exception instanceof ErroTratamento) {
                throw exception;
            }
            throw new ErroPreparacao();
        }
    }

    public Collection<Plano> selecionarPorOperadora(Operadora operadora) throws Exception {
        String sql = "SELECT ID, NOME, QTD_DADOS, VALOR, OPERADORA FROM PLANO WHERE OPERADORA = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, operadora.toString());

            try (ResultSet resultSet = stmt.executeQuery()) {
                Collection<Plano> listaPlanos = new ArrayList<>();
                while (resultSet != null && resultSet.next()) {
                    listaPlanos.add(extrairObjetoIncompleto(resultSet));
                }
                return listaPlanos;
            } catch (Exception exception) {
                if (exception instanceof ErroTratamento) {
                    throw exception;
                }
                throw new ErroExecucao();
            }
        } catch (Exception exception) {
            if (exception instanceof ErroExecucao || exception instanceof ErroTratamento) {
                throw exception;
            }
            throw new ErroPreparacao();
        }
    }

    public Plano selecionarPlano(Integer identificador) throws Exception {
        String sql = "SELECT * FROM PLANO WHERE ID = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, identificador);

            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet != null && resultSet.next()) {
                    return extrairObjetoCompleto(resultSet);
                }
            } catch (Exception exception) {
                if (exception instanceof ErroTratamento) {
                    throw exception;
                }
                throw new ErroExecucao();
            }
        } catch (Exception exception) {
            if (exception instanceof ErroExecucao || exception instanceof ErroTratamento) {
                throw new ErroExecucao();
            }
            throw new ErroPreparacao();
        }
        throw new RuntimeException("Plano Inválido!");
    }

    public Plano extrairObjetoCompleto(ResultSet resultSet) throws ErroTratamento {
        try {
            return new PlanoFactory().getPlano(
                    resultSet.getInt("id"),
                    resultSet.getString("nome"),
                    resultSet.getString("beneficios"),
                    resultSet.getDouble("qtd_dados"),
                    resultSet.getDouble("qtd_dados_bonus"),
                    resultSet.getDouble("valor"),
                    resultSet.getString("operadora"));
        } catch (Exception exception) {
            throw new ErroTratamento();
        }
    }

    public Plano extrairObjetoIncompleto(ResultSet resultSet) throws ErroTratamento {
        try {
            return new PlanoFactory().getPlano(
                    resultSet.getInt("id"),
                    resultSet.getString("nome"),
                    null,
                    resultSet.getDouble("qtd_dados"),
                    null,
                    resultSet.getDouble("valor"),
                    resultSet.getString("operadora"));
        } catch (Exception exception) {
            throw new ErroTratamento();
        }
    }
}
