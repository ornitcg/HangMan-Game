import javax.swing.*;

public class BottomPanel extends JPanel {

    public BottomPanel(int width, int height, GameWord gameWord){
        JLabel wordLbl = new JLabel(gameWord.get_wordCurtain());
        add(wordLbl);


    }

}
