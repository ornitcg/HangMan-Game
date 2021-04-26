import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class TopPanel extends JPanel {
    JLabel nameLbl;

    public TopPanel(int width, int height){
        nameLbl = new JLabel("HANG MAN GAME");
        nameLbl.setFont(new Font("Arial", Font.BOLD, 70));
        nameLbl.setForeground(Color.decode("#009f93"));


        add(nameLbl, BorderLayout.CENTER);

    }
}

