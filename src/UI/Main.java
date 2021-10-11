package UI;

import Business.AlunoBusiness;
import Entity.AlunoEntity;
import Entity.InscriçõesEntity;
import Infrastructure.ValidateException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
    private int mAlunoId = 0;
    /**
     * Construtor
     */
    public Main() {
        this.setContentPane(rootPanel);
        this.setSize(800, 450);
        this.setTitle("WING COLLEGE ");

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
                try{
                    malunoBusiness.delete(mAlunoId);
                    mAlunoId = 0;
                    loadData();
                }catch (ValidateException excp){
                    JOptionPane.showMessageDialog(new JFrame(), "É necessário selecionar um aluno!", "Aluno não selecionado!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        //Editar aluno
        this.buttonEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mAlunoId == 0){
                    JOptionPane.showMessageDialog(new JFrame(), "É necessário selecionar um aluno!", "Aluno não selecionado!", JOptionPane.ERROR_MESSAGE);
                }else{
                    Aluno aluno = new Aluno();
                    aluno.setAlunoID(mAlunoId);
                    dispose();
                }
            }
        });
        //Gera boleto de mensalidade
        this.buttonMensalidade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mAlunoId == 0){
                    JOptionPane.showMessageDialog(new JFrame(), "É necessário selecionar um aluno!", "Aluno não selecionado!", JOptionPane.ERROR_MESSAGE);
                }else {
                    Mensalidade mensalidade = new Mensalidade();
                    mensalidade.setAlunoID(mAlunoId);
                    dispose();
                }
            }
        });

        this.tableAlunos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(e.getValueIsAdjusting()){

                    if(tableAlunos.getSelectedRow() != -1){
                        mAlunoId = Integer.parseInt(tableAlunos.getModel().getValueAt(tableAlunos.getSelectedRow(), 4).toString());
                    }
                }
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
        this.tableAlunos.removeColumn(this.tableAlunos.getColumnModel().getColumn(4));

        InscriçõesEntity inscriçõesEntity = this.malunoBusiness.getInscrições();
        this.labelEng.setText("BES: " + inscriçõesEntity.getBES());
        this.labelCiencias.setText("BCC: " + inscriçõesEntity.getBCC());
        this.labelADS.setText("ADS: " + inscriçõesEntity.getADS());
    }
}
