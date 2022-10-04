package br.senai.sc.avaliacao_telecomunicacoes.view;

import br.senai.sc.avaliacao_telecomunicacoes.controller.PlanoController;
import br.senai.sc.avaliacao_telecomunicacoes.model.entities.Operadora;
import br.senai.sc.avaliacao_telecomunicacoes.model.entities.Plano;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Tela usada para preenchimento de dados necessários para posterior cadastro de Planos, invocando o PlanoController
 * para prosseguir com a função.
 *
 * Também pode ser usada para edição de um Plano, dependendo do parâmetro recebido em sua criação (se o ID do Plano
 * for igual à 0, significa que é um cadastro de um novo plano.
 */
public class CadastroPlano extends JFrame {
    private JPanel painelCadastro;
    private JTextField nomeInput;
    private JTextField qtdDadosInput;
    private JTextField qtdBonusInput;
    private JTextField beneficiosInput;
    private JTextField valorInput;
    private JComboBox operadoraInput;
    private JButton voltarButton;
    private JButton editarButton;
    private JButton cadastrarButton;
    private Integer idPlano;

    public CadastroPlano(Integer idPlano) {
        this.idPlano = idPlano;
        criarComponentes();
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MenuPrincipal menuPrincipal = new MenuPrincipal();
                menuPrincipal.setVisible(true);
            }
        });
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nomeInput.getText().isEmpty() || qtdDadosInput.getText().isEmpty() || qtdBonusInput.getText().isEmpty()
                        || beneficiosInput.getText().isEmpty() || valorInput.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Faltam campos a serem preenchidos!");
                } else {
                    PlanoController controller = new PlanoController();
                    try {
                        controller.atualizarPlano(idPlano, nomeInput.getText(), beneficiosInput.getText(),
                                Double.valueOf(qtdDadosInput.getText()), Double.valueOf(qtdBonusInput.getText()),
                                Double.valueOf(valorInput.getText()), (Operadora) operadoraInput.getSelectedItem());
                        JOptionPane.showMessageDialog(null, "Edição efetuada com sucesso!");
                        dispose();
                        ListaPlanos listaPlanos = new ListaPlanos(null);
                        listaPlanos.setVisible(true);
                    } catch (RuntimeException exception) {
                        JOptionPane.showMessageDialog(null, exception.getMessage());
                    }
                }
            }
        });
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nomeInput.getText().isEmpty() || qtdDadosInput.getText().isEmpty() || qtdBonusInput.getText().isEmpty()
                        || beneficiosInput.getText().isEmpty() || valorInput.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Faltam campos a serem preenchidos!");
                } else {
                    PlanoController controller = new PlanoController();
                    try {
                        controller.cadastrarPlano(nomeInput.getText(), beneficiosInput.getText(),
                                Double.valueOf(qtdDadosInput.getText()), Double.valueOf(qtdBonusInput.getText()),
                                Double.valueOf(valorInput.getText()), (Operadora) operadoraInput.getSelectedItem());
                        JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
                        dispose();
                        MenuPrincipal menuPrincipal = new MenuPrincipal();
                        menuPrincipal.setVisible(true);
                    } catch (RuntimeException exception) {
                        JOptionPane.showMessageDialog(null, exception.getMessage());
                    }
                }
            }
        });
    }

    public void criarComponentes() {
        operadoraInput.setModel(new DefaultComboBoxModel(Operadora.values()));
        setContentPane(painelCadastro);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();

        if (idPlano == 0) {
            editarButton.setVisible(false);
        } else {
            cadastrarButton.setVisible(false);
            PlanoController controller = new PlanoController();
            Plano plano = controller.buscarPlano(idPlano);

            nomeInput.setText(plano.getNomePlano());
            qtdDadosInput.setText(plano.getQtdDadosPlano().toString());
            qtdBonusInput.setText(plano.getQtdDadosBonusPlano().toString());
            beneficiosInput.setText(plano.getBeneficiosPlano());
            valorInput.setText(plano.getValorPlano().toString());
            operadoraInput.setSelectedItem(plano.getOperadoraPlano());
        }
    }
}
