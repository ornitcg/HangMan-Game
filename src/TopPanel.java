import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/*
   This class creates a general top panel of a game including star/exit buttons and the game title
*/

public class TopPanel extends JPanel {

    private JButton _startButton;
    private JButton _exitButton;
    private JLabel _nameLbl;


    public TopPanel(int width, int height, String gameName){
        _startButton = new JButton("START NEW GAME");
        _startButton.setForeground(Color.white);
        _startButton.setBackground(Color.decode("#007200"));

        _exitButton = new JButton("EXIT");
        _exitButton.setForeground(Color.white);
        _exitButton.setBackground(Color.decode("#f21b3f"));

        _nameLbl = new JLabel(gameName);
        _nameLbl.setFont(new Font("Arial", Font.BOLD, 70));
        _nameLbl.setForeground(Color.decode("#009f93"));

        add(_exitButton, BorderLayout.WEST);
        add(_nameLbl, BorderLayout.CENTER);
        add(_startButton, BorderLayout.EAST);

    }
}

