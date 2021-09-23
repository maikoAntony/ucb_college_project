package UI;

import Business.AlunoBusiness;
import Entity.AlunoEntity;
import Entity.CursoTipo;
import Infrastructure.ValidateException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aluno extends FaculdadeFrame {
    private JPanel rootPanel;
    private JTextField textNome;
    private JTextField textSobrenome;
    private JRadioButton radioBES;
    private JRadioButton radioBCC;
    private JRadioButton radioADS;
    private JCheckBox checPromo;
    private JButton buttonSair;
    private JButton buttonSalvar;

    private AlunoBusiness mAlunoBusiness;

    public Aluno() {
        this.setContentPane(rootPanel);
        this.setSize(650, 350);
        this.setTitle("Cadastro de Alunos");

        super.defautConfigurations();

        this.mAlunoBusiness = new AlunoBusiness();

        this.radioBES.setSelected(true);
        this.setEvents();
    }

    private void setEvents() {
        this.buttonSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSave();
            }
        });
        this.buttonSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Main();
                dispose();
            }
        });
    }

    private void handleSave() {
        try {
            String nome = this.textNome.getText().trim();
            String sobrenome = this.textSobrenome.getText().trim();

            CursoTipo cursoTipo;
            if (radioADS.isSelected())
                cursoTipo = CursoTipo.ADS;
            else if (radioBCC.isSelected())
                cursoTipo = CursoTipo.BCC;
            else
                cursoTipo = CursoTipo.BES;

            boolean promo = this.checPromo.isSelected();

            AlunoEntity alunoEntity = new AlunoEntity(nome, sobrenome, cursoTipo, promo);
            this.mAlunoBusiness.validate(alunoEntity);
            this.mAlunoBusiness.create(alunoEntity);
        } catch (ValidateException e){
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Dados Incompletos", JOptionPane.ERROR_MESSAGE);
        }
    }

}
