 package br.senai.sc.avaliacao_telecomunicacoes.view;

import br.senai.sc.avaliacao_telecomunicacoes.controller.PlanoController;
import br.senai.sc.avaliacao_telecomunicacoes.model.entities.Operadora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 /**
  * Tela para listagem dos planos existentes no sistema, com opção de filtro por Operadora (chama o "modal"
  * FiltroOperadora), remoção de Planos selecionados pelo usuário e edição de planos (o que redireciona para a tela
  * de cadastro, com o idPlano definido.
  */
 public class ListaPlanos extends JFrame {
    private JPanel painelLista;
    private JButton filtrarButton;
    private JTable table1;
    private JButton voltarButton;
    private JButton editarButton;
    private JButton removerButton;

     public ListaPlanos(Operadora operadora) {
        criarComponentes(operadora);
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MenuPrincipal menuPrincipal = new MenuPrincipal();
                menuPrincipal.setVisible(true);
            }
        });
        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(table1.getSelectedRow() > -1) {
                    Integer idPlano = (Integer) table1.getValueAt(table1.getSelectedRow(), 0);
                    PlanoController controller = new PlanoController();
                    try {
                        controller.removerPlano(idPlano);
                        JOptionPane.showMessageDialog(null, "Plano Removido com Sucesso!");
                        dispose();
                        ListaPlanos listaPlanos = new ListaPlanos(null);
                        listaPlanos.setVisible(true);
                    } catch (RuntimeException exception) {
                        JOptionPane.showMessageDialog(null, exception.getMessage());
                    }
                }
            }
        });
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(table1.getSelectedRow() > -1) {
                    Integer idPlano = (Integer) table1.getValueAt(table1.getSelectedRow(), 0);
                    dispose();
                    CadastroPlano cadastroPlano = new CadastroPlano(idPlano);
                    cadastroPlano.setVisible(true);
                }
            }
        });
        filtrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                FiltroOperadora filtroOperadora = new FiltroOperadora();
                filtroOperadora.setVisible(true);
            }
        });
    }

    private void criarComponentes(Operadora operadora) {
        PlanoController controller = new PlanoController();
        if(operadora == null) {
            table1.setModel(new DefaultTableModelPlanos(controller.buscarTodos()));
        } else {
            table1.setModel(new DefaultTableModelPlanos(controller.buscarPorOperadora(operadora)));
        }
        table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        setContentPane(painelLista);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }
}
