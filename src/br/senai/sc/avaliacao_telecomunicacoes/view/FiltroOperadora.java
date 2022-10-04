package br.senai.sc.avaliacao_telecomunicacoes.view;

import br.senai.sc.avaliacao_telecomunicacoes.model.entities.Operadora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * "Modal" usado para filtrar a lista de Planos, com uma caixa de seleção de Operadora para que o usuário possa
 * ver uma lista de planos somente de uma operadora específica, que será determinado aqui.
 */
public class FiltroOperadora extends JFrame {
    private JPanel painelFiltro;
    private JComboBox operadoraInput;
    private JButton filtrarButton;

    public FiltroOperadora() {
        criarComponentes();
        filtrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ListaPlanos listaPlanos = new ListaPlanos((Operadora) operadoraInput.getSelectedItem());
                listaPlanos.setVisible(true);
            }
        });
    }

    private void criarComponentes() {
        operadoraInput.setModel(new DefaultComboBoxModel(Operadora.values()));

        setContentPane(painelFiltro);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }
}
