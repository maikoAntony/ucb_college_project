package UI;

import Business.AlunoBusiness;
import Entity.AlunoEntity;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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

    private AlunoBusiness malunoBusiness;
    /**
     * Construtor
     */
    public Main() {
        this.setContentPane(rootPanel);
        this.setSize(800, 450);
        this.setTitle("Faculdade >>>");

        this.malunoBusiness = new AlunoBusiness();

        //Chama a configuração padrão
        super.defautConfigurations();

        //Atribui enventos
        this.setEvents();

        this.loadData();
    }
    /*
    Atribui eventos aos elementos da interface
     */
    private void setEvents(){
        // Novo aluno
        this.buttonNovo.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Aluno();
                dispose();
            }
        });
        //Exluir Aluno
        this.buttonExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO
            }
        });
        //Editar aluno
        this.buttonEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO
            }
        });
        //Gera boleto de mensalidade
        this.buttonMensalidade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Mensalidade();
                dispose();
            }
        });
    }

    private void loadData(){
        List<AlunoEntity> list = this.malunoBusiness.getList();

        String[] columnNames = {"Nome", "Sobrenome", "Curso", "Promocional", "ID"};
        DefaultTableModel model = new DefaultTableModel(new Object[0][0], columnNames);

        for (AlunoEntity alunoEntity: list){
            Object[] o = new Object[5];
            o[0] = alunoEntity.getNome();
            o[1] = alunoEntity.getSobrenome();
            o[2] = alunoEntity.getCursoTipo();
            o[3] = alunoEntity.isPromo() ? "Sim": "Não";
            o[4] = alunoEntity.getId();

            model.addRow(o);
        }
        this.tableAlunos.clearSelection();
        this.tableAlunos.setModel(model);
    }
}
