package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mensalidade extends FaculdadeFrame {
    private JPanel rootPanel;
    private JLabel labelNS;
    private JLabel LabelCurso;
    private JButton buttonSair;

    public Mensalidade(){
        this.setContentPane(rootPanel);
        this.setSize(600, 200);
        this.setTitle("Mensalidade");

        super.defautConfigurations();
        this.setEvents();
    }
    private void setEvents(){
        this.buttonSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Main();
                dispose();
            }
        });
    }
}
