import javax.swing.*;

public class Aluno extends FaculdadeFrame{
    private JPanel rootPanel;
    private JTextField textNome;
    private JTextField textSobrenome;
    private JRadioButton radioBES;
    private JRadioButton radioBCC;
    private JRadioButton radioADS;
    private JCheckBox checPromo;
    private JButton buttonSair;
    private JButton buttonSalvar;

    public Aluno() {
        this.setContentPane(rootPanel);
        this.setSize(600,350);
        this.setTitle("Cadastro de Alunos");

        super.defautConfigurations();
    }

}
