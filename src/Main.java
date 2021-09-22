import javax.swing.*;

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

    }
}
