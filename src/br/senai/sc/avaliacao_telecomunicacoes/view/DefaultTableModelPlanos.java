package br.senai.sc.avaliacao_telecomunicacoes.view;

import br.senai.sc.avaliacao_telecomunicacoes.model.entities.Plano;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Classe usada como modelo para uso de tabelas, usada especialmente para listagem de Planos.
 * Usa como base o AbstractTableModel, que já possui métodos abstratos para sua criação.
 */
public class DefaultTableModelPlanos extends AbstractTableModel {

    List<Plano> dados;
    String[] colunas;

    public DefaultTableModelPlanos(Collection<Plano> lista) {
        this.dados = new ArrayList<>(lista);
        this.colunas = new String[]{"ID", "Nome", "Operadora", "Qtd de Dados", "Valor"};
    }

    @Override
    public int getRowCount() {
        try {
            return dados.size();
        } catch (Exception exception) {
            return 0;
        }
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Plano plano = dados.get(rowIndex);
        switch (columnIndex) {
            case 0 -> {
                return plano.getIdPlano();
            }
            case 1 -> {
                return plano.getNomePlano();
            }
            case 2 -> {
                return plano.getOperadoraPlano();
            }
            case 3 -> {
                return plano.getQtdDadosPlano();
            }
            case 4 -> {
                return plano.getValorPlano();
            }
            default -> {
                return plano;
            }
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }
}
