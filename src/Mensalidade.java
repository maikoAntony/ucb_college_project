import javax.swing.*;

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
    }
}
