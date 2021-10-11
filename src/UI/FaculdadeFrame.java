package UI;

import javax.swing.*;
import java.awt.*;

public class FaculdadeFrame extends JFrame {
    public void defautConfigurations(){

        //Janla iniciada no centro da tela
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dimension.width / 2 - this.getSize().width / 2, dimension.height / 2 - this.getSize().height / 2);

        // Visivel ao usuario
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}