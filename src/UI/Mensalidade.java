package UI;

import Business.AlunoBusiness;
import Entity.AlunoEntity;
import Entity.CursoTipo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mensalidade extends FaculdadeFrame {
    private JPanel rootPanel;
    private JLabel labelNS;
    private JButton buttonSair;
    private JLabel labelCurso;
    private JLabel labelMensalidade;

    private AlunoBusiness malunoBusiness;

    public Mensalidade(){
        this.setContentPane(rootPanel);
        this.setSize(600, 200);
        this.setTitle("Mensalidade");

        this.malunoBusiness = new AlunoBusiness();

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

    public void setAlunoID(int id){
        AlunoEntity alunoEntity = this.malunoBusiness.getAlunoById(id);

        this.labelNS.setText(String.format("%s %s",  alunoEntity.getNome(), alunoEntity.getSobrenome()));
        this.labelCurso.setText(alunoEntity.getCursoTipo().toString());

        float custo = 500;
        if (alunoEntity.isPromo()){
            this.labelMensalidade.setText(String.format("R$ %.2f", custo * 0.7));
        }else{
            this.labelMensalidade.setText(String.format("R$ %.2f", custo));
        }


    }
}