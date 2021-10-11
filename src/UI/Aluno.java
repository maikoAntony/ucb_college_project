package UI;

import Business.AlunoBusiness;
import Entity.AbstractAluno;
import Entity.AlunoPromoEntity;
import Entity.AlunoRegularEntity;
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

    private final AlunoBusiness mAlunoBusiness;
    private int mAlunoID = 0;

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
    //pega os dados, cria, valida, e cria no banco de dados
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


            AbstractAluno abstractAluno;
            if(this.checPromo.isSelected()) {
                abstractAluno = new AlunoPromoEntity(nome, sobrenome, cursoTipo);
            }else {
                abstractAluno = new AlunoRegularEntity(nome, sobrenome, cursoTipo);
            }

            this.mAlunoBusiness.validate(abstractAluno);

            //Salva Aluno
            if(mAlunoID == 0){
                this.mAlunoBusiness.create(abstractAluno);
            }else{
                abstractAluno.setId(this.mAlunoID);
                this.mAlunoBusiness.update(abstractAluno);
            }

            new Main();
            dispose();

        } catch (ValidateException e) {
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Dados Incompletos", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void setAlunoID(int id){
        this.mAlunoID = id;

        AbstractAluno abstractAluno = this.mAlunoBusiness.getAlunoById(id);
        this.textNome.setText(abstractAluno.getNome());
        this.textSobrenome.setText(abstractAluno.getSobrenome());
        this.checPromo.setSelected(abstractAluno.isPromo());
        this.radioBES.setSelected(abstractAluno.getCursoTipo() == CursoTipo.BES);
        this.radioBCC.setSelected(abstractAluno.getCursoTipo() == CursoTipo.BCC);
        this.radioADS.setSelected(abstractAluno.getCursoTipo() == CursoTipo.ADS);
        
    }

}
