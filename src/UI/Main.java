package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Main extends FaculdadeFrame {
    private JPanel rootPanel;
    private JTable tableAlunos;
    private JButton buttonNovo;
    private JButton buttonExcluir;
    private JButton buttonEditar;
    private JButton buttonMensalidade;
    private JLabel labelEng;
    private JLabel labelCiencias;
    private JLabel labelADS;

    public Main() {
        this.setContentPane(rootPanel);
        this.setSize(800, 450);
        this.setTitle("Faculdade >>>");

        super.defautConfigurations();

        this.setEvents();
    }
    private void setEvents(){
        // Classe Anonima
        this.buttonNovo.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Aluno();
                dispose();
            }
        });
    }
}
