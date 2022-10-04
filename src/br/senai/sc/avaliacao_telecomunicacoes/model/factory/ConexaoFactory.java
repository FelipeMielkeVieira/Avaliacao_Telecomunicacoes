package br.senai.sc.avaliacao_telecomunicacoes.model.factory;

import br.senai.sc.avaliacao_telecomunicacoes.model.exception.ErroConexao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Classe usada para criação de uma conexão com o banco de dados usado no sistema, usando a função conectaDB() com
 * as informações de url, usuário e senha do usuário para conectar ao banco de dados "planos-telecomunicacoes", feito
 * em linguagem SQL.
 */
public class ConexaoFactory {

    String URL = "jdbc:mysql://localhost:3306/planos_telecomunicacoes";
    String USER = "root";
    String PASSWORD = "root";

    public Connection conectaDB() throws ErroConexao {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception exception) {
            throw new ErroConexao();
        }
    }
}
