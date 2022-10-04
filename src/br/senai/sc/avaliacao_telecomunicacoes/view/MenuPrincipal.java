package br.senai.sc.avaliacao_telecomunicacoes.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe Executável usada para exibir o menu principal, redirecionando para as telas de cadastro de Planos,
 * ver a lista de planos, e até a opção de sair do programa.
 *
 * @author Felipe Mielke Vieira
 */
public class MenuPrincipal extends JFrame implements Runnable {
    private JPanel painelMenu;
    private JButton cadastrarPlanoButton;
    private JButton verPlanosButton;
    private JButton sairButton;

    public static void main(String[] args) {
        MenuPrincipal programa = new MenuPrincipal();
        programa.run();
    }

    public MenuPrincipal() {
        criarComponentes();
        cadastrarPlanoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                CadastroPlano cadastroPlano = new CadastroPlano(0);
                cadastroPlano.setVisible(true);
            }
        });
        verPlanosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ListaPlanos listaPlanos = new ListaPlanos(null);
                listaPlanos.setVisible(true);
            }
        });
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public void criarComponentes() {
        setContentPane(painelMenu);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }

    @Override
    public void run() {
        if(!isVisible()) {
            setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "O Painel já está aberto!");
        }
    }
}
